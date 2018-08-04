package com.potapovich.project.command.taxi;

import com.potapovich.project.entity.TaxiCar;
import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;
import com.potapovich.project.logic.TaxiService;

import javax.servlet.http.HttpServletRequest;

public class TaxiCarRegCommand implements Command {

    private TaxiService taxiService = new TaxiService();

    public TaxiCarRegCommand(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().removeAttribute(PageAdress.REG_TAXI_SUCCESS);

        String carModel = request.getParameter(PageAdress.REG_CAR_MODEL);
        String ownerId = request.getParameter(PageAdress.REG_OWNER_ID);
        String yearOfManuf = request.getParameter(PageAdress.REG_YEAR_OF_MANUF);
        String page;

        int ownId = Integer.parseInt(ownerId);
        int yearOfManufacture = Integer.parseInt(yearOfManuf);

        TaxiCar car = new TaxiCar(carModel,ownId,yearOfManufacture);

        taxiService.taxiCarRegistration(car);

        page = PageAdress.PATH_PAGE_TAXI_REGISTER;

        request.getSession().setAttribute(PageAdress.REG_CAR_SUCCESS, new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                getMessage(PageAdress.REG_SUCCESS));

        return page;
    }
}
