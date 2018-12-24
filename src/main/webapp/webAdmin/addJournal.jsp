<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/8/18
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../error.jsp" %>
<html>
<head>
    <title>Add journal</title>
    <style>
        <%@include file="/WEB-INF/CSS/uploadStyle.css" %>
    </style>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("username")== null){
        response.sendRedirect("/welcome.jsp");
    }
%>
<h1> Add Journal</h1>
<br>
<br>
<form action="/addJournal" method="post">
    DOI: <input type="text" name="journal-name" required> <br>
    Publisher name: <input type="text" name="publisher-name" required> <br>
    Publisher location: <input type="text" name="publisher-location" required> <br>
    Publisher ID: <input type="text" name="publisher-id" required> <br>
    User name: <input type="text" name="user-name" required><br>
    ISSN ppub: <input type="text" name="issn-ppub" required> <br>
    ISSN epub: <input type="text" name="issn-epub"required> <br>
    <input type="submit" value="ADD">
</form>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp">Admin Dashboard </a> <br>
    <a href="/webAdmin/journals.jsp"> Journals Manegement </a>
</div>
<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
