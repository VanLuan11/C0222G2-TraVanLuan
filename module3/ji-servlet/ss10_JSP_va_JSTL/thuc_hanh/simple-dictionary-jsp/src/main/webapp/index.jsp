<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 5/30/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="tuDien" method="post">
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/>
</form>
${search}
<br>
${result}
<br>
${alert}
</body>
</html>
