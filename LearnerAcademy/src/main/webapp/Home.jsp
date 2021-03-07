<%--
  Created by IntelliJ IDEA.
  User: pankaj.kumar1
  Date: 3/7/2021
  Time: 12:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>


<div align="center" style="border: solid 4px black">
    <u><h1>Welcome <%= session.getAttribute("name")%></h1></u>
    <br><br>
    <table>
        <tr>
            <td><h3>Admin menu</h3><br></td>
        </tr>
        <tr>
            <td><a href="addStudent">Add new student</a></td>
        </tr>
        <tr>
            <td><a href="showStudent">View Student</a></td>
        </tr>
        <tr>
            <td><a href="classReport">View Class report</a></td>
        </tr>
        <tr>
            <td><a href="logout">Logout</a></td>
        </tr>
    </table>
</div>
</body>
</html>
