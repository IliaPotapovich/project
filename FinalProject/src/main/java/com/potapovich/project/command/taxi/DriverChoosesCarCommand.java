package com.potapovich.project.command.taxi;

import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.entity.TaxiCar;
import com.potapovich.project.entity.TaxiDriver;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;

public class DriverChoosesCarCommand implements Command {

    private TaxiService taxiService;

    public DriverChoosesCarCommand(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String name = (String) request.getSession().getAttribute(PageAdress.TAXI_NAME);
        String password = String.valueOf(request.getSession().getAttribute(PageAdress.TAXI_PASS));
        String carId = request.getParameter(PageAdress.DESIRED_CAR_ID);


        int desiredCarId = Integer.parseInt(carId);


        TaxiDriver driver = taxiService.findDriverByNameAndPassword(name,password);
        TaxiCar car = taxiService.findCarById(desiredCarId);

        if (car.getCarId()!=0){
            request.getSession().setAttribute(PageAdress.DRIVER_ID,driver.getDriverId());
            request.getSession().setAttribute(PageAdress.DRIVER_NAME,driver.getDriverName());
            request.getSession().setAttribute(PageAdress.DRIVER_EXPERIENCE,driver.getExperience());
            request.getSession().setAttribute(PageAdress.DRIVER_STATUS,driver.isBanned());

            request.getSession().setAttribute(PageAdress.CAR_ID,car.getCarId());
            request.getSession().setAttribute(PageAdress.MODEL,car.getModel());
            request.getSession().setAttribute(PageAdress.OWNER_ID,car.getOwnerId());
            request.getSession().setAttribute(PageAdress.YEAR,car.getYearOFManufacture());


            page = PageAdress.PATH_PAGE_TAXI_ROOM;
        }
        else {
            request.getSession().setAttribute(PageAdress.CAR_ID_ERROR_MESSAGE,
                    new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                            getMessage(PageAdress.CAR_IS_NOT_EXIST));

            page = PageAdress.PATH_PAGE_TAXI_START_PAGE;
        }

        return page;

    }
}
