package com.idel.commands;

import com.idel.entities.Users;
import com.idel.service.LoginService;
import com.idel.service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements ICommand {

    private static final String ATTR_NAME_FNAME = "firstName";
    private static final String ATTR_NAME_SNAME = "secondName";
    private static final String ATTR_NAME_EMAIL = "email";
    private static final String ATTR_NAME_PASSWORD = "password";
    private static final String LOGIN_PAGE = "/";
    private RegisterService service;

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String firstName = request.getParameter(ATTR_NAME_FNAME);
        String secondName = request.getParameter(ATTR_NAME_SNAME);
        String email = request.getParameter(ATTR_NAME_EMAIL);
        String password = request.getParameter(ATTR_NAME_PASSWORD);

        if (!validateStringField(email) || !validateStringField(password)) {
            System.out.println("Error!");
            return WebPages.REGISTER_PAGE;
        }

        Users user = new Users();
        // Set user credentials.
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setEmail(email);
        user.setPassword(password);

        try {
            service.registerUser(user);
            return WebPages.INDEX_PAGE;
        } catch (RuntimeException e) {
            e.printStackTrace();
            // request.setAttribute("errorLoginPassMessage", "Please choose another login");
        }

        return WebPages.REGISTER_PAGE;
    }
    // TODO: Setup proper validation.
    private Boolean validateStringField(String value) {
        return true;
    }
}
