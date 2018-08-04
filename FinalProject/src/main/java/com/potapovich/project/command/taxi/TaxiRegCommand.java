package com.potapovich.project.command.taxi;

import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.entity.Taxi;

import javax.servlet.http.HttpServletRequest;

public class TaxiRegCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Taxi taxi = new Taxi();
        String page= "";

        String driverId = request.getParameter(PageAdress.TAXI_DRIVER_ID);
        String carId = request.getParameter(PageAdress.TAXI_CAR_ID);




        return page;
    }
}
