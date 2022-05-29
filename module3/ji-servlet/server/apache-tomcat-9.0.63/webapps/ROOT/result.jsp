<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 5/29/2022
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String description = request.getParameter("description");
    float price = Float.parseFloat(request.getParameter("price"));
    int discountPercent= Integer.parseInt(request.getParameter("precent"));
    float discount = (float) (price*discountPercent*0.01);
    float total = price - discount;
%>
<h1>Porduct Description <%=description%></h1>
<h1>Porduct Price <%=price%></h1>
<h1>Porduct Discount Percent <%=discountPercent%></h1>
<h1>Porduct Discount <%=discount%></h1>
<h1>Porduct Total <%=total%></h1>
</body>
</html>
