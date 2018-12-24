<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/1/18
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>users management</title>
    <style><%@include file="/WEB-INF/CSS/uploadStyle.css"%></style></head>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/welcome.jsp");
    }
%>

<h1> Users Management</h1>
<br>
<a href="addUser.jsp" > <h3>Add User</h3></a>
<a href="/listUsers"> <h3>List Users</h3></a>

<form action="/logout">
    <input type="submit" value="Logout">
</form>
<br>
<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp"> Admin Dashboard</a>
</div>
</body>
</html>
