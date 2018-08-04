package com.potapovich.project.command;

import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.localization.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command{




    @Override
    public String execute(HttpServletRequest request) {

       String page = PageAdress.PATH_PAGE_LOGIN;

        request.setAttribute(PageAdress.WRONG_ACTION,
                new MessageManager((String) request.getSession().getAttribute(PageAdress.LANGUAGE)).
                        getMessage(PageAdress.EMPTY_COMMAND));


        return page;
    }
}
