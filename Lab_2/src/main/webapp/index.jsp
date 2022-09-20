<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>Lab 2</h2>

<h2>Get</h2>
<form method="get" action=GoSss name="get">
    <label> Name
        <input name="firstname" type="text">
    </label>
    <label> Lastname
        <input name="lastname" type="text">
    </label>

    <input type="button" onclick="document.get.submit()" value="get">
</form>

<h2>Post</h2>
<form method="post" action=GoSss name="post">
    <label> Name
        <input name="firstname" type="text">
    </label>
    <label> Lastname
        <input name="lastname" type="text">
    </label>

    <input type="submit" onclick="document.post.submit()" value="post">
</form>
</body>
</html>
