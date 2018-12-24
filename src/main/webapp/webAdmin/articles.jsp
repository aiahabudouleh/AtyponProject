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
    <title>articles management</title>
    <style><%@include file="/WEB-INF/CSS/uploadStyle.css"%></style></head>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/welcome.jsp");
    }
%>

<h1>Articles Management</h1>

<a href="addArticle.jsp" > <h3>Add Article</h3></a>
<a href="/listArticles"> <h3>List Articles</h3></a>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp"> Admin Dashboard</a>
</div>

<form action="/logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
