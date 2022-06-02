<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/1/2022
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user?action=create">Create user</a>
<a href="/user?action=sort">Sort</a>

<form action="/user" method="get">
    <input name="action" value="search" type="hidden">
    <input type="text" name="searchCountry" value="${txtSearch}">
    <button type="submit">Search</button>
</form>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Tên user</th>
        <th>Email user</th>
        <th>Country user</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="temp" items="${listUser}">
        <tr>
            <td>${temp.id}</td>
            <td>${temp.name}</td>
            <td>${temp.email}</td>
            <td>${temp.country}</td>
            <td><a href="/user?action=update&idEdit=${temp.id}">edit</a></td>
            <td><a href="/user?action=delete&idDelete=${temp.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="bootstrap/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="bootstrap/popper.min.js">
<link rel="stylesheet" href="bootstrap/bootstrap.min.js">
</html>
