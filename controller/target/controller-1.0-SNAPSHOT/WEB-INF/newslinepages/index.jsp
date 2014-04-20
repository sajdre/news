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

<c:forEach var="category" items="${categories}">
	<li><c:out value="${category.category}"></c:out>
<ul>
<c:forEach var="item" items="${category.newsByCategory}">
	<li><h3><a href="siteController?operation=shownews&id=<c:out value="${item.id}"></c:out> "><c:out value="${item.title}"></c:out></a></h3>
	<br><c:out value="${item.annotation}"></c:out></li>
	
</c:forEach>
</ul>
</li>

</c:forEach>
</ul>
</body>
</html>