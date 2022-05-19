<%--
  Created by IntelliJ IDEA.
  User: karendarbinyan
  Date: 5/18/22
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
<form action="/register-user" method="post">
    <table style="with: 50%">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="surname"/></td>
        </tr>
        <tr>
            <td>UserName</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>Contact No</td>
            <td><input type="text" name="contact"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/></form>
</body>
</html>
