<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Users</title>
</head>
<body>
<h1>
    Users List:
</h1>

<table border="1">
    <tr>
        <th>User name</th>
        <th>Email</th>
        <th>Finger Print</th>
        <th>Privilege</th>
        <th>Action</th>
    </tr>

    <tr>
        <c:forEach var="user" items="${users}">
        <td>
            <c:out value="${user.username}"></c:out>
        </td>
        <td>
            <c:out value="${user.email}"></c:out>
        </td>
        <td>
            <c:out value="${user.password}"></c:out>
        </td>
        <td>
            <c:out value="${user.privilege}"></c:out>
        </td>
        <td>
            <a href="UserController?action=edit&userId=<c:out value="${user.id}"/>">Update</a>
            <a href="UserController?action=delete&userId=<c:out value="${user.id}"/>">Delete</a>

        </td>
    </tr>
    </c:forEach>
</table>
    <br>
<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp">Admin Dashboard <br> </a>
    <a href="/webAdmin/users.jsp">Users Management </a>
</div>
<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>