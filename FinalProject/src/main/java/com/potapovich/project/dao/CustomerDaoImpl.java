package com.potapovich.project.dao;

import com.potapovich.project.entity.Customer;
import com.potapovich.project.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {

    //private Connection connection = ConnectionPool.getInstance().getConnection();

    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void registerUser(Customer customer) {

        String insertUser = "insert into customer (name, phone_number, status, discount, trip_number, login, password)"
                + "values (?, ?, ?, ?, ?, ?, ?);";

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser)) {
            System.out.println("isLoginExist "+isLoginExist(customer.getLogin()));
            System.out.println("login   "+customer.getLogin());
            System.out.println("isNameExist "+isNameExist(customer.getName()));
            System.out.println("pass   "+customer.getPassword());



          //  if (!isLoginExist(customer.getLogin()) &&  !isNameExist(customer.getName())) {

                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getPhoneNumber());
                preparedStatement.setBoolean(3, customer.isBanned());
                preparedStatement.setInt(4, customer.getDiscountProcent());
                preparedStatement.setInt(5, customer.getCountOfTrip());
                preparedStatement.setString(6, customer.getLogin());
                preparedStatement.setString(7, customer.getPassword());
                preparedStatement.execute();
        //    }
          //  else {
          //      System.out.println("AAAAAAAAAAAa");
          //  }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Customer findRealLoginAndPassIfExist(String login, String password) {
        Customer customer =new Customer();

        int id = findCustomerIdByEnteredLoginAndPassword(login, password);

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select login, password from customer where customer_id='" + id + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

            System.out.println(id);
            if (id>0) {
                customer.setId(id);
                while (rs.next()) {
                    customer.setLogin(rs.getString(1));
                    customer.setPassword(rs.getString(2));
                }
            }
            else {
                customer.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }







    @Override
    public Customer readUser(int id) {
        Customer customer =new Customer();
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select customer_id, name, phone_number, status, discount, trip_number from customer where customer_id='" + id + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

                while (rs.next()) {

                    customer.setId(rs.getInt(1));
                    customer.setName(rs.getString(2));
                    customer.setPhoneNumber(rs.getString(3));
                    customer.setBanned(rs.getBoolean(4));
                    customer.setDiscountProcent(rs.getInt(5));
                    customer.setCountOfTrip(rs.getInt(6));

                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }



    public int findCustomerIdByEnteredLoginAndPassword(String login, String password){

        int result = 0;

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select customer_id, password from customer where login='"+ login +"'");
            ResultSet rs = preparedStatement.executeQuery()) {


        while (rs.next()) {

            int customerId = rs.getInt(1);

            String realPassword = rs.getString(2);
            if (realPassword.equals(password)){
                result = customerId;
            }

        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public boolean isLoginExist(String login){

        boolean result = false;

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select login from customer where login='"+ login +"'");
            ResultSet rs = preparedStatement.executeQuery()) {

        System.out.println("LOGIN   "+login);

        while (rs.next()) {
            String existLogin = rs.getString(1);
            System.out.println("exist log "+existLogin);
            if (login.equals(existLogin)) {
                result = true;
            }
            else {
                result = false;
            }
        }
        } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;

    }




    public boolean isNameExist(String name){

        boolean result = false;

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select name from customer where name='"+ name +"'");
            ResultSet rs = preparedStatement.executeQuery()) {
            System.out.println("name   "+name);


            while (rs.next()) {
                String existName = rs.getString(1);

                System.out.println("NAME "+existName);
                if (name.equals(existName)) {
                    result = true;
                }
                else {
                    result = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }









/*

    public Customer readUser(String login, String password) {
        Customer customer =new Customer();
        try {
            PreparedStatement preparedStatement =null;
            ResultSet rs = null;

            int id = findCustomer(login, password);
            System.out.println(id);

            // Connection connection = ConnectionPool.getInstance().getConnection();
            preparedStatement = connection.prepareStatement("select customer_id, name, phone_number, status, discount, trip_number, login, password from customer where customer_id='" + id + "'");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {

                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setPhoneNumber(rs.getString(3));
                customer.setBanned(rs.getBoolean(4));
                customer.setDiscountProcent(rs.getInt(5));
                customer.setCountOfTrip(rs.getInt(6));
                customer.setLogin(rs.getString(7));
                customer.setPassword(rs.getString(8));

            }
            rs.close();
            preparedStatement.close();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    */







}
