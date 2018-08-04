package com.potapovich.project.entity;

import java.util.Objects;

public class TaxiDriver {


    private int driverId;
    private String driverName;
    private String driverPassword;
    private int experience;
    private boolean isBanned = false;

    public TaxiDriver() {
    }

    public TaxiDriver(String driverName, String driverPassword, int experience) {
        this.driverName = driverName;
        this.driverPassword = driverPassword;
        this.experience = experience;
    }

    public TaxiDriver(int driverId, String driverName, String driverPassword, int experience, boolean isBanned) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverPassword = driverPassword;
        this.experience = experience;
        this.isBanned = isBanned;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiDriver driver = (TaxiDriver) o;
        return getDriverId() == driver.getDriverId() &&
                getExperience() == driver.getExperience() &&
                isBanned() == driver.isBanned() &&
                Objects.equals(getDriverName(), driver.getDriverName()) &&
                Objects.equals(getDriverPassword(), driver.getDriverPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDriverId(), getDriverName(), getDriverPassword(), getExperience(), isBanned());
    }


    @Override
    public String toString() {
        return "TaxiDriver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverPassword='" + driverPassword + '\'' +
                ", experience=" + experience +
                ", isBanned=" + isBanned +
                '}';
    }
}
