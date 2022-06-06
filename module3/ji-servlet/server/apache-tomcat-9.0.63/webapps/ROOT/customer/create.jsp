<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/5/2022
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customer">
    <p>Back Home</p>
</a>


<div class="container mt-3">
    <h2>Create Customer</h2>
    <form action="/customer?action=create" method="post">
        <div class="mb-3 mt-3">
            <label>Customer Type Id: </label>
            <select name="customerTypeId">
                <option value="1">Diamond</option>
                <option value="2">Platinium</option>
                <option value="3">Gold</option>
                <option value="4">Silver</option>
                <option value="5">Member</option>
            </select>
        </div>
        <div class="mb-3">
            <label>Name:</label>
            <input class="form-control" name="name">
        </div>
        <div class="mb-3">
            <label>Birthday:</label>
            <input class="form-control" name="birthday">
        </div>
        <div class="mb-3">
            <label>Gender:</label>
            <select name="gender">
                <option value="1">Nam</option>
                <option value="0">Nữ</option>
                <option value="2">Khác</option>
            </select>
        </div>
        <div class="mb-3">
            <label>Id Card:</label>
            <input class="form-control" name="idCard">
        </div>
        <div class="mb-3">
            <label>Phone:</label>
                <input class="form-control" name="phone">
        </div>
        <div class="mb-3">
            <label>Email:</label>
            <input class="form-control" name="email">
        </div>
        <div class="mb-3">
            <label>Address:</label>
            <input class="form-control" name="address">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
