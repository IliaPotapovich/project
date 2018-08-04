package com.potapovich.project.command.admin;

import com.potapovich.project.entity.TaxiCar;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;

public class FindCarByIdCommand implements Command {
    private TaxiService taxiService = new TaxiService();

    public FindCarByIdCommand(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String id = request.getParameter(PageAdress.TAXI_CAR_ID);


        int carId = Integer.parseInt(id);


        TaxiCar car = taxiService.findCarById(carId);

        if (car.getCarId()!=0){


            request.getSession().setAttribute(PageAdress.CAR_ID,car.getCarId());
            request.getSession().setAttribute(PageAdress.MODEL,car.getModel());
            request.getSession().setAttribute(PageAdress.OWNER_ID,car.getOwnerId());
            request.getSession().setAttribute(PageAdress.YEAR,car.getYearOFManufacture());


            page = PageAdress.PATH_PAGE_FIND_CAR_BY_ID;
        }
        else {

            request.getSession().setAttribute(PageAdress.CAR_ID_ERROR_MESSAGE,
                    new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                            getMessage(PageAdress.CAR_IS_NOT_EXIST));

            page = PageAdress.PATH_PAGE_TAXI_REGISTER;


        }

        return page;

    }
}
