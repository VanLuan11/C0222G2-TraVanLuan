<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/15/2022
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <table>
        <tr>
            <th>VND</th>
            <td>
            <input type="text" name="vnd" value="${vnd}">
            </td>
            <th>USD</th>
            <td>
            <input type="text" name="usd" value="${usd}" readonly>
            </td>
            <td>
                <button>Đổi tiền Lậu</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
