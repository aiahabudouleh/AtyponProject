<%--
  Created by IntelliJ IDEA.
  User: ayaabudoleh
  Date: 12/7/18
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>journals management</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/welcome.jsp");
    }
%>

<h1>Journals Management</h1>
<br>
<a href="addJournal.jsp" > <h3>Add Journal</h3></a>
<a href="/listJournals"> <h3>List Journals</h3></a>

<form action="/logout">
    <input type="submit" value="Logout">
</form>
<br>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp"> Admin Dashboard</a>
</div>
<br>

<form action="/logout">
    <input type="submit" value="Logout">
</form>
</body>
</html>