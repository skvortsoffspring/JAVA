<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    .ui-button{
      display: inline-block;
      width: 16px;
      height: 16px;
      padding: 7px;
      margin-right: 5px;
      text-decoration: none;
      background-color: #ffad00;
      color: white;
      text-align: center;
      font-size: 14px;
    }
    body{
        width: 600px;
        margin-left: auto;
        margin-right: auto;
    }
  </style>
</head>
<body>

<c:set var="students" value="<%=request.getAttribute("students")%>"/>
<c:set var="iterator" value="0"/>

<table border=1 align=center width=600>
<tr  bgcolor="#ffad00"><th>id</th><th>name</th><th>phone</th><th>email</th>

<c:forEach var="student" items="${students}" begin="0" end="9">
  <tr>
      <td><c:out value="${student.getId()}"/></td>
      <td><c:out value="${student.getName()}"/></td>
      <td><c:out value="${student.getPhone()}"/></td>
      <td><c:out value="${student.getEmail()}"/></td>
  </tr>
</c:forEach>
    
<c:if test="${students.size() > 8}">
<c:forEach var="student" items="${students}" step="8">
  <a href="${pageContext.request.contextPath}/students/page/${iterator}" class="ui-button">${iterator = iterator + 1}</a>
</c:forEach>
</c:if>
</table>
</body>
</html>

