<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 5/31/2022
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post" action="product?action=edit">
    <h1>product information</h1>
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" value="${id}"></td>
        </tr>
        <tr>
            <td>Tên:</td>
            <td><input type="text" name="ten" value="${ten}"></td>
        </tr>
        <tr>
            <td>Giá:</td>
            <td><input type="text" name="gia" value="${gia}"></td>
        </tr>
        <tr>
            <td>Mô tả:</td>
            <td><input type="text" name="moTa" value="${moTa}"></td>
        </tr>
        <tr>
            <td>Nhà sản xuất:</td>
            <td><input type="text" name="sanXuat" value="${sanXuat}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update product"></td>
        </tr>
    </table>
</form>
</body>
</html>
