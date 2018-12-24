<%--
  Created by IntelliJ IDEA.
  User: aabudouleh
  Date: 11/4/18
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <style><%@include file="/WEB-INF/CSS/styleSheet.css"%></style></head>
<body>

<div class="container">
    <section id="content">
        <form action="/welcome" method="post">
            <h1>Login Form</h1>
            <div>
                <input type="text" placeholder="Username" name="username" />
            </div>
            <div>
                <input type="password" placeholder="Password" name="userpassword" />
            </div>
            <div>
                <input type="submit" value="Log in" />
                <a href="register.jsp">Register</a>
            </div>
        </form><!-- form -->

    </section><!-- content -->
</div><!-- container -->
</body>
</html>