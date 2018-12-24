<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/8/18
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title> User </title>
    <style>
        <%@include file="/WEB-INF/CSS/uploadStyle.css"%>
        <%@include file="/WEB-INF/CSS/menuStyle.css"%>

    </style>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("welcome.jsp");
    }
%>

<h1>Welcome <c:out value="${username}"> </c:out></h1>

<h3> Articles .....</h3>

<table>
    <tr>
        <th>Joural</th>
        <th>Title</th>
        <th>Issue</th>
        <th>Action</th>
    </tr>

    <tr>
    <c:forEach var="item" items="${articles}">
        <td>
            <c:out value="${item.journal}"></c:out>
        </td>
        <td>
            <c:out value="${item.title}"></c:out>
        </td>
        <td>
            <c:out value="${item.issue}"></c:out>
        </td>
       <td>
           <a href="UserController?action=view&article=<c:out value="${item.doi}"/>">view</a>
        </td>
    </tr>
    </c:forEach>
</table>


<br>
<form action="logout">
    <input type="submit" value="Logout">
</form>


</body>
</html>