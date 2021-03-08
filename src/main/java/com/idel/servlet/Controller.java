package com.idel.servlet;

import com.idel.commands.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "Controller", urlPatterns = {"/Controller/*"})
public class Controller extends HttpServlet {

    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        try {
            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
//            request.setAttribute("messageError", Messsage.getInstance().getProperty(Message.SERVLET_EXCEPTION));
        } catch (IOException e) {
            e.printStackTrace();
//            request.setAttribute("messageError", Message.getInstance().getProperty(Message.IO_EXCEPTION));
        }
        // TODO: Solve problem with snicking SQL exception.
//        catch (SQLException e) {
//            e.printStackTrace();
//    //            request.setAttribute("messageError", Message.getInstance().getProperty(Message.SQLEXCEPTION));
//        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
    }
    // TODO: doEverythingElse
}
