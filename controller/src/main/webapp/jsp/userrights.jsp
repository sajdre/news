<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>User rights</title>
</head>
<body>
<table>
       <td>
           <tr>Email: <c:out value="${user.id}, "></c:out></tr>

           <tr>firstname: <c:out value="${user.name}, "></c:out></tr>

           <tr>secondname: <c:out value="${user.secondname}."></c:out></tr>
       </td>
</table>
       <form action="/admin/" method="get">
       <c:forEach var="userrole" items="${userroles}">
        <input type="hidden" name="operation" value="changerights">
        <input type="hidden" name="userid" value="<c:out value="${user.id}"></c:out>">
              <input type="checkbox" name="roleid" value="<c:out value="${userrole.id}"></c:out>" checked><c:out value="${userrole}"></c:out>

       </c:forEach>
           <c:forEach var="role" items="${allroles}">

               <input type="checkbox" name="roleid" value="<c:out value="${role.id}"></c:out>"><c:out value="${role}"></c:out>

           </c:forEach>
           <input type="submit" value="Accept">
       </form>

<img src="<c:url value="/images/tomcat.png"/>" alt="">
</body>
</html>