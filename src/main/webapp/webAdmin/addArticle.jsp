<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/5/18
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/error.jsp" %>
<html>
<head>
    <title>upload a file</title>
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
</head>

<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/welcome.jsp");
    }
%>

<h1>ADD Article</h1>
<br>
<fieldset>
    <legend>Choose file</legend>
    <form action="/addArticle" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept="application/zip" multiple required="required"/>
        <input type="submit" value="ADD"/>
    </form>
</fieldset>
<br>
<br>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp">Admin Dashboard <br> </a>
    <a href="/webAdmin/articles.jsp">Articles management <br> </a>
</div>

<br>
<form action="/logout">
    <input type="submit" value="Logout">
</form>

</body>

</html>