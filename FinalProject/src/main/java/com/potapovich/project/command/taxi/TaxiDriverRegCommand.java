package com.potapovich.project.command.taxi;

import com.potapovich.project.entity.TaxiDriver;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;

public class TaxiDriverRegCommand implements Command {

    private TaxiService taxiService = new TaxiService();

    public TaxiDriverRegCommand(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute(PageAdress.REG_CAR_SUCCESS);


        String driverName = request.getParameter(PageAdress.REG_DRIVER_NAME);
        String driverPassword = request.getParameter(PageAdress.REG_DRIVER_PASSWORD);
        String driverExp = request.getParameter(PageAdress.REG_DRIVER_EXP);
        String page;

        int driverExperience = Integer.parseInt(driverExp);

        TaxiDriver driver = new TaxiDriver(driverName, driverPassword, driverExperience);

        taxiService.taxiDriverRegistration(driver);

        page = PageAdress.PATH_PAGE_TAXI_REGISTER;


        request.getSession().setAttribute(PageAdress.REG_TAXI_SUCCESS, new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                getMessage(PageAdress.REG_SUCCESS));


        return page;


    }
}
