package com.potapovich.project.dao;

import com.potapovich.project.entity.TaxiDriver;
import com.potapovich.project.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxiDriverDaoImpl {


    public void driverRegistration(TaxiDriver driver){

        String insertedDriver = "insert into taxi_drivers (driver_name, experience, status, driver_password)"
                + "values (?, ?, ?, ?);";

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertedDriver)) {


                preparedStatement.setString(1, driver.getDriverName());
                preparedStatement.setInt(2, driver.getExperience());
                preparedStatement.setBoolean(3, driver.isBanned());
                preparedStatement.setString(4,driver.getDriverPassword());
                preparedStatement.execute();


        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public TaxiDriver findDriverById(int id){

        TaxiDriver driver = new TaxiDriver();

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select driver_id, driver_name, experience, status from taxi_drivers where driver_id='" + id + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

            System.out.println(id);


                while (rs.next()) {

                    driver.setDriverId(rs.getInt(1));
                    driver.setDriverName(rs.getString(2));
                    driver.setExperience(rs.getInt(3));
                    driver.setBanned(rs.getBoolean(4));
                }
            System.out.println(driver);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public TaxiDriver findDriverByName(String name){

        TaxiDriver driver = new TaxiDriver();

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select driver_id, driver_name, experience, status from taxi_drivers where driver_name='" + name + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

            System.out.println(name);


            while (rs.next()) {

                driver.setDriverId(rs.getInt(1));
                driver.setDriverName(rs.getString(2));
                driver.setExperience(rs.getInt(3));
                driver.setBanned(rs.getBoolean(4));
            }
            System.out.println(driver);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }


    public TaxiDriver findDriverByLoginAndPassword(String name, String password){

        TaxiDriver driver = new TaxiDriver();
        int id = findDriverIdByEnteredLoginAndPassword(name, password);
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select driver_id, driver_name, experience, status, driver_password from taxi_drivers where driver_name='" + name + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

            System.out.println("NAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMEEEEEEEEEEE"+name);

            System.out.println("НАЙДЕНЫЙ АЙДИ " + id);
            if (id>0) {
                while (rs.next()) {

                    driver.setDriverId(rs.getInt(1));
                    driver.setDriverName(rs.getString(2));
                    driver.setExperience(rs.getInt(3));
                    driver.setBanned(rs.getBoolean(4));
                    driver.setDriverPassword(rs.getString(5));
                }
            }
            else {
                driver.setDriverId(id);
            }
            System.out.println(driver);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(",E,E,E,E,E,E,EL,DMGKNDKBKDMBVKDMBKMKM" + driver);
        return driver;
    }




    public int findDriverIdByEnteredLoginAndPassword(String name, String password){

        int result = 0;

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select driver_id, driver_password from taxi_drivers where driver_name='"+ name +"'");
            ResultSet rs = preparedStatement.executeQuery()) {


            while (rs.next()) {

                int customerId = rs.getInt(1);

                String realPassword = rs.getString(2);

                if (realPassword.equals(password)){
                    result = customerId;
                    System.out.println("AOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO pass " + realPassword);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



}
