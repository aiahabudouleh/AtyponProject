<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/1/18
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>articles</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("username")== null){
        response.sendRedirect("/welcome.jsp");
    }
%>

<h1>Articles List: </h1>
<br>
<br>
<div>
    <table title="articles" align="center" border="1">
        <tr>
        <th><i>Journal</i></th>
        <th><i>Issue number</i></th>
        <th><i>Title</i></th>
        <th><i>Path</i></th>
        <th><i>Action</i></th>
        </tr>
        <tr>
            <c:forEach var="user" items="${articles}">
            <td>
                <c:out value="${user.journal}"></c:out>
            </td>
            <td>
                <c:out value="${user.issue}"></c:out>
            </td>
            <td>
                <c:out value="${user.title}"></c:out>
            </td>
            <td>
                <c:out value="${user.path}"></c:out>
            </td>
            <td>
                <a href="#"> Update </a>
                <a href="#"> Delete </a>

            </td>
        </tr>
        </c:forEach>
    </table>
</div>
<br>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp"> Admin Dashboard</a><br>
    <a href="/webAdmin/articles.jsp"> Articles Management </a><br>
</div>
<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>
