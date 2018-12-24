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
    <title>Create journal</title>
    <style>
        <%@include file="/WEB-INF/CSS/styleSheet.css" %>
    </style>
</head>
</head>
<body>
<div class="container">
    <section id="content">
        <form action="/createJournal" method="post">
            <h1>Create Journal</h1>
            <div>
                <input type="text" placeholder="Title" name="journal-name" required/>
            </div>
            <div>
                <input type="text" placeholder="Publisher Name" name="publisher-name" required/>
            </div>
            <div>
                <input type="text" placeholder="Publisher Location" name="publisher-location" required/>
            </div>
            <div>
                <input type="text" placeholder="Publisher ID" name="publisher-id" required/>
            </div>
            <div>
                <input type="text" placeholder="User name" name="user-name" required />
            </div>
            <div>
                <input type="text" placeholder="ISSN-PPUB" name="issn-ppub" required/>
            </div>
            <div>
                <input type="text" placeholder="ISSN-EPUB" name="issn-epub" required/>
            </div>
            <div>
                <input type="submit" value="Create"/>
            </div>

            <a href="/admin/admin.jsp"><i>Publisher Page</i></a>

        </form><!-- form -->
    </section><!-- content -->
</div>

</body>
</html>
