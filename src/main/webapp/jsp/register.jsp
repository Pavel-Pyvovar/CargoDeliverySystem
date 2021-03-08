<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Register new user</title>
    </head>
    <body>
        <form name="registerForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="register" />
            First name:<br/>
            <input type="text" name="firstName" ><br/>
            Second name:<br/>
            <input type="text" name="secondName" ><br/>
            Email:<br/>
            <input type="text" name="email" ><br/>
            Password:<br/>
            <input type="password" name="password" > <br/>
            <input type="submit" value="Enter">
        </form><hr/>
    </body>
</html>