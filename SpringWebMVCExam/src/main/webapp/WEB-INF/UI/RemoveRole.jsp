<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dipen
  Date: 9/11/2024
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
    String pageURL = request.getQueryString();
    String userRole = pageURL.split("=")[1];
    String[] roles = userRole.split((","));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Please select role to remove</h1>

        <form>
            <c:forEach var="role" items="<%=roles%>">
                <input type="checkbox" id="roles" value="role"/>
                <label for="roles">${role}</label>
                <br>
            </c:forEach>
            <br><br>
            <input type="submit">
        </form>

</body>
</html>
