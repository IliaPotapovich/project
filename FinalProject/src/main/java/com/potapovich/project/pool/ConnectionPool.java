package com.potapovich.project.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {


    private final static int POOL_SIZE = 10;
    private static final Logger LOGGER = LogManager.getLogger();
    private static ConnectionPool instance;
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static ReentrantLock lock = new ReentrantLock();
    private BlockingQueue<ProxyConnection> queue;


    private ConnectionPool() {

        if (instance != null) {
            throw new RuntimeException("Reflection defender");
        }

        createPool();

    }


    public static ConnectionPool getInstance() {


        if (!instanceCreated.get()) {
            lock.lock();
            try {

                if (instance == null) {
                    instance = new ConnectionPool();
                    instanceCreated.set(true);
                }
            }
            finally {
                lock.unlock();
            }


        }
        return instance;

    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


    private Properties findConfigFromProp(String path){
        Properties properties = new Properties();
        File file = new File(path);
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "IOException " + e.getMessage());
        }
        return properties;
    }


    public void createPool() {
        ProxyConnection proxyConnection;

        Properties urlProperties = findConfigFromProp("C:\\dev\\eproject\\src\\main\\webapp\\WEB-INF\\classes\\properties\\url.properties");
        String url = urlProperties.getProperty("url");

        Properties properties = findConfigFromProp("C:\\dev\\eproject\\src\\main\\webapp\\WEB-INF\\classes\\properties\\configuration.properties");

        queue = new ArrayBlockingQueue(POOL_SIZE);

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            for (int i = 0; i < POOL_SIZE; i++) {

                Connection connection = DriverManager.getConnection(url, properties);

                proxyConnection = new ProxyConnection(connection);


                queue.offer(proxyConnection);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQLException " + e.getMessage());
        }
    }


    public ProxyConnection getConnection() {
        ProxyConnection proxyConnection = new ProxyConnection();
        try {
            proxyConnection = queue.take();

        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "InterruptedException " + e.getMessage());

        }

        return proxyConnection;
    }


    public void returnConnection(ProxyConnection proxyConnection) {

        try {
            queue.put(proxyConnection);
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "InterruptedException " + e.getMessage());
        }

    }


    public void releasePool() {
        ProxyConnection proxyConnection;
        try {
            for (int i = 0; i < POOL_SIZE; i++) {

                proxyConnection = queue.take();
                proxyConnection.closeConnection();

            }
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "InterruptedException " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, "SQLException " + e.getMessage());
        }
        finally {
            try {
                DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
            } catch (SQLException e) {
                LOGGER.log(Level.ERROR, "SQLException " + e.getMessage());
            }
        }
    }


}
