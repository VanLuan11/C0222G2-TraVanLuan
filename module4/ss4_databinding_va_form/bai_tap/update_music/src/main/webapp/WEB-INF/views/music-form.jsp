<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/17/2022
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/home/music" modelAttribute="music" method="post">
    <table>
        <tr>
            <td>
                <form:label path="ten">Tên bài: <hát></hát>: </form:label>
            </td>
            <td>
                <form:input path="ten"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="caSi">Nghệ sĩ thể hiện: </form:label>
            </td>
            <td>
                <form:input path="caSi"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="theLoai">Thể loại nhạc: </form:label>
            </td>
            <td>
                <form:select path="theLoai">
                    <form:option value="rap">Rap</form:option>
                    <form:option value="chuTinh">Chữ tình</form:option>
                    <form:option value="caiLuong">Cải lương</form:option>
                    <form:option value="vPop">Vpop</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="duongDan">Đường dẫn file bài hát: </form:label>
            </td>
            <td>
                <form:textarea path="duongDan"/>
            </td>
        </tr>
        <td>
            <button type="submit">update</button>
        </td>
        <td>
            <button type="reset">Cancel</button>
        </td>

    </table>
</form:form>
<table>
    <tr>
        <td>
            <label>Tên bài hát: ${music.ten} </label>
        </td>
    </tr>
    <tr>
        <td>
            <label>Nghệ sĩ thể hiện:${music.caSi} </label>
        </td>
    </tr>
    <tr>
        <td>
            <label>Thể loại nhạc: ${music.theLoai} </label>
        </td>
    </tr>
    <tr>
        <td>

            <label>ường dẫn file bài hát: ${music.duongDan} </label>
        </td>
    </tr>
</table>
</body>
</html>
