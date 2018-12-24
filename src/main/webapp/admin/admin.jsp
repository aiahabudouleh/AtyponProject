<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/4/18
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../error.jsp"  %>
<html>
<head>
    <title>Publisher</title>
    <style><%@include file="/WEB-INF/CSS/uploadStyle.css"%></style></head>
</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("username")== null){
        response.sendRedirect("welcome.jsp");
    }
%>

<div>
    <h1> Publisher Page </h1>

    <form action="/upload" method="post" enctype="multipart/form-data">
        <label class="file">
            <input type="file" id="file" name="file" accept="application/zip" multiple/>
            <span class="file-custom"></span>
            <input type="submit" value="Upload"/>
        </label>
        <br>
    </form>

    <i>To Create a journal </i><a href="createJournal.jsp"><i> Click here</i></a>
    <form action="/logout">
        <input type="submit" value="Logout">
    </form>

</div>
</body>
</html>
