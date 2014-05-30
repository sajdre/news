<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Find user</title>
</head>
<body>
<form action="/admin/" method="post">
    <p>
        <input type="hidden" name="operation" value="showusersby">
        email:<input name="email"><br>
        firsrname:<input name="firstname"><br>
        secondname:<input name="secondname"><br>
        <button type="submit">Submit</button>
</form>
<table>
<c:if test="${not empty users}">
<c:forEach var="user" items="${users}">
<tr>
    <td>Email: <c:out value="${user.id}, "></c:out></td>

    <td>firstname: <c:out value="${user.name}, "></c:out></td>

    <td>secondname: <c:out value="${user.secondname}, "></c:out></td>
    <td><a href="?operation=userrights&userid=<c:out value="${user.id}"></c:out>">user rights.</a>
    </td>
</tr>
</c:forEach>
</c:if>

</table>

<img src="<c:url value="/images/tomcat.png"/>" alt="">
</body>
</html>