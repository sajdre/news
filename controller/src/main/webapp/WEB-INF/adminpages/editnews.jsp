<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="news" class="com.pvt.daoEntities.News" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/admin/" method="post">
<p>
<input type="hidden" name="operation" value="editwritenews">
<input type="hidden" name="id" value="<jsp:getProperty property="id" name="news"/>">
author:<input name="author" value="<jsp:getProperty property="author" name="news"/>"><br>
creationdate:<input name="creationdate" value="<jsp:getProperty property="creationdate" name="news"/>"><br>
title:<input name="title" value="<jsp:getProperty property="title" name="news"/>"><br>
annotation:<input name="annotation" value="<jsp:getProperty property="annotation" name="news"/>"><br>
category:<input name="category" value="<jsp:getProperty property="category_id" name="news"/>"><br>
content:<br>
<textarea rows="15" cols="80" name="content"><jsp:getProperty property="content" name="news"/>"</textarea>
<br>
<input type="submit">
</p>
</form>
</body>
</html>