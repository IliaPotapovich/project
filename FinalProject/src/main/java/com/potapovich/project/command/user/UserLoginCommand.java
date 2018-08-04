package com.potapovich.project.command.user;

import com.potapovich.project.entity.Customer;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.UserService;

import javax.servlet.http.HttpServletRequest;

public class UserLoginCommand implements Command {

    private UserService receiver;

    public UserLoginCommand(UserService receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute(PageAdress.LOGOUT_MESSAGE);
        request.getSession().removeAttribute(PageAdress.REG_SUCCESS);

        String page = null;

        String enteredLogin = request.getParameter(PageAdress.PARAM_LOGIN);
        String enteredPass = request.getParameter(PageAdress.PARAM_PASSWORD);



        if (receiver.checkLogin(enteredLogin,enteredPass) ){

            Customer customer = receiver.loadUser();

            request.getSession().setAttribute(PageAdress.ID,customer.getId());
            request.getSession().setAttribute(PageAdress.NAME,customer.getName());
            request.getSession().setAttribute(PageAdress.PHONE,customer.getPhoneNumber());
            request.getSession().setAttribute(PageAdress.TRIP,customer.getCountOfTrip());
            request.getSession().setAttribute(PageAdress.DISCOUNT,customer.getDiscountProcent());

            page = PageAdress.PATH_PAGE_MAIN;
        }
        else {

                request.getSession().setAttribute(PageAdress.ERROR_LOGIN_PASS_MESSAGE,
                        new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                                getMessage(PageAdress.LOGIN_ERROR));

            page = PageAdress.PATH_PAGE_LOGIN;


        }

        return page;


    }
}
