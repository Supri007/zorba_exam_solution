<%--
  Created by IntelliJ IDEA.
  User: Suprima
  Date: 9/1/2024
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
<h1>MVC User Registration</h1>
<br>
<hr>
<form action="userRegistration/saveUserData" method="POST">
    <br>Name
    <input type="text" name="name" value=""
           placeholder="Enter your Name" maxlength="10">
    <br><br> Email
    <input type="text" name="email" value=""
           placeholder="Enter your Email" maxlength="30">
    <br><br> Mobile
    <input type="text" name="mobile" value="">
    <br><br> Username
    <input type="text" name="userName" value=""
           placeholder="Enter your username" maxlength="20">
    <br><br> Password
    <input type="password" name="password">
    <br><br>
    <input type="submit">
</form>
<form>
    <button type="submit" formaction="http://localhost:8081/SpringWebMVCExam/userRegistration/getAllUsers">View Users</button>
</form>

</body>
</html>
