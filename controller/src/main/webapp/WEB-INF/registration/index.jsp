<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
<table>
    <tr>
        <td>
        </td>
        <td>
            <form method="post" action="../registration/">
                <p>
                    <input type="hidden" name="operation" value="adduser">
                    email:<input name="id"><br>
                    password:<input name="password1" type="password"><br>
                    password:<input name="password2" type="password"><br>

                    <c:if test="${not empty errorMessage}">
                        <c:out value="${errorMessage}"></c:out>!<br>
                    </c:if>
                    <br>
                    firstname:<input name="firstname"><br>
                    secondname:<input name="secondname"><br>
                    <br>
                    <input type="submit">
                </p>
            </form>
            <br>
        </td>
    </tr>
</table>



</body>
</html>