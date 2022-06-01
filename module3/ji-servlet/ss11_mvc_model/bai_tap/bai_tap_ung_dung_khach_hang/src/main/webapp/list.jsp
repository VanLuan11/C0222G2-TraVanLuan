<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 5/31/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product?action=create">Create Product</a>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Tên sản phầm</th>
        <th>Giá sản phầm</th>
        <th>Mô tả sản phầm</th>
        <th>Nhà sản xuất</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="temp" items="${listProduct}">
        <tr>
            <td>${temp.id}</td>
            <td>${temp.name}</td>
            <td>${temp.price}</td>
            <td>${temp.description}</td>
            <td>${temp.producer}</td>
            <td><a href="/product?action=edit&id=${temp.id}">edit</a></td>
            <td><a href="/product?action=delete&id=${temp.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<form action="home?action=search" method="post">
    <input type="text" name="searchValue">
    <button type="submit">Search</button>
</form>
</body>
</html>
