package com.potapovich.project.command.admin;

import com.potapovich.project.entity.TaxiDriver;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;

public class FindDriverByNameCommand implements Command {

    private TaxiService taxiService = new TaxiService();

    public FindDriverByNameCommand(TaxiService taxiService) {
        this.taxiService = taxiService;
    }



    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String name = request.getParameter(PageAdress.TAXI_DRIVER_NAME);

        TaxiDriver driver = taxiService.findDriverByName(name);


        if (driver.getDriverId()!=0){


            request.getSession().setAttribute(PageAdress.DRIVER_ID,driver.getDriverId());
            request.getSession().setAttribute(PageAdress.DRIVER_NAME,driver.getDriverName());
            request.getSession().setAttribute(PageAdress.DRIVER_EXPERIENCE,driver.getExperience());
            request.getSession().setAttribute(PageAdress.DRIVER_STATUS,driver.isBanned());
            page = PageAdress.PATH_PAGE_FIND_DRIVER;
        }
        else {

            request.getSession().setAttribute(PageAdress.DRIVER_NAME_ERROR_MESSAGE,
                    new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                            getMessage(PageAdress.DRIVER_IS_NOT_EXIST));

            page = PageAdress.PATH_PAGE_TAXI_REGISTER;


        }

        return page;

    }
}
