<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 12/5/18
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add user response</title>
</head>
<body>

<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if (session.getAttribute("username")== null){
        response.sendRedirect("/welcome.jsp");
    }
%>

<i> Action result </i>
<br>
<p>
    Action status: <%=request.getAttribute("message")%>
</p>

<div class="footer">
    <a href="/webAdmin/webAdminTool.jsp">Admin Dashboard</a>
</div>

</body>
</html>
