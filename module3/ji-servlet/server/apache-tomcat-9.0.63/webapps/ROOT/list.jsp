<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 5/30/2022
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title   </title>
</head>
<body >
<table border="1" >
    <tr >
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="temp" items="${listCustomer}">
        <tr>
            <td>${temp.name}</td>
            <td>${temp.date}</td>
            <td>${temp.address}</td>
            <td><img src="${temp.image}" alt="" width="70px" height="70px"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
