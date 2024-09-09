<%--
  Created by IntelliJ IDEA.
  User: dipen
  Date: 9/8/2024
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    Inventory category
    Inventory Name
    Inventory quantity
    Inventory price(per unit)
    Inventory Image (input data for example. : image from internet (jpg/png))
    Inventory Description
</head>
<body>
    <h1>Inventory Page</h1>
    <form action="Vendor/validateData" method="POST">
        <br><br>
        <br>Inventory category
        <input type="text" name="category" value=""
               placeholder="Enter Inventory category" maxlength="20">
        <br><br> Inventory Name
        <input type="text" name="name" value=""
               placeholder="Enter Inventory name" maxlength="20">
        <br><br> Inventory quantity
        <input type="text" name="quantity" value="" maxlength="10">
        <br>
        <br><br> Inventory Price
        <input type="text" name="price" value="" maxlength="10">
        <br>
        <br><br> Inventory Image
        <input type="image" name="image" value="" maxlength="10">
        <br>
        <br><br> Inventory Description
        <input type="text" name="description" value="" maxlength="10">
        <br>
        <input type="submit">

    </form>
</body>
</html>
