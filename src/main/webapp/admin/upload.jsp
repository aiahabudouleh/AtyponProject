<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/8/18
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../error.jsp"%>
<html>
<head>
    <title>upload a file</title>
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
</head>

<body>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%>

<div> Upload file to server </div>

<fieldset>
    <legend>Choose file</legend>
    <form action="/upload" method="post" enctype="multipart/form-data" >
    <input type="file" name="file" accept="application/zip" multiple required="required"/>
    <input type="submit" value="Submit"/>
    </form>
</fieldset>

</body>

</html>
