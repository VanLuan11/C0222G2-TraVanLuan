<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <meta charset="utf-8">
    <link rel="stylesheet" href="bootstrap/normalize.css">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="bootstrap/bootstrap.bundle.min.js"></script>
    <style>
        .bg-pink {
            background-color: #ec69b2 !important;
        }

        .bg-pink2 {
            background-color: #f1a6fc !important;
        }

        .text-black {
            background-color: black;
        }

        .border-6 {
            border-radius: 50%;
        }
    </style>

</head>
<body>
<div class="container-fluid p-5 bg-pink text-black text-center">
    <h1>Create Employee</h1>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-pink2">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item ">
                    <a class="navbar-brand " href="#">
                        <img class="border-6"
                             src="https://wikiland.vn/images/2020/08/furama-resort-spa-phu-quoc-wikiland.jpg" alt=""
                             width="40" height="40">
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/employee">Employee</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div style="background-color: deeppink">
    <div class="container mt-3 col-12">
        <form method="post">
            <div class="form-outline mb-4">
                <label>Name: </label>
                <input type="text" name="employeeName" class="form-control ">
                <div class="text-black text-center bg-warning">${errMap.errEmployeeName}</div>
            </div>
            <div class="form-outline mb-4">
                <label>Birthday: </label>
                <input type="date" name="employeebirthday" class="form-control ">
                <div class="text-black text-center bg-warning">${errMap.errEmployeeBirthday}</div>

            </div>
            <div class="form-outline mb-4">
                <label>Id Card: </label>
                <input type="text" name="employeeIdCard" class="form-control ">
                <div class="text-black text-center bg-warning">${errMap.errIdCard}</div>

            </div>
            <div class="form-outline mb-4">
                <label>Salary: </label>
                <input type="text" name="employeeSalary" class="form-control">
                <div class="text-black text-center bg-warning">${errMap.errEmployeeSalary}</div>

            </div>
            <div class="form-outline mb-4">
                <label>Phone: </label>
                <input type="text" name="employeePhone" class="form-control ">
                <div class="text-black text-center bg-warning">${errMap.errEmployeePhone}</div>

            </div>
            <div class="form-outline mb-4">
                <label>Email: </label>
                <input type="text" name="employeeEmail" class="form-control ">
                <div class="text-black text-center bg-warning">${errMap.errEmpoyeeEmail}</div>

            </div>
            <div class="form-outline mb-4">
                <label>Address: </label>
                <input type="text" name="employeeAddress" class="form-control">
                <div class="text-black text-center bg-warning">${errMap.errEmployeeAddress}</div>

            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example10">Employee Position</label>
                <select class="form-select" aria-label="Default select example" id="form1Example10" name="positionId">
                    <c:forEach items="${listPosition}" var="i">
                        <option value="${i.positionId}">${i.positionName}</option>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errPositionId}</div>

            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example11">Employee Education Degree</label>
                <select class="form-select" aria-label="Default select example" id="form1Example11"
                        name="educationDegreeId">
                    <c:forEach items="${listED}" var="i">
                        <option value="${i.educationDegreeId}">${i.educationDegreeName}</option>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeName}</div>

            </div>
            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example12">Employee Division</label>
                <select class="form-select" aria-label="Default select example" id="form1Example12" name="divisionId">
                    <c:forEach items="${listDivision}" var="i">
                        <option value="${i.divisionId}">${i.divisionName}</option>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errDivisionId}</div>

            </div>
            <button type="submit" class="btn btn-danger">Create</button>
        </form>
    </div>
</div>
</body>
<link rel="stylesheet" href="bootstrap/popper.min.js">
<link rel="stylesheet" href="bootstrap/bootstrap.min.js">
</html>

