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
    <h1>Create Customer</h1>
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
            </ul>
        </div>
    </div>
</nav>
<div style="background-color: deeppink">
    <div class="container mt-3 col-12">
        <form method="post">
            <div class="form-outline mb-4">
                <label>Customer Type Id: </label>
                <select class="form-select " name="customerTypeId" value="${customerTypeId}">
                    <option value="1">Diamond</option>
                    <option value="2">Platinium</option>
                    <option value="3">Gold</option>
                    <option value="4">Silver</option>
                    <option value="5">Member</option>
                </select>
            </div>
            <div class="form-outline mb-4">
                <label>Name: </label>
                <input type="text" name="name" value="${name}" class="form-control ">
            </div>
            <div class="form-outline mb-4">
                <label>Birthday: </label>
                <input type="date" name="birthday" value="${birthday}" class="form-control">
            </div>
            <div class="form-outline mb-4">
                <label>Gender: </label>
                <select class="form-select " name="gender" value="${gender}">
                    <option value="1">Nam</option>
                    <option value="0">Nữ</option>
                    <option value="2">Khác</option>
                </select>
            </div>
            <div class="form-outline mb-4">
                <label>Id Card: </label>
                <input type="text" name="idCard" value="${idCard}" class="form-control">
            </div>
            <div class="form-outline mb-4">
                <label>Phone: </label>
                <input type="text" name="phone" value="${phone}" class="form-control ">
            </div>
            <div class="form-outline mb-4">
                <label>Email: </label>
                <input type="text" name="email" value="${email}" class="form-control ">
            </div>
            <div class="form-outline mb-4">
                <label>Address: </label>
                <input type="text" name="address" value="${address}" class="form-control ">
            </div>
            <button type="submit" class="btn btn-danger">Create</button>
        </form>
    </div>
</div>
</body>
<link rel="stylesheet" href="bootstrap/popper.min.js">
<link rel="stylesheet" href="bootstrap/bootstrap.min.js">
</html>
