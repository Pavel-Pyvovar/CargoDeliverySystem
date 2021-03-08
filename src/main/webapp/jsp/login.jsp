<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> IDEL </title>
</head>
<body>
<form name="loginForm" method="POST" action="Controller">
    <input type="hidden" name="command" value="login" />
    Email:<br/>
    <input type="text" name="login" ><br/>
    Password:<br/>
    <input type="password" name="password" > <br/>
    <%--            <p style="color:red"> ${errorLoginPassMessage}</p><br/>--%>
    <input type="submit" value="Enter">
    <a href="${pageContext.request.contextPath}/jsp/register.jsp"><button type="button">Register User</button></a>
</form><hr/>
</body>
</html>