package com.potapovich.project.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CommandFactory {

    private static final Logger LOGGER = LogManager.getLogger();
public static Optional<Command> defineCommand(String commandName){

    Optional<Command> current = Optional.empty();
    if (commandName == null){

        return current;
    }

    try {
        CommandType type = CommandType.valueOf(commandName.toUpperCase());

        current = Optional.of(type.getCommand());
    } catch (IllegalArgumentException e) {
        LOGGER.log(Level.ERROR, "IllegalArgumentException " + e.getMessage());
    }

    return current;


}







}
