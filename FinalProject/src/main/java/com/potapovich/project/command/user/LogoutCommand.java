package com.potapovich.project.command.user;

import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.Command;
import com.potapovich.project.localization.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String page = PageAdress.PATH_PAGE_LOGIN;

        request.getSession().setAttribute(PageAdress.LOGOUT_MESSAGE,
                new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                        getMessage(PageAdress.LOGOUT_MESSAGE));

        return page;
    }
}
