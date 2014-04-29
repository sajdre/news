<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="category" class="com.pvt.daoEntities.Category" scope="request"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/admin/" method="post">
<p>
<input type="hidden" name="operation" value="editwritecategory">
<input type="hidden" name="id" value="<jsp:getProperty property="id" name="category"/>">
category:<input name="category" value="<jsp:getProperty property="category" name="category"/>"><br>
<input type="submit">
</p>
</form>
</body>
</html>