<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>FORM login</title>
    <meta content="no-store,no-cache,must-revalidate" http-equiv="Cache-Control"/>
    <meta content="no-cache" http-equiv="Pragma"/>
    <meta content="-1" http-equiv="Expires"/>
</head>
<body>
<form method="post" action="j_security_check">
    <label> username
        <input type="text" name="j_username" />
    </label>

     <label> password
         <input type="password" name="j_password" />
    </label>
    <input type="submit" />
</form>
</body>
</html>
