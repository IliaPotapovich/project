package com.potapovich.project.command;

import com.potapovich.project.adress.PageAdress;

import javax.servlet.http.HttpServletRequest;

public class LanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().removeAttribute(PageAdress.REG_SUCCESS);


        request.getSession().setAttribute(PageAdress.LANGUAGE,request.getParameter(PageAdress.LANG));
       String page = PageAdress.PATH_PAGE_LOGIN;


return page;
    }
}
