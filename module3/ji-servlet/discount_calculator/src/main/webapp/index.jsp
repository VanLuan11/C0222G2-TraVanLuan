<%-- Created by IntelliJ IDEA. User: Admin Date: 27/5/2022 Time: 4:54 PM To change this template use File | Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<head>
    <title>Product Discount Calculator </title>
</head>
<body>
<div>
    <h1>Product Discount Calculator</h1>
    <form action="result.jsp" method="post">
        <div>
            <p>Product Description: </p>
            <input type="text" name="description"/> <br>
            <p>List Price: </p>
            <input type="text" name="price"/>
            <br>
            <p>Discount Percent: </p>
            <input type="text" name="precent"/>
        </div>
        <div>
            <br>
            <input type="submit" id="submit" value="calculate"/>
        </div>
    </form>
</div>

</body>
</html>
