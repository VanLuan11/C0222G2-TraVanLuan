<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/15/2022
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/form-dictionary" method="post">
    <table>
        <tr>
            <td>English: </td>
            <td>
                <input type="text" name="english" value="${english}">
            </td>
        </tr>
        <tr>
            <td>Tiếng việt: </td>
            <td>
                <input type="text" value="${tiengViet}" readonly>
            </td>
        </tr>
        <td>
            <button>Dịch</button>
        </td>
    </table>
</form>
</body>
</html>
