<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
<ul>

<c:forEach var="category" items="${categories}">
	<li><a href="?operation=showonlythiscategory&id=<c:out value="${category.id}"></c:out> "><c:out value="${category.category}"></c:out></a>
	<a href="?operation=editcategory&id=<c:out value="${category.id}"></c:out> ">Edit</a>
	<a href="?operation=deletecategory&id=<c:out value="${category.id}"></c:out> ">Delete</a>
<ul>
<c:forEach var="item" items="${category.news}">
	<li><a href="?operation=editnews&id=<c:out value="${item.id}"></c:out> "><c:out value="${item.title}"></c:out></a>
	<a href="?operation=deletenews&id=<c:out value="${item.id}"></c:out> ">Delete</a></li>
	
</c:forEach>
<li><a href="?operation=addnews&category=<c:out value="${category.id}"></c:out>">Add news</a></li>
</ul>
</li>

</c:forEach>
</ul>
<ul><li><a href="?operation=addcategory">Add category</a></li></ul>
<ul><li><a href="?operation=showusers">Find users</a></li></ul>

<form action="/admin/" method="post">
<p>
<input type="hidden" name="operation" value="showondate">
enter date (yyyy.mm.dd):<input name="date"><br>
<img src="<c:url value="/images/tomcat.png"/>" alt="">
</form>
</body>
</html>