package com.potapovich.project.command.admin;

import com.potapovich.project.entity.TaxiCar;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindCarByOwnerCommand implements Command {
    private TaxiService taxiService = new TaxiService();

    public FindCarByOwnerCommand(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;
        String id = request.getParameter(PageAdress.TAXI_CAR_OWNER_ID);
        int ownerId = Integer.parseInt(id);
        List<TaxiCar> listOfCars = taxiService.findCarsByOwnerId(ownerId);

        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA LIST" + listOfCars);

        if (listOfCars.size()!=0){


           /* request.getSession().setAttribute(PageAdress.CAR_ID,car.getCarId());
            request.getSession().setAttribute(PageAdress.MODEL,car.getModel());
            request.getSession().setAttribute(PageAdress.OWNER_ID,car.getOwnerId());
            request.getSession().setAttribute(PageAdress.YEAR,car.getYearOFManufacture());
*/
           request.getSession().setAttribute("list",listOfCars);

            page = PageAdress.PATH_PAGE_FIND_CAR;
        }
        else {

            request.getSession().setAttribute(PageAdress.CAR_OWNER_ID_ERROR_MESSAGE,
                    new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                            getMessage(PageAdress.CAR_IS_NOT_EXIST));

            page = PageAdress.PATH_PAGE_TAXI_REGISTER;

        }

        return page;

    }
}
