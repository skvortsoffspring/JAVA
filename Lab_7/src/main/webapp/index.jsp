<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="params.jsp">get page contains params</a>

<form action="${pageContext.request.contextPath}/Ccc" method="post">
    <label>
        <input type="text" name="Value1">
    </label>
    <label>
        <input type="text" name="Value2">
    </label>
    <label>
        <input type="text" name="Value3">
    </label>

    <label> Instance <br>
        new <input type="radio" name="CBean" value="new"> <br>
        old <input type="radio" name="CBean" value="old" checked> <br>
    </label>

    <input type="submit" value="set values">
</form>
</body>
</html>