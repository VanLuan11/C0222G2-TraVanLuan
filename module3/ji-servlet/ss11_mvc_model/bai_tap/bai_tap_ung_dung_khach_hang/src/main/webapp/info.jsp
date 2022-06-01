<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/1/2022
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${price}</td>
        <td>${description}</td>
    </tr>
    <tr>
        <th colspan="4"><a href="/product"><button type="button">Back to Home</button></a></th>
    </tr>
</table>
</body>
</html>
