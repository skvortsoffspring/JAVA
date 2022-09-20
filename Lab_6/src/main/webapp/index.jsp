<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="params.jsp">get page contains params</a>
<br>

<form action="${pageContext.request.contextPath}/Ccc" method="post">

    <label>Value_1
        <input type="text" name="Value1">
    </label>
    <br>
    <label>Value_2
        <input type="text" name="Value2">
    </label>
    <br>
    <label>Value_3
        <input type="text" name="Value3">
    </label>
    <br>
    <label> Instance <br>
        new <input type="radio" name="CBean" value="new"> <br>
        old <input type="radio" name="CBean" value="old" checked> <br>
    </label>
    <br>
    <input type="submit" value="set values">
</form>
</body>
</html>