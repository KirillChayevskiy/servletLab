<%--
  Created by IntelliJ IDEA.
  User: kirillchayevskiy
  Date: 16.12.2017
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tariffs </title>
</head>
<body>
<center>
    <h1>Tariffs Management</h1>
    <h2>
        <a href="newUser">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>
        &nbsp;&nbsp;&nbsp;
        <a href="newTariff">Add New Tariffs</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listTariff">List All Tariffs</a>
        &nbsp;&nbsp;&nbsp;
        <a href="newRelation">Add New Relation</a>
        &nbsp;&nbsp;&nbsp;
        <a href="listRelation">List All Relation</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Tariffs</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="tariff" items="${listTariff}">
            <tr>
                <td><c:out value="${tariff.id}" /></td>
                <td><c:out value="${tariff.name}" /></td>
                <td>
                    <a href="editTariff?id=<c:out value='${tariff.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deleteTariff?id=<c:out value='${tariff.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

