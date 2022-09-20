<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>Lab 3</h2>

<form method="post" action=GoSss name="post">
    <label> Name
        <input name="firstname" type="text">
    </label>
    <label> Lastname
        <input name="lastname" type="text">
    </label>
    <input type="button" onclick="document.post.submit()" value="post">
</form>
</body>
</html>
