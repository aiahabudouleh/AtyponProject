<%@ page import="objects.Journal" %><%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/14/18
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="../error.jsp" %>
<html>
<head>
    <title>Creating Journal Response</title>
    <style>
        <%@include file="/WEB-INF/CSS/styleSheet.css" %>
    </style>
</head>
<body>

<%Journal journal = (Journal) request.getAttribute("journal");%>

<div class="container">
    <section id="content">
        <h1><i>New Journal Information</i></h1>
        <br>
        <div>
            <i> Title : <%=journal.getJournalName()%>
            </i>
        </div>
        <div>
            <i> Publisher Name : <%=journal.getPublisherName()%>
            </i>
        </div>
        <div>
            <i> Publisher Location : <%=journal.getPublisherLocation()%>
            </i>
        </div>
        <div>
            <i> Publisher ID : <%=journal.getPublisherId()%>
            </i>
        </div>
        <div>
            <i> User name : <%=journal.getUserName()%>
            </i>
        </div>
        <div>
            <i> ISSN PPUB : <%=journal.getIssnPpub()%>
            </i>
        </div>
        <div>
            <i> ISSN EPUB : <%=journal.getIssnEpub()%>
            </i>
        </div>
        <br>
        <br>
        <br>
        Back to <a href="admin/admin.jsp"> <i>Publisher Page </i> </a>

    </section>
</div>


</body>
</html>
