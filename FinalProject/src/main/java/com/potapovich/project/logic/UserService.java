package com.potapovich.project.logic;


import com.potapovich.project.dao.CustomerDaoImpl;
import com.potapovich.project.entity.Customer;

public class UserService {

    private int customerId;

    public String userRegistration(Customer customer){

        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        String errorMessage = "";

        if (customerDao.isNameExist(customer.getName())){
            errorMessage = errorMessage.concat("Name is exist; ");
        }
        if (customerDao.isLoginExist(customer.getLogin())){
            errorMessage = errorMessage.concat("Login is exist;");
        }
        if (!customerDao.isNameExist(customer.getName()) && !customerDao.isLoginExist(customer.getLogin())) {
            customerDao.registerUser(customer);
        }
        return errorMessage;
    }






    public boolean checkLogin(String enteredLogin, String enteredPassword) {


        CustomerDaoImpl customerDao = new CustomerDaoImpl();

       Customer customer = customerDao.findRealLoginAndPassIfExist(enteredLogin,enteredPassword);

        System.out.println("aaaaa  "+customer);
        System.out.println("bbbbb   "+enteredLogin);
        System.out.println("cccccc   " + enteredPassword);
        System.out.println("dddddd" + customer.getLogin());
        System.out.println("eeeeeee " + customer.getPassword());

        customerId = customer.getId();

        return customer.getLogin()!=null  && enteredLogin.equals(customer.getLogin()) &&
                !customer.getLogin().isEmpty() && customer.getPassword()!=null && !customer.getPassword().isEmpty() &&
                enteredPassword.equals(customer.getPassword());
    }


    public Customer loadUser(){


        CustomerDaoImpl customerDao = new CustomerDaoImpl();
      Customer customer =  customerDao.readUser(customerId);


      return customer;
    }


}
