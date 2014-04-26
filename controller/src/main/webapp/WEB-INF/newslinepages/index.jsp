<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>

<jsp:useBean id="categories" scope="request" type="java.util.List"/>
<c:forEach var="category" items="${categories}">
    <h1><li><c:out value="${category.category}"></c:out></h1>
<ul>
<c:forEach var="item" items="${category.news}">
	<h3><li><a href="?operation=shownews&id=<c:out value="${item.id}"></c:out> "><c:out value="${item.title}"></c:out></a></li></h3>
	<h4><span></span><c:out value="${item.annotation}"></c:out></span></h4>

</c:forEach>
</ul>
</li>

</c:forEach>
</ul>


</body>
</html>