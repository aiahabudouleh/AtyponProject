<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/4/18
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Register</title>
    <style><%@include file="/WEB-INF/CSS/styleSheet.css"%></style></head>
<body>
<div class="container">
    <section id="content">
        <form action="/register" method="post">
            <h1>Register Form</h1>
            <div>
                <input type="text" placeholder="Username" name="username" required/>
            </div>
            <div>
                <input type="text" placeholder="uname@domain.com" name="email" required />
            </div>
            <div>
                <input type="password" placeholder="Password" name="password" required/>
            </div>
            <div>
                <input type="password" placeholder="RepeatedPassword" name="repassword" required/>
            </div>
                <input type="submit" value="Sign up"/>
            <a href="welcome.jsp"> Log-in </a>
        </form><!-- form -->
    </section><!-- content -->
</div><!-- container -->
</body>
</html>