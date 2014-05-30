<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit news</title>
</head>
<body>
<form action="/admin/" method="post">
<p>
<input type="hidden" name="operation" value="editwritenews">
<input type="hidden" name="id" value="<c:out value="${news.id}"></c:out>">
author:<input name="author" value="<c:out value="${news.author}"></c:out>"><br>
creationdate:<input name="creationdate" value="<c:out value="${news.creationdate}"></c:out>"><br>
title:<input name="title" value="<c:out value="${news.title}"></c:out>"><br>
annotation:<input name="annotation" value="<c:out value="${news.annotation}"></c:out>"><br>
category:<input name="categoryid" value="<c:out value="${news.category_id}"></c:out>"><br>
content:<br>
<textarea rows="15" cols="80" name="content"><c:out value="${news.content}"></c:out></textarea>
<br>
<input type="submit">
</p>
</form>
</body>
</html>