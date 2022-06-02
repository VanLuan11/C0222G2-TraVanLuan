<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/1/2022
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/user">
    <p>Quay lại Memu</p>
</a>
<form action="/user?action=update" method="post">
    <tr>
        <td>Id</td>
        <input type="text" name="idEdit" value="${id}" readonly>
        <br>
        <td>Tên:</td>
        <input type="text" name="nameEdit" value="${ten}">
        <br>
        <td>Email:</td>
        <input type="text" name="emailEdit" value="${email}">
        <br>
        <td>Country:</td>
        <input type="text" name="countryEdit" value="${country}">
        <button type="submit">Update</button>
    </tr>
</form>

</body>
</html>
