package com.idel.commands;

import com.idel.entities.Users;
import com.idel.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements ICommand {
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    // TODO: I'm not sure that this is a correct URI.
    private LoginService loginService;

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        System.out.println("I'm here!");
        String page = null;
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);

        if (!validateStringField(email) || !validateStringField(password)) {
            System.out.println("Error!");
            return WebPages.LOGIN_PAGE;
        }

        Users user = loginService.findUserByLogin(email, password);
        if (user != null && user.Password.equals(password)) {
            request.getSession().setAttribute("user", user);
            return WebPages.USER_OPTIONS_PAGE;
        }
//        if (MUsersDao.find(login, password)) {
//            request.setAttribute("user", login);
//            page = Config.getInstance().getProperty(Config.MAIN);
//        } else {
//            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
//            page = Config.getInstance().getProperty(Config.ERROR);
//        }
        return page;
    }

    private Boolean validateStringField(String value) {
        return true;
    }
}
