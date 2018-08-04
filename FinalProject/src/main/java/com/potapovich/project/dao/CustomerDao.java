package com.potapovich.project.dao;


import com.potapovich.project.entity.Customer;

public interface CustomerDao {

    void registerUser(Customer customer);
    Customer readUser(int id);

}
