<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <td>
            <form method="post" action="../auth/">
            <p>
                email:<input name="id"><br>
                password:<input name="password" type="password"><br>
                <br>
                <input type="submit" value="Log in">
            </p>
        </form>
        </td>
    </tr>
    <tr>
        <td style="width: 670px"></td>
        <td>
    <c:if test="${not empty user}">
        Hello, <c:out value="${user.name}"></c:out>!<br>
        <a href="../logout/">Logout</a>
    </c:if>
    <c:if test="${empty user}">
        <a href="../registration/">Registration</a>
    </c:if>
    <c:if test="${admin == true}">
        <a href="../admin/">Admin</a>
    </c:if>
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
    <tr><td><c:if test="${author == true}">
        <c:if test="${not empty selectedcategory}">
            <a href="/site/?operation=addnews&category=<c:out value="${selectedcategory.id}"></c:out>">Add article</a>
        </c:if>
    </c:if>
    </td></tr>
</table >
</div>
</body>
</html>