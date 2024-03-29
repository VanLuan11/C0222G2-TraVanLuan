<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/6/2022
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>List Customer</h1>
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
                    <a class="nav-link active" aria-current="page" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/customer?action=create">Create Customer</a>
                </li>
            </ul>
            <form class="d-flex " method="get" action="/customer?action=search">
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
                <th>Type_id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Gender</th>
                <th>Id Card</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="temp" items="${listCustomer}">
                <tr>
                    <td>${temp.customerId}</td>
                    <td>
                        <c:if test="${temp.customerTypeId==1}">Diamond</c:if>
                        <c:if test="${temp.customerTypeId==2}">Platinium</c:if>
                        <c:if test="${temp.customerTypeId==3}">Gold</c:if>
                        <c:if test="${temp.customerTypeId==4}">Silver</c:if>
                        <c:if test="${temp.customerTypeId==5}">Member</c:if>
                    </td>
                    <td>${temp.name}</td>
                    <td>${temp.birthday}</td>
                    <td>
                        <c:if test="${temp.gender==0}">Nam</c:if>
                        <c:if test="${temp.gender==1}">Nữ</c:if>
                        <c:if test="${temp.gender==2}">Khác</c:if>
                    </td>
                    <td>${temp.idCard}</td>
                    <td>${temp.phone}</td>
                    <td>${temp.email}</td>
                    <td>${temp.address}</td>
                    <td><a class="btn btn-danger" href="/customer?action=edit&idEdit=${temp.customerId}">Edit</a></td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#exampleModal${temp.customerId}">
                            Delete
                        </button>

                        <div class="modal fade" id="exampleModal${temp.customerId}" tabindex="-1"
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
                                        <p>Bạn có muốn xoá Id: ${temp.customerId} và
                                            Tên: ${temp.name} không?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No
                                        </button>
                                        <button type="button" class="btn btn-secondary "><a
                                                style=" text-decoration: none ;color: white"
                                                href="/employee?action=delete&idDelete=${temp.customerId}">Yes</a>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
<%--                        <a class="btn btn-danger" href="/customer?action=delete&idDelete=${temp.customerId}">Delete</a>--%>
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
            "pageLength": 5
        });
    });
</script>
</html>

