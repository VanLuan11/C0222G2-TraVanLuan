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
<form:form action="/home/email" modelAttribute="email" method="post">
    <table>
        <tr>
            <td>
                <form:label path="languages">Languages: </form:label>
            </td>
            <td>
                <form:select path="languages">
                    <form:option value="english">English</form:option>
                    <form:option value="vietnamese">Vietnamese</form:option>
                    <form:option value="japanese">Japanese</form:option>
                    <form:option value="chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize">Page size: </form:label>
            </td>
            <td>
                <span>Show: </span>
                <form:select path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="20">20</form:option>
                    <form:option value="25">25</form:option>
                </form:select>
                <span>emails per page</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="spamsFiliter">Spams filter: </form:label>
            </td>
            <td>
                <form:checkbox path="spamsFiliter"/>
                <span>Enable spams filter</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="signatuer">Signatuer: </form:label>
            </td>
            <td>
                <form:textarea path="signatuer"/>
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
            <label>Languages: ${email.languages}</label>
        </td>
    </tr>
    <tr>
        <td>
            <label>Page Size: ${email.pageSize}</label>
        </td>
    </tr>
    <tr>
        <td>
            <label>Spams Filiter: ${email.spamsFiliter}</label>
        </td>
    </tr>
    <tr>
        <td>

            <label>Signatuer: ${email.signatuer}</label>
        </td>
    </tr>
</table>
</body>
</html>
