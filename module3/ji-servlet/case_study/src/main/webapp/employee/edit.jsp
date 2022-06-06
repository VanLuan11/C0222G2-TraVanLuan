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
            <input type="text" name="id" value="${employeeId}" class="form-control mt-3" readonly>

            <label>Name: </label>
            <input type="text" name="employeeName" value="${employeeName}" class="form-control mt-3">

            <label>Birthday: </label>
            <input type="text" name="employeebirthday" value="${employeebirthday}" class="form-control mt-3">

            <label>Id Card: </label>
            <input type="text" name="employeeIdCard" value="${employeeIdCard}" class="form-control mt-3">

            <label>Salary: </label>
            <input type="text" name="employeeSalary" value="${employeeSalary}" class="form-control mt-3">

            <label>Phone: </label>
            <input type="text" name="employeePhone" value="${employeePhone}" class="form-control mt-3">

            <label>Email: </label>
            <input type="text" name="employeeEmail" value="${employeeEmail}" class="form-control mt-3">

            <label>Address: </label>
            <input type="text" name="employeeAddress" value="${employeeAddress}" class="form-control mt-3">

            <label>Position Id: </label>
            <select name="positionId" value="${positionId}">
                <option value="1">Quản lý</option>
                <option value="2">Nhân viên</option>
            </select>

            <label>Education Degree Id: </label>
            <select name="educationDegreeId" value="${educationDegreeId}">
                <option value="1">Trung Cấp</option>
                <option value="2">Cao Đẳng</option>
                <option value="3">Đại Học</option>
                <option value="4">Sau Đại Học</option>
            </select>

            <label>Division Id: </label>
            <select name="divisionId" value="${divisionId}">
                <option value="1">Sale-Marketing</option>
                <option value="2">Hành chính</option>
                <option value="3">Phục vụ</option>
                <option value="4">Quản lý</option>
            </select>
            <label>User Name: </label>
            <input type="text" name="userName" value="${userName}" class="form-control mt-3">
            <button type="submit">Edit</button>
        </form>
    </div>
</div>
</body>
</html>

