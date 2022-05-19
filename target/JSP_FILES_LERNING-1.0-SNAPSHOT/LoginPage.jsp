<%--Created by IntelliJ IDEA.
User: karendarbinyan
Date: 5/18/22
Time: 20:12
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn page</title>
</head>
<body>
<p>LOGIN PAGE</p>
<%
    String message = (String) request.getAttribute("message");
    String color = (String) request.getAttribute("color");
%>
<span>
    <p style="color: <%= color%>">
        <%=
        message != null ? message : ""
        %>
    </p>
</span>
<form action="/login" method="post">
    <input type="text" placeholder="Login" name="login">
    <input type="password" placeholder="Password" name="password">
    <button>Login</button>
</form>

<a type="button" href="/register">Register Now</a>

</body>
</html>
