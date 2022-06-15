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
    <h1>Danh sách mặt bằng </h1>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-pink2">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item ">
                    <a class="navbar-brand " href="#">
                        <img class="border-6"
                             src="https://danangfantasticity.com/wp-content/uploads/2020/06/shilla-monogram-quangnam-danang-niem-tu-hao-cua-nganh-khach-san-han-quoc-chinh-thuc-ra-mat-tai-viet-nam.jpg " alt=""
                             width="40" height="40">
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/home">Home</a>
                </li>
            </ul>
            <form class="d-flex " method="get" action="/home?action=search">
                <input name="action" value="search" type="hidden">
                <input name="loaiMatBang" value="${txtSearchLoai}" class="form-control me-2" type="search"
                       placeholder="SearchLoaiMatBang"
                       aria-label="Search">
                <input name="giaTien" value="${txtSearchGia}" class="form-control me-2" type="search"
                       placeholder="SearchGia"
                       aria-label="Search">
                <input name="tang" value="${txtSearchTang}" class="form-control me-2" type="search"
                       placeholder="SearchTang"
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
                <th>Mã MB</th>
                <th>Diện tích</th>
                <th>Trạng thái</th>
                <th>tầng</th>
                <th>Loại văn  Phòng</th>
                <th>Giá cho thuê</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="temp" items="${listMatBang}">
                <tr>
                    <td>${temp.maMaBang}</td>
                    <td><fmt:formatNumber currencyCode="currency" value="${temp.dienTich}"/></td>
                    <c:forEach items="${listTrangThai}" var="l">
                        <c:if test="${l.idTrangThai == temp.idTrangThai}">
                            <td>${l.trangThai}</td>
                        </c:if>
                    </c:forEach>
                    <td>${temp.tang}</td>
                    <c:forEach items="${listLoaiMatBang}" var="l">
                        <c:if test="${l.idLoaiMatBang == temp.idLoaiMatBang}">
                            <td>${l.loai}</td>
                        </c:if>
                    </c:forEach>
                    <td><fmt:formatNumber currencyCode="currency" value="${temp.giaChoThue}"/></td>
                    <td>${temp.ngayBatDau}</td>
                    <td>${temp.ngayKetThuc}</td>
                    <td><a class="btn btn-danger" href="/home?action=edit&maEdit=${temp.maMaBang}">Edit</a></td>
                    <td>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#exampleModal${temp.maMaBang}">
                            Delete
                        </button>

                        <div class="modal fade" id="exampleModal${temp.maMaBang}" tabindex="-1"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Xoá bệnh án</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <p>Bạn có muốn xoá mặt bằng có mã ${temp.maMaBang}</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No
                                        </button>
                                        <button type="button" class="btn btn-secondary "><a
                                                style=" text-decoration: none ;color: white"
                                                href="/home?action=delete&maDelete=${temp.maMaBang}">Yes</a>
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
            "pageLength": 2
        });
    });
</script>
</html>


