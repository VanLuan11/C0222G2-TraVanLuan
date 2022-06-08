<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/6/2022
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/normalize.css">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
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
    <h1>List Employee</h1>
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
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/employee?action=create">Create Employee</a>
                </li>
            </ul>
            <form class="d-flex " method="get" action="/employee?action=search">
                <input name="action" value="search" type="hidden">
                <input name="search" value="${txtSearch}" class="form-control me-2" type="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div>
    <div class="col-12 text-center">
        <table id="tableStudent" class="table table-striped table-bordered" style="width: 100%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Id Card</th>
                <th>Salary (VNĐ)</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Adderss</th>
                <th>Position Id</th>
                <th>Education Degree Id</th>
                <th>Division Id</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="temp" items="${listEmployee}">
                <tr>
                    <td>${temp.employeeId}</td>
                    <td>${temp.employeeName}</td>
                    <td>${temp.employeeBirthday}</td>
                    <td>${temp.employeeIdCard}</td>
                    <td><fmt:formatNumber currencyCode="currency" value="${temp.employeeSalary}"/></td>
                    <td>${temp.employeePhone}</td>
                    <td>${temp.employeeEmail}</td>
                    <td>${temp.employeeAddress}</td>
                    <td>
                        <c:if test="${temp.positionId==1}">Quản lý</c:if>
                        <c:if test="${temp.positionId==2}">Nhân viên</c:if>
                    </td>
                    <td>
                        <c:if test="${temp.educationDegreeId==1}">Trung Cấp</c:if>
                        <c:if test="${temp.educationDegreeId==2}">Cao Đẳng</c:if>
                        <c:if test="${temp.educationDegreeId==3}">Đại Học</c:if>
                        <c:if test="${temp.educationDegreeId==4}">Sau Đại Học</c:if>
                    </td>
                    <td>
                        <c:if test="${temp.divisionId==1}">Sale-Marketing</c:if>
                        <c:if test="${temp.divisionId==2}">Hành chính</c:if>
                        <c:if test="${temp.divisionId==3}">Phục vụ</c:if>
                        <c:if test="${temp.divisionId==4}">Quản lý</c:if>
                    </td>
                    <td><a class="btn btn-danger" href="/employee?action=edit&idEdit=${temp.employeeId}">Edit</a></td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#exampleModal${temp.employeeId}">
                            Delete
                        </button>

                        <div class="modal fade" id="exampleModal${temp.employeeId}" tabindex="-1"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Xoá Employee</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Bạn có muốn xoá Id: ${temp.employeeId} và
                                            Tên: ${temp.employeeName} không?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No
                                        </button>
                                        <button type="button" class="btn btn-secondary "><a
                                                style=" text-decoration: none ;color: white"
                                                href="/employee?action=delete&idDelete=${temp.employeeId}">Yes</a>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<link rel="stylesheet" href="bootstrap/popper.min.js">
<link rel="stylesheet" href="bootstrap/bootstrap.min.js">
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'Irtip',
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
</html>


