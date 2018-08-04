package com.potapovich.project.controller;

import com.potapovich.project.adress.PageAdress;
import com.potapovich.project.command.CommandFactory;
import com.potapovich.project.command.Command;
import com.potapovich.project.command.EmptyCommand;
import com.potapovich.project.dao.AdminDaoImpl;
import com.potapovich.project.localization.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {


    @Override
    public void init() throws ServletException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        adminDao.createAdmin();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Optional<Command> commandOptional = CommandFactory.defineCommand(req.getParameter("command"));

        Command command = commandOptional.orElse(new EmptyCommand());

        String page = command.execute(req);

        if (page != null){

            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req,resp);
        }
        else {

            req.getSession().setAttribute(PageAdress.NULL_PAGE, new MessageManager(
                    (String) req.getSession().getAttribute(PageAdress.LANGUAGE)).getMessage(PageAdress.NULL_PAGE));

            resp.sendRedirect(req.getContextPath() + PageAdress.PATH_PAGE_INDEX);




        }

    }














}
