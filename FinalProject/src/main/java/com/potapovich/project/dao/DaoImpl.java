package com.potapovich.project.dao;

import com.potapovich.project.pool.ConnectionPool;

import java.sql.Connection;

public class DaoImpl {


    public int create(){

        Connection connection = ConnectionPool.getInstance().getConnection();

       ConnectionPool connection1 = ConnectionPool.getInstance();




        int a = 1;

return a;
    }





}
