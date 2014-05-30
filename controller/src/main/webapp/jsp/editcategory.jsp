<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit category</title>
</head>
<body>
<form action="/admin/" method="post">
<p>
<input type="hidden" name="operation" value="editwritecategory">
<input type="hidden" name="id" value="<c:out value="${category.id}"></c:out>">
category:<input name="category" value="<c:out value="${category.category}"></c:out>"><br>
<input type="submit">
</p>
</form>
</body>
</html>