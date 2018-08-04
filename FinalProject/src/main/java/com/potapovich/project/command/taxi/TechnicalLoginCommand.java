package com.potapovich.project.command.taxi;

import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.entity.Customer;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.AdminService;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;

public class TechnicalLoginCommand implements Command {

    TaxiService taxiService;
    AdminService adminService;

    public TechnicalLoginCommand(TaxiService taxiService, AdminService adminService) {
        this.taxiService = taxiService;
        this.adminService = adminService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        String page = null;

        String enteredLogin = request.getParameter(PageAdress.TECH_LOGIN);
        String enteredPass = request.getParameter(PageAdress.TECH_PASSWORD);


        if (taxiService.isExistTaxiNamePass(enteredLogin,enteredPass) ){

            page = PageAdress.PATH_PAGE_TAXI_START_PAGE;
            request.getSession().setAttribute(PageAdress.TAXI_NAME,enteredLogin);
            request.getSession().setAttribute(PageAdress.TAXI_PASS,enteredPass);
        }

        else {

            request.getSession().setAttribute(PageAdress.ERROR_TECHN_LOGIN_PASS_MESSAGE,
                    new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                            getMessage(PageAdress.LOGIN_ERROR));

            page = PageAdress.PATH_PAGE_TECHNICAL_OFFICE;
        }
         if (adminService.checkAdminLoginPassword(enteredLogin,enteredPass) ){
            page = PageAdress.PATH_PAGE_TAXI_REGISTER;
        }

        return page;


    }
}
