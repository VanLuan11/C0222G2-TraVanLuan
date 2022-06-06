<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/6/2022
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="row background-color: #acbad4">
    <div class="container mt-3">
        <form method="post">
            <label>Customer Id: </label>
            <input type="text" name="id" value="${customerId}" class="form-control mt-3"   readonly>
            <br>
            <label>Customer Type Id: </label>
            <select name="customerTypeId" value="${customerTypeId}">
                <option value="1">Diamond</option>
                <option value="2">Platinium</option>
                <option value="3">Gold</option>
                <option value="4">Silver</option>
                <option value="5">Member</option>
            </select>
            <br>

            <label>Name: </label>
            <input type="text" name="name" value="${name}"  class="form-control mt-3">

            <label>Birthday: </label>
            <input type="text" name="birthday" value="${birthday}"  class="form-control mt-3">

            <label>Gender: </label>
            <select name="gender"  value="${gender}">
                <option value="1">Nam</option>
                <option value="0">Nữ</option>
                <option value="2">Khác</option>
            </select>
            <br>
            <label>Id Card: </label>
            <input type="text" name="idCard"  value="${idCard}"  class="form-control mt-3">

            <label>Phone: </label>
            <input type="text" name="phone" value="${phone}" class="form-control mt-3">

            <label>Email: </label>
            <input type="text" name="email" value="${email}"  class="form-control mt-3">

            <label>Address: </label>
            <input type="text" name="address" value="${address}"  class="form-control mt-3">
            <label>status: </label>
            <input type="text" name="status" value="${status}"   class="form-control mt-3">
            <button type="submit">Edit</button>

        </form>
    </div>
</div>
</body>
</html>
