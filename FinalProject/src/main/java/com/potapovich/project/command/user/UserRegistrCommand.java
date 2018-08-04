package com.potapovich.project.command.user;

import com.potapovich.project.entity.Customer;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserRegistrCommand implements Command {

     private UserService receiver = new UserService();

    public UserRegistrCommand(UserService receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().removeAttribute(PageAdress.REGISTR_ERROR);
        request.getSession().removeAttribute(PageAdress.ERROR_LOGIN_PASS_MESSAGE);


        String regLogin = request.getParameter(PageAdress.REG_LOGIN);
        String regPass = request.getParameter(PageAdress.REG_PASSWORD);
        String regName = request.getParameter(PageAdress.REG_NAME);
        String regPhone = request.getParameter(PageAdress.REG_PHONE);
        String page;

        Customer customer =new Customer(regLogin,regPass,regName,regPhone);



       String registrError = receiver.userRegistration(customer);

       if (!registrError.equals("")){
           request.getSession().setAttribute(PageAdress.REGISTR_ERROR,registrError);
           page = PageAdress.PATH_PAGE_REGISTER;
       }
       else {
           page = PageAdress.PATH_PAGE_LOGIN;
           request.getSession().setAttribute(PageAdress.REG_SUCCESS, new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                   getMessage(PageAdress.REG_SUCCESS));
       }

       return page;



    }
}
