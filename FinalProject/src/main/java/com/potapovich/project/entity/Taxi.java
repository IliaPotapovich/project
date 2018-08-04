package com.potapovich.project.entity;

import java.util.Objects;

public class Taxi {

    private TaxiDriver taxiDriver;
    private TaxiCar taxiCar;


    public Taxi() {
    }

    public Taxi(TaxiDriver taxiDriver, TaxiCar taxiCar) {
        this.taxiDriver = taxiDriver;
        this.taxiCar = taxiCar;
    }


    public TaxiDriver getTaxiDriver() {
        return taxiDriver;
    }

    public void setTaxiDriver(TaxiDriver taxiDriver) {
        this.taxiDriver = taxiDriver;
    }

    public TaxiCar getTaxiCar() {
        return taxiCar;
    }

    public void setTaxiCar(TaxiCar taxiCar) {
        this.taxiCar = taxiCar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxi taxi = (Taxi) o;
        return Objects.equals(getTaxiDriver(), taxi.getTaxiDriver()) &&
                Objects.equals(getTaxiCar(), taxi.getTaxiCar());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTaxiDriver(), getTaxiCar());
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiDriver=" + taxiDriver +
                ", taxiCar=" + taxiCar +
                '}';
    }
}
