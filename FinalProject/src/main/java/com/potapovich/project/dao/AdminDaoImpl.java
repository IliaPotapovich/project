package com.potapovich.project.dao;

import com.potapovich.project.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDaoImpl {


    public void createAdmin(){
        String insertedCar = "insert into admin (admin_name, admin_password)"
                + "values (?, ?);";

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertedCar)) {

            preparedStatement.setString(1, "Admin");
            preparedStatement.setString(2, "Admin");

            preparedStatement.execute();


        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }


  /*  public void changeAdminPassword(String name, String password){
        String insertedCar = "UPDATE admin SET admin_password = '" + password + "'"
                + "VALUES (?, ?) WHERE admin_name='" + name + "'";

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertedCar)) {

            preparedStatement.setString(1, "Admin");
            preparedStatement.setString(2, "Admin");

            preparedStatement.execute();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */




}
