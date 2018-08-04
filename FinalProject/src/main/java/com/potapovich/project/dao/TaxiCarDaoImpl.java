package com.potapovich.project.dao;

import com.potapovich.project.entity.TaxiCar;
import com.potapovich.project.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaxiCarDaoImpl {

   private List<TaxiCar> listofCars = new ArrayList<>();

    public void carRegistration(TaxiCar car){



        String insertedCar = "insert into taxi_cars (model, owner_id, year)"
                + "values (?, ?, ?);";

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertedCar)) {

            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getOwnerId());
            preparedStatement.setInt(3, car.getYearOFManufacture());
            preparedStatement.execute();


        }  catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public TaxiCar findCarById(int id){

        TaxiCar car = new TaxiCar();



        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select car_id, model, owner_id, year from taxi_cars where car_id='" + id + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

            System.out.println(id);



            while (rs.next()) {

                car.setCarId(rs.getInt(1));
                car.setModel(rs.getString(2));
                car.setOwnerId(rs.getInt(3));
                car.setYearOFManufacture(rs.getInt(4));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }




    public List<TaxiCar> findCarsByOwnerId(int ownerId){

        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select car_id, model, owner_id, year from taxi_cars where owner_id='" + ownerId + "'");
            ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                TaxiCar car = new TaxiCar();
                car.setCarId(rs.getInt(1));
                car.setModel(rs.getString(2));
                car.setOwnerId(rs.getInt(3));
                car.setYearOFManufacture(rs.getInt(4));
                listofCars.add(car);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listofCars;
    }


}
