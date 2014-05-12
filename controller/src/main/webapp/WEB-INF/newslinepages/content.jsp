<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content</title>
</head>
<body>
<div>
    <h1><c:out value="${news.title}"></c:out></h1>
<c:out value="${news.content}"></c:out></div>

<c:if test="${not empty user}">
    <form method="post" action="/site/">
        <p> <input type="hidden" name="operation" value="addcomment">
            <input type="hidden" name="newsid" value="<c:out value="${news.id}"></c:out>">
            Leave a comment:
            <input name="comment" type="text"><br>
            <br>
            <input type="submit" value="Yarr!..">
        </p>
    </form>
</c:if>

<c:forEach var="comment" items="${news.comments}">
    <div>
    <div>#<c:out value="${comment.number}"></c:out></div>
    <div><c:out value="${comment.date}"></c:out></div>
    <div>Author: <c:out value="${comment.user.name}"></c:out></div>
    <div><c:out value="${comment.comment}"></c:out></div>
    <div><c:out value="///////////////////"></c:out></div>
    </div>
</c:forEach>
</body>
</html>