<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ include file="evening.jsp"%>

<html>
<body>
<c:set var="date" value="<%=Calendar.getInstance()%>"/>
<c:set var="wf" value="<%=new SimpleDateFormat("EEEE")%>"/>
<c:set var="df" value="<%=new SimpleDateFormat("dd.MMMM.yyyy")%>"/>
<c:set var="HOUR" value="<%=Calendar.HOUR_OF_DAY%>"/>
<c:set var="DATE" value="<%=Calendar.DATE%>"/>

<c:choose>
    <c:when test="${date.get(HOUR) < 7}">
        <h3>Good night</h3>
    </c:when>
    <c:when test="${date.get(HOUR)  < 12}">
       <h3>Good morning</h3>
    </c:when>
    <c:when test="${date.get(HOUR)  < 17}">
        <h3>Good afternoon </h3>
    </c:when>
    <c:otherwise>
        <h3>Good  evening </h3>
    </c:otherwise>
</c:choose>

<c:forEach var="i" begin="0" end="6">
    <table border="1" width="300">
        <tr>
            <td><c:out value="${df.format(date.getTime())}"/></td>
            <td width="100"><c:out value="${wf.format(date.getTime())}"/></td>
        </tr>
    </table>
    <c:set var="day" value="${date.add(DATE, 1)}"/>
</c:forEach>

<c:set var="hour" value="${param.hour}"/>
<c:out value="${requestScope.get('hour')}"/>
<c:out value="${param.hour}"/>

<c:choose>
    <c:when test="${hour < 7}">
       <c:redirect url="night.jsp"/>
<%--        <jsp:include page="night.jsp"/>
        <% System.out.println("night.jsp");%>
--%>
    </c:when>
    <c:when test="${hour  < 12}">
        <c:redirect url="morning.jsp"/>
<%--
        <jsp:include page="morning.jsp"/>
        <% System.out.println("morning.jsp");%>
--%>
    </c:when>
    <c:when test="${hour < 17}">
      <%-- <c:redirect url="afternoon.jsp"/>;--%>
        <%
            response.sendRedirect(request.getContextPath() + "/afternoon");
        %>
        <%--
        <% System.out.println("afternoon.jsp");%>
--%>
    </c:when>
    <c:when test="${hour >= 17}">
    <c:redirect url="evening.jsp"/>
<%--
        <jsp:include page="afternoon.jsp"/>
        <% System.out.println("evening.jsp");%>
--%>
    </c:when>
</c:choose>

<button>
    <a style="text-decoration: none" href="index.jsp?hour=${date.get(HOUR)}">press</a>
</button>
<button>
    <a style="text-decoration: none" href="index.jsp?hour=14">const</a>
</button>
<button>
    <a style="text-decoration: none" href="daytime?hour=${date.get(HOUR)}">day of time</a>
</button>

<form method="post"${pageContext.request.contextPath}/daytime">
    <input type="hidden" name="hour" value="${date.get(HOUR)}">
    <input type="submit" value="post to servlet">
</form>
</body>
</html>