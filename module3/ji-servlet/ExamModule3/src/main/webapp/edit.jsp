<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
    <h1>Chỉnh sửa bệnh án</h1>
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
            </ul>
        </div>
    </div>
</nav>
<div style="background-color: deeppink">
    <div class="container mt-3 col-12">
        <form method="post">
            <div class="form-outline mb-4">
                <label>Mã bệnh án: </label>
                <input type="text" name="maBenhAn" value="${maBenhAn}" class="form-control" readonly>
<%--                <div class="text-black text-center bg-warning">${errMap.errEmployeeName}</div>--%>
            </div>
            <div class="form-outline mb-4">
                <label>Mã bệnh nhân: </label>
                <input type="text" name="maBenhNhan" value="${maBenhNhan}" class="form-control" readonly>
<%--                <div class="text-black text-center bg-warning">${errMap.errEmployeeBirthday}</div>--%>
            </div>
            <div class="form-outline mb-4">

                <label>Tên bệnh nhân: </label>
                <input type="text" name="ngayNhapVien" value="${tenBenhNhan}" class="form-control ">
<%--                <div class="text-black text-center bg-warning">${errMap.errIdCard}</div>--%>
            </div>
            <div class="form-outline mb-4">
                <label>Ngày nhập viện: </label>
                <input type="date" name="ngayXuatVien" value="${ngayNhapVien}" class="form-control">
<%--                <div class="text-black text-center bg-warning">${errMap.errEmployeeSalary}</div>--%>
            </div>
            <div class="form-outline mb-4">
                <label>Ngày xuất viện: </label>
                <input type="date" name="employeePhone" value="${ngayXuatVien}" class="form-control ">
<%--                <div class="text-black text-center bg-warning">${errMap.errEmployeePhone}</div>--%>
            </div>
            <div class="form-outline mb-4">
                <label>lý do nhập viện: </label>
                <input type="text" name="employeeEmail" value="${lyDo}" class="form-control ">
<%--                <div class="text-black text-center bg-warning">${errMap.errEmpoyeeEmail}</div>--%>
            </div>

<%--            <div class="form-outline mb-4">--%>
<%--                <label class="form-label" for="form1Example10">Employee Position</label>--%>
<%--                <select class="form-select" aria-label="Default select example" id="form1Example10" name="positionId">--%>
<%--                    <c:forEach items="${listPosition}" var="i">--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${i.positionId == positionId1}">--%>
<%--                                <option value="${i.positionId}" selected>${i.positionName}</option>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <option value="${i.positionId}">${i.positionName}</option>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--                <div class="text-black text-center bg-warning">${errMap.errPositionId}</div>--%>

<%--            </div>--%>
            <button type="submit" class="btn btn-danger">Edit</button>
        </form>
    </div>
</div>
</body>
<link rel="stylesheet" href="bootstrap/popper.min.js">
<link rel="stylesheet" href="bootstrap/bootstrap.min.js">
</html>


