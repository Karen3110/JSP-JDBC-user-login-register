<%--
  Created by IntelliJ IDEA.
  User: karendarbinyan
  Date: 5/18/22
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="com.example.JSP_FILES_LERNING.model.User" %>
<%

    User user = (User) request.getAttribute("user");
%>

<h1>
    Main page <%=user.getId()%>
</h1>

<p>
    <%=
    user.getName() + " " + user.getSurname()
    %>
</p>
<p>
    <%=
    user.getAddress()
    %>
</p>
<p>
    <%=
    user.getContact()
    %>
</p>

<a type="button" href="/">Log Out</a>
</body>
</html>
