<%--
  Created by IntelliJ IDEA.
  User: pankaj.kumar1
  Date: 3/6/2021
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Login</title>
</head>
<body>

<div align="center" style="border: solid 4px black;">
<h1>Administration login</h1>
<form action="adminLogin" method="post" cellpadding="5" cellspacing="5">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><a href="AdminRegistration.jsp">Register</a>&nbsp&nbsp&nbsp<a href="UpdateAdmin.jsp">Update</a></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Login</button>
            </td>
        </tr>
    </table>
    <br>
    <c:if test="${not empty errorMessage}">
        <c:out value="${errorMessage}"/>
    </c:if>


</form>
</div>
</body>
</html>
