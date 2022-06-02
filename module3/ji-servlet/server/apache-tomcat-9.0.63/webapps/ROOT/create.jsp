<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/1/2022
  Time: 2:09 PM
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
<form action="/user?action=create" method="post">
    <tr>
        <td>Tên:</td>
        <input type="text" name="name">
        <br>
        <td>Email:</td>
        <input type="text" name="email">
        <br>
        <td>Country:</td>
        <input type="text" name="country">
        <button type="submit">Create</button>
    </tr>
</form>

</body>
</html>
