<%--
  Created by IntelliJ IDEA.
  User: Suprima
  Date: 9/8/2024
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vendor Login</title>
</head>
<body>
    <h1>Vendor Login Page</h1>
    <form action="Vendor/validateVendor" method="POST">
        <br><br>
        <br>User Name
        <input type="text" name="userName" value=""
               placeholder="Enter your username" maxlength="20">
        <br><br> Password
        <input type="password" name="password">
        <br><br> Role
        <input type="text" name="role" value="Vendor" readonly>
        <br>
        <input type="submit">

    </form>
</body>
</html>
