<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Params</title>
</head>
<body>
<h3>
  <%= application.getInitParameter("URL1") %>
    <br>
  <%= application.getInitParameter("URL2") %>
</h3>
</body>
</html>
