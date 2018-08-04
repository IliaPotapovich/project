package com.potapovich.project.logic;

import com.potapovich.project.dao.TaxiCarDaoImpl;
import com.potapovich.project.dao.TaxiDriverDaoImpl;
import com.potapovich.project.entity.TaxiCar;
import com.potapovich.project.entity.TaxiDriver;

import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    public void taxiDriverRegistration(TaxiDriver driver){

        TaxiDriverDaoImpl taxiDriverDao = new TaxiDriverDaoImpl();

        taxiDriverDao.driverRegistration(driver);

    }



    public void taxiCarRegistration(TaxiCar car){


        TaxiCarDaoImpl taxiCarDao = new TaxiCarDaoImpl();

        taxiCarDao.carRegistration(car);

    }




    public TaxiDriver findDriverById(int id){

        TaxiDriver driver = new TaxiDriver();


        TaxiDriverDaoImpl driverDao = new TaxiDriverDaoImpl();

       driver = driverDao.findDriverById(id);

        return driver;
    }


    public TaxiDriver findDriverByName(String name){
        TaxiDriver driver = new TaxiDriver();
        TaxiDriverDaoImpl driverDao = new TaxiDriverDaoImpl();

        driver = driverDao.findDriverByName(name);


        return driver;
    }

    public TaxiDriver findDriverByNameAndPassword(String name, String password){
        TaxiDriver driver = new TaxiDriver();
        TaxiDriverDaoImpl driverDao = new TaxiDriverDaoImpl();

        driver = driverDao.findDriverByLoginAndPassword(name,password);


        return driver;
    }



    public TaxiCar findCarById(int id){
        TaxiCar car = new TaxiCar();
        TaxiCarDaoImpl taxiCarDao = new TaxiCarDaoImpl();

        car = taxiCarDao.findCarById(id);


        return car;
    }


    public List<TaxiCar> findCarsByOwnerId(int ownerId){
        TaxiCar car = new TaxiCar();
        List<TaxiCar> listOfCars = new ArrayList<>();
        TaxiCarDaoImpl taxiCarDao = new TaxiCarDaoImpl();

       listOfCars = taxiCarDao.findCarsByOwnerId(ownerId);
        return listOfCars;
    }


    public boolean isExistTaxiNamePass(String name, String password){

        TaxiDriver driver = new TaxiDriver();
        TaxiDriverDaoImpl driverDao = new TaxiDriverDaoImpl();

       driver = driverDao.findDriverByLoginAndPassword(name,password);

        System.out.println("DRIIIIIIIIVEEEEEEEEEEEEEEEER   " + driver);

       return driver.getDriverName()!=null && name.equals(driver.getDriverName()) && !driver.getDriverName().isEmpty() && password.equals(driver.getDriverPassword())
               && driver.getDriverPassword()!=null && !driver.getDriverPassword().isEmpty();



    }


}
