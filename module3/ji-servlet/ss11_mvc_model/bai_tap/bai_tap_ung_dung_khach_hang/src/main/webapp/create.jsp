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
<form method="post" action="product?action=create">
    <label>Nhập id</label>
    <input type="text" name="id"><br>
    <label>Nhập tên  sản phầm</label>
    <input type="text" name="ten"><br>
    <label>Nhập giá sản phầm</label>
    <input type="text" name="gia"><br>
    <label>Nhập mô tả sản phẩm</label>
    <input type="text" name="moTa"><br>
    <label>Nhập nhà sản xuất</label>
    <input type="text" name="sanXuat">
    <button type="submit">Create</button>
</form>
</body>
</html>
