<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/1/18
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>journals</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("username")== null){
        response.sendRedirect("/welcome.jsp");
    }
%>
<h1>List journals: </h1>
<br>
<br>
    <table title="journals" border="1">
        <th>Journal</th>
        <th>Publisher</th>
        <th>Publisher location</th>
        <th>Publisher ID</th>
        <th>User name</th>
        <th>ISSN PPUB</th>
        <th>ISSN EPUB</th>
        <th>Action</th>

        <c:forEach var="journal" items="${journals}">
            <tr>
            <td>
                <c:out value="${journal.journalName}"></c:out>
            </td>

            <td>
                <c:out value="${journal.publisherName}"></c:out>
            </td>
            <td>
                <c:out value="${journal.publisherLocation}"></c:out>
            </td>
            <td>
                <c:out value="${journal.publisherId}"></c:out>
            </td>
            <td>
                <c:out value="${journal.userName}"></c:out>
            </td>
            <td>
                <c:out value="${journal.issnPpub}"></c:out>
            </td>
            <td>
                <c:out value="${journal.issnEpub}"></c:out>
            </td>
            <td>
                <a href="#"> Update </a>
                <a href="#"> Delete </a>
            </td>
            </tr>
        </c:forEach>
    </table>

<br>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp"> Admin Dashboard</a><br>
    <a href="/webAdmin/journals.jsp"> Journals Management</a>
</div>

<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
