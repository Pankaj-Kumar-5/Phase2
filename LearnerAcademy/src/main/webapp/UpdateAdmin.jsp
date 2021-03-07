<%--
  Created by IntelliJ IDEA.
  User: pankaj.kumar1
  Date: 3/6/2021
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Admin</title>
</head>
<body>
<div align="center" style="border: solid 4px black;">
    <h1>Update Admin</h1>
    <form method="post" action="adminUpdate">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="adminName"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="adminEmail"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="adminPassword"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="adminPhone"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="adminCity"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Update</button>
                </td>
            </tr>
        </table>


        <c:if test="${not empty msg}">
            <c:out value="${msg}"/>
        </c:if>

    </form>
</div>
</body>
</html>
