
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/2/2022
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/normalize.css">
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
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
    <h1>Ứng Dụng Quản Lý Khu Nghỉ Dưỡng Furama</h1>
    <p>Được thành lập bởi công ty PhươngMaster</p>
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
                    <a class="nav-link active" aria-current="page" href="/employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">asdas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">asda</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="row">
    <div class="col-2">
        <img height="100%" width="100%" src="https://cdn.brvn.vn/editor/2021/04/U54901_phimquangcaobiahanoi_1617793843.png" alt="">
    </div>
    <div class="col-8 text-center">
        <img width="100%" src="https://danangfantasticity.com/wp-content/uploads/2020/06/shilla-monogram-quangnam-danang-niem-tu-hao-cua-nganh-khach-san-han-quoc-chinh-thuc-ra-mat-tai-viet-nam.jpg" alt="">
    </div>
    <div class="col-2">
        <img height="100%" width="100%" src="https://www.chupsanpham.net/wp-content/uploads/2017/08/05.jpg" alt="">
    </div>

</div>
<div class="container-fluid bg-pink text-black text-center bg-secondary">
    <h6>Công Ty PhươngMaster 6/3/2022</h6>
</div>
</body>
<link rel="stylesheet" href="bootstrap/popper.min.js">
<link rel="stylesheet" href="bootstrap/bootstrap.min.js">
</html>

