<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/16/2022
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/caculator-form" method="post">
    <h1>Caculator</h1>
    <tr>
        <input type="text" name="num1" value="${num1}">
        <input type="text" name="num2" value="${num2}">
    </tr>
    <tr>
        <button name="operator" value="add">Addition(+)</button>
        <button name="operator" value="sud">Sudtraction(-)</button>
        <button name="operator" value="mul">Multiplication(X)</button>
        <button name="operator" value="div">Divison(/)</button>
    </tr>

    <p>Result: ${result}</p>
</form>

</body>
</html>
