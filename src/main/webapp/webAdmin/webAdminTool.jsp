<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/1/18
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin dash board</title>
    <style><%@include file="/WEB-INF/CSS/uploadStyle.css"%></style></head>
</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("username")== null){
        response.sendRedirect("/welcome.jsp");
    }
%>

<h1>Admin Dashboard</h1>

<div>
<table>
    <thead>
    <tr>
    <td>
        <a href="users.jsp"> Users </a>
    </td>
    </tr>
    <tr>
    <td>
        <a href="articles.jsp"> Articles</a>
    </td>
    </tr>
    <tr>
    <td>
        <a href="journals.jsp"> Journals</a>
    </td>
    </tr>
    </thead>
</table>
</div>

<br>
<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
