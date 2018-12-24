
<%--
  Created by IntelliJ IDEA.
  User: ayaabudoleh
  Date: 15/12/18
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Article view</title>
</head>
<body><%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("/welcome.jsp");
    }
%>

<%
    out.print(request.getAttribute("html"));
    %>
</body>
</html>
