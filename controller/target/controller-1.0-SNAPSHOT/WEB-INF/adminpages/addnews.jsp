<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="news" class="com.pvt.News" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add news</title>
</head>
<body>
<form action="/admin/" method="post">
<p>
<input type="hidden" name="operation" value="addwritenews">
<input type="hidden" name="category" value="<%=request.getParameter("category")%>">
<input type="hidden" name="author" value="<%=request.getAttribute("username")%>"><br>
id:<input name="id"><br>
title:<input name="title"><br>
annotation:<input name="annotation"><br>
content:<br>
<textarea rows="15" cols="80" name="content"></textarea>
<br>
<input type="submit">
</p>
</form>
</body>
</html>