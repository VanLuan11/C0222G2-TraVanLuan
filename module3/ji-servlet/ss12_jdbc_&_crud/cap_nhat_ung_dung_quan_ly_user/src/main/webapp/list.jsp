
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
            <td><a href="#">edit</a></td>
            <td><a href="#">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
