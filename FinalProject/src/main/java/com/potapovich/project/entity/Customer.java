package com.potapovich.project.entity;

import java.util.Objects;

public class Customer {

    private int id;
    private String name;
    private String phoneNumber;
    private boolean isBanned;
    private int discountProcent;
    private int countOfTrip;
    private String login;
    private String password;

    public Customer() {
    }

    public Customer(String login, String password, String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public Customer(int id, String name, String phoneNumber, boolean isBanned, int discountProcent, int countOfTrip) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isBanned = isBanned;
        this.discountProcent = discountProcent;
        this.countOfTrip = countOfTrip;
    }

    public Customer(int id, String name, String phoneNumber, boolean isBanned, int discountProcent, int countOfTrip, String login, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isBanned = isBanned;
        this.discountProcent = discountProcent;
        this.countOfTrip = countOfTrip;
        this.login = login;
        this.password = password;
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public int getDiscountProcent() {
        return discountProcent;
    }

    public void setDiscountProcent(int discountProcent) {
        this.discountProcent = discountProcent;
    }

    public int getCountOfTrip() {
        return countOfTrip;
    }

    public void setCountOfTrip(int countOfTrip) {
        this.countOfTrip = countOfTrip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() &&
                isBanned() == customer.isBanned() &&
                getDiscountProcent() == customer.getDiscountProcent() &&
                getCountOfTrip() == customer.getCountOfTrip() &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getPhoneNumber(), customer.getPhoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getPhoneNumber(), isBanned(), getDiscountProcent(), getCountOfTrip());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", isBanned=" + isBanned +
                ", discountProcent=" + discountProcent +
                ", countOfTrip=" + countOfTrip +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
