package com.potapovich.project.command;

import com.potapovich.project.command.admin.FindCarByIdCommand;
import com.potapovich.project.command.admin.FindCarByOwnerCommand;
import com.potapovich.project.command.admin.FindDriverByIdCommand;
import com.potapovich.project.command.admin.FindDriverByNameCommand;
import com.potapovich.project.command.taxi.DriverChoosesCarCommand;
import com.potapovich.project.command.taxi.TaxiCarRegCommand;
import com.potapovich.project.command.taxi.TaxiDriverRegCommand;
import com.potapovich.project.command.taxi.TechnicalLoginCommand;
import com.potapovich.project.command.user.LogoutCommand;
import com.potapovich.project.command.user.UserLoginCommand;
import com.potapovich.project.command.user.UserRegistrCommand;
import com.potapovich.project.logic.AdminService;
import com.potapovich.project.logic.TaxiService;
import com.potapovich.project.logic.UserService;

public enum CommandType {

    LOGIN(new UserLoginCommand(new UserService())),
    LOGOUT(new LogoutCommand()),
    SET_LANGUAGE(new LanguageCommand()),
    USER_REGISTRATION(new UserRegistrCommand(new UserService())),
    TAXI_DRIVER_REGISTRATION(new TaxiDriverRegCommand(new TaxiService())),
    TAXI_CAR_REGISTRATION(new TaxiCarRegCommand(new TaxiService())),
    FIND_DRIVER_BY_ID(new FindDriverByIdCommand(new TaxiService())),
    FIND_DRIVER_BY_NAME(new FindDriverByNameCommand(new TaxiService())),
    FIND_CAR_BY_ID(new FindCarByIdCommand(new TaxiService())),
    FIND_CAR_BY_OWNER_ID(new FindCarByOwnerCommand(new TaxiService())),
    TECHNICAL_LOGIN(new TechnicalLoginCommand(new TaxiService(), new AdminService())),
    DRIVER_CHOOSES_CAR(new DriverChoosesCarCommand(new TaxiService()));

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
