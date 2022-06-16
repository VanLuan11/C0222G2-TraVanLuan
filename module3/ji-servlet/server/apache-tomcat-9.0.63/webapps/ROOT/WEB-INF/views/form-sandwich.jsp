<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 6/16/2022
  Time: 5:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/form-sandwich">
    <h2>Sandwich Condiments</h2>
    <input type="checkbox" name="condiment" value="lettuce">
    <label>lettuce</label>
    <input type="checkbox" name="condiment" value="tomato">
    <label>tomato</label>
    <input type="checkbox" name="condiment" value="mustard">
    <label>mustard</label>
    <input type="checkbox" name="condiment" value="sprouts">
    <label>sprouts</label>
    <button>save</button>
</form>
    <h3>Sandwich with: </h3>
    <c:forEach items="${condiment}" var="spice">
        <h5>${spice}</h5>
    </c:forEach>
</body>
</html>
