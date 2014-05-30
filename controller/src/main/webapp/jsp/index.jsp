<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Newsline</title>
</head>
<body>
<div style="width: 900px; margin-left: auto; margin-right: auto">
<table bgcolor="#3A539B" align="right" style="width: 900px; ">
    <tr>
        <td style="width: 670px"></td>

    </tr>
    <tr>
        <td style="width: 670px"></td>
        <td>
        <security:authorize access="isAuthenticated()">
        Hello, <security:authentication property="principal.username"/>!<br>
        <a href="/site/j_spring_security_logout">Logout</a>
        </security:authorize>

        <security:authorize access="isAnonymous()">
        <a href="../registration">Registration</a>
        </security:authorize>

        <security:authorize access="hasRole('ROLE_ADMIN')">
        <a href="../admin/">Admin</a>
        </security:authorize>

        </td>
    </tr>
</table>
<table bgcolor="#22313F" align="center" width="900px" style="text-align: center; color: black; font-variant: all-petite-caps;">
    <tr>
        <c:forEach var="category" items="${categories}">
            <td><a href="?category=<c:out value="${category.id}"></c:out>" style="font-family: helvetica; color: #E26A6A; text-transform: uppercase; text-decoration: none"><c:out value="${category.category}"></c:out></a></td>
        </c:forEach>
    </tr>

</table>
<table bgcolor="#67809F" width="900px">
    <c:forEach var="news" items="${newslist}">
        <tr><td><a href="?operation=shownews&id=<c:out value="${news.id}"></c:out>"><c:out value="${news.title}"></c:out></a></td></tr>
        <tr><td><c:out value="${news.annotation}"></c:out></td></tr>
    </c:forEach>
    <tr><td>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <c:if test="${not empty categoryid}">
            <a href="/admin/?operation=addnews&categoryid=<c:out value="${categoryid}"></c:out>">Add article</a>
            </c:if>
        </security:authorize>

    </td></tr>
</table >
</div>
</body>
</html>