<%--
  Created by IntelliJ IDEA.
  Relation: kirillchayevskiy
  Date: 16.12.2017
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Relations </title>
</head>
<body>
<center>
    <h1>Relations Management</h1>
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
        <caption><h2>List of Relations</h2></caption>
        <tr>
            <th>ID</th>
            <th>UserID</th>
            <th>TariffID</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="relation" items="${listRelation}">
            <tr>
                <td><c:out value="${relation.id}" /></td>
                <td><c:out value="${relation.userID}" /></td>
                <td><c:out value="${relation.tariffID}" /></td>
                <td>
                    <a href="editRelation?id=<c:out value='${relation.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="deleteRelation?id=<c:out value='${relation.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

