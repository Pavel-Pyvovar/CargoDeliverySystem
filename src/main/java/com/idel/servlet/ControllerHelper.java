package com.idel.servlet;

import com.idel.commands.ICommand;
import com.idel.commands.LoginCommand;
import com.idel.commands.MissingCommand;
import com.idel.commands.RegisterCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ControllerHelper {
    private static ControllerHelper instance = null;
    // TODO: Make sure that static is needed here.
    static HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

    private ControllerHelper() {
        commands.put("login", new LoginCommand());
        commands.put("register", new RegisterCommand());
    }

    public static ICommand getCommand(HttpServletRequest request) {
        ICommand command = commands.get(request.getParameter("command"));
        if (command == null) {
            command = new MissingCommand();
        }
        return command;
    }
    // Singleton implementation.
    public static ControllerHelper getInstance() {
        if (instance == null) {
            instance = new ControllerHelper();
        }
        return instance;
    }
}
