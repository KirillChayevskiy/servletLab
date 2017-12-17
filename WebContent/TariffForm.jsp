<%--
  Created by IntelliJ IDEA.
  User: kirillchayevskiy
  Date: 16.12.2017
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tariff</title>
</head>
<body>
<center>
    <h1>Tariff Management</h1>
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
    <c:if test="${tariff != null}">
    <form action="updateTariff" method="post">
        </c:if>
        <c:if test="${tariff == null}">
        <form action="insertTariff" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${tariff != null}">
                            Edit Tariff
                        </c:if>
                        <c:if test="${tariff == null}">
                            Add New Tariff
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${tariff != null}">
                    <input type="hidden" name="id" value="<c:out value='${tariff.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${tariff.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

