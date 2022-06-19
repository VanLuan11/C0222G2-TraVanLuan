
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2022
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .text-center {
            text-align: center;
        }
        .text-red {
            color: red;
        }
        .container {
            width: 100%;
            display: block;
        }
        .col-12 {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="text-center">TỜ KHAI Y TẾ</div>
<div class="text-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT
    ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM
</div>
<div class="text-center text-red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
    sự
</div>
<div class="container">
    <form:form action="/home" modelAttribute="medical" method="post">
        <label>Họ tên (ghi chữ IN HOA): </label> <span class="text-red">(*)</span> <br>
        <form:input type="text" class="col-12" path="name"/>

        <label>Năm sinh: </label> <span class="text-red">(*)</span> <br>
        <form:input type="text" class="col-12" path="birthday"/>

        <label>Giới tính: </label> <span class="text-red">(*)</span> <br>
        <form:select path="gender">
            <form:option value="nam">Nam</form:option>
            <form:option value="nữ">Nữ</form:option>
            <form:option value="khác">Other</form:option>
        </form:select> <br>

        <label>Quốc tịch</label> <span class="text-red">(*)</span> <br>
        <form:input type="text" class="col-12" path="nation"/>

        <label>Hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label> <span class="text-red">(*)</span> <br>
        <form:input type="text" class="col-12" path="idCard"/> <br>

        <label>Thông tin đi lại</label> <span class="text-red">(*)</span> <br>

        <form:radiobutton path="vehicle" value="tàu bay"/> Tàu bay <form:radiobutton path="vehicle" value="tàu thuyền"/> tàu thuyền
        <form:radiobutton path="vehicle" value="ô tô"/> Ô tô <form:radiobutton path="vehicle" value="khác"/> Khác (Ghi rõ) <br>

        <label>Số hiệu phương tiện: </label> <br>
        <form:input type="text" class="col-12" path="licensePlates"/> <br>

        <label>Số ghế :</label> <br>
        <form:input type="text" class="col-12" path="numberOfSeats"/>

        <label>Ngày khởi hành</label> <span class="text-red">(*)</span>
        <form:input type="date" path="dateStart"/> <br>

        <label>Ngày kết thúc</label> <span class="text-red">(*)</span>
        <form:input type="date" path="dateEnd"/> <br>
        
        <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/ thành phố nào?</label> <span class="text-red">(*)</span>
        <br>
        <form:textarea path="moveInfo" cssClass="col-12"></form:textarea>
        <button>Submit</button>
    </form:form>
</div>
<div class="container">
    <fieldset>
        <legend>Medical Declaration Result</legend>
        <table>
            <tr>
                <td class="title">Name:</td>
                <td>
                    ${medicalResult.name}
                </td>
            </tr>
            <tr>
                <td class="title">Birthday:</td>
                <td>
                    ${medicalResult.birthday}
                </td>
            </tr>
            <tr>
                <td class="title">Gender:</td>
                <td>
                    ${medicalResult.gender}
                </td>
            </tr>
            <tr>
                <td class="title">Nation:</td>
                <td>
                    ${medicalResult.nation}
                </td>
            </tr>
            <tr>
                <td class="title">Id Card:</td>
                <td>
                    ${medicalResult.idCard}
                </td>
            </tr>
            <tr>
                <td class="title">Vehicle:</td>
                <td>
                    ${medicalResult.vehicle}
                </td>
            </tr>
            <tr>
                <td class="title">License Plates:</td>
                <td>
                    ${medicalResult.licensePlates}
                </td>
            </tr>
            <tr>
                <td class="title">Number of Seats:</td>
                <td>
                    ${medicalResult.numberOfSeats}
                </td>
            </tr>
            <tr>
                <td class="title">Date Start:</td>
                <td>
                    ${medicalResult.dateStart}
                </td>
            </tr>
            <tr>
                <td class="title">Date End:</td>
                <td>
                    ${medicalResult.dateEnd}
                </td>
            </tr>
            <tr>
                <td class="title">Move Info:</td>
                <td>
                    ${medicalResult.moveInfo}
                </td>
            </tr>
        </table>
    </fieldset>
</div>
</body>
</html>
