<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Suprima
  Date: 9/7/2024
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Students Details</title>
</head>
<body>
<table border="1">
    <tr>
        <th>User Id</th>
        <th>Name</th>
        <th>User Email</th>
        <th>Mobile</th>
        <th>User Name</th>
        <th>User Role</th>
    </tr>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>
                <a href="http://localhost:8081/SpringWebMVCExam/userRegistration/addRoles?userId=${user.userId}">
                    <c:out value="${user.userId}"/>
                </a>
            </td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.mobile}"/></td>
            <td><c:out value="${user.userName}"/></td>
            <td>
                <a href="http://localhost:8081/SpringWebMVCExam/userRegistration/removeRoles?roles=${user.role}">
                    <c:out value="${user.role}"/>
                </a>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<br><br>
<form>
    <button type="submit" formaction="http://localhost:8081/SpringWebMVCExam/userRegistration">Home</button>
</form>
