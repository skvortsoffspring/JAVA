<%@ page import="com.example.lab_6.model.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ccc</title>
</head>
<body>
<% CBean atrCBean = (CBean)application.getAttribute("atrCBean"); %>
<div>value 1 = <%= atrCBean.getValue1()%></div>
<div>value 2 = <%= atrCBean.getValue2()%></div>
<div>value 3 = <%= atrCBean.getValue3()%></div>
</body>
</html>
