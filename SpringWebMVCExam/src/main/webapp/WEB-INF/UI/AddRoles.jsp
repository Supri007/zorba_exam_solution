<%@ page import="static java.awt.SystemColor.window" %><%--
  Created by IntelliJ IDEA.
  User: dipen
  Date: 9/8/2024
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    const pageUrl = window.location.search.substring(1);
    console.log(pageUrl);
</script>
<%
    String pageURL = request.getQueryString();
    String userId = pageURL.split("=")[1];
%>
<html>
<head>
    <title>User Role</title>
</head>
<body>
    <h1>Please select user role</h1>
    <form action="addRolesForUser" method="POST">
        <select name="userRole">
            <option name="ADMIN" value="ADMIN">ADMIN</option>
            <option name="USER" value="USER">USER</option>
            <option name="VENDOR" value="VENDOR">VENDOR</option>
        </select>
        <input type="hidden" name="userId" value="<%=userId%>" readonly>
        <input type="hidden" name="role" value="userRole" readonly>
        <input type="submit"/>
    </form>

</body>
</html>
