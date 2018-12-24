<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/6/18
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update user</title>
</head>
<body>

<h1> Update User</h1>
<br>
<br>
<div>
    <form action="/updateUser" method="post">

        Username : <input type=" text" name="username" placeholder="<c:out value="${user.username}"></c:out>"><br>
        Email : <input type="email" name="email" placeholder=<c:out value="${user.email}"></c:out>> <br>
        Password : <input type="password" name="password" placeholder=<c:out value="${user.password}"></c:out>><br>
        ID : <c:out value="${user.id}"></c:out> <br>
        <input type="radio" name="privilege" value="admin"> Admin <br>
        <input type="radio" name="privilege" value="user"> User <br>
        <input type="hidden" name="id" value=<c:out value="${user.id}"/>>
        <input type="submit" value="submit">
    </form>
    <br>
    <div class="footer">
        <a href="/webAdmin/webAdminTool.jsp">Admin Dashboard <br> </a>
        <a href="/webAdmin/users.jsp">Users Management </a> <br>
    </div>
    <br>
    <form action="/logout">
        <input type="submit" value="Logout">
    </form>
</div>
</body>
</html>
