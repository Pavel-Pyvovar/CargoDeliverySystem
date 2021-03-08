package com.idel.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MissingCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return null;
        //        return Config.getInstance().getProperty(ObjectInputFilter.Config.LOGIN);
    }
}
