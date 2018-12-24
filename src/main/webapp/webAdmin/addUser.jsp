<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/5/18
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user</title>
    <style>
        <%@include file="/WEB-INF/CSS/uploadStyle.css" %>
    </style>
</head>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/welcome.jsp");
    }
%>
<c:out value="${message}"></c:out>
<h1>Add User</h1>
<form action="/addUser" method="post">
    Username : <input type=" text" name="username" placeholder="Username" required> <br>
    Email : <input type="email" name="email" placeholder="username@company.com" required> <br>
    Password : <input type="password" name="password" placeholder="Password" required> <br>
    Repeated password : <input type="password" name="repassword" placeholder="Re-Password" required> <br>
    <input type="radio" name="role" value="admin" checked> ADMIN <br>
    <input type="radio" name="role" value="user" checked> USER <br>
    <br>
    <br>
    <input type="submit" value="ADD">
</form>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp"> Admin Dashboard</a> <br>
    <a href="/webAdmin/users.jsp"> Users Management</a>
</div>

<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>


</body>
</html>
