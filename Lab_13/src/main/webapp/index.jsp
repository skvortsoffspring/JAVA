<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="example.lab13.ChoiceXXX" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    String d = config.getServletContext().getInitParameter("docs");
    ChoiceXXX ch = new ChoiceXXX(d, "docx");
    String file;
    for (int i = 0; i < ch.list.length; i++) {
        file = ch.list[i];
    %>
    <br />
    <a href="/Lab_13/Sss?file=<%=file%>"> <%=file%> </a>
<%}%>
</body>
</html>