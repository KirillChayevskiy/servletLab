<%--
  Created by IntelliJ IDEA.
  Relation: kirillchayevskiy
  Date: 16.12.2017
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Relation</title>
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
    <c:if test="${relation != null}">
    <form action="updateRelation" method="post">
        </c:if>
        <c:if test="${relation == null}">
        <form action="insertRelation" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${relation != null}">
                            Edit Relation
                        </c:if>
                        <c:if test="${relation == null}">
                            Add New Relation
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${relation != null}">
                    <input type="hidden" name="id" value="<c:out value='${relation.id}' />" />
                </c:if>
                <tr>
                    <th>UserID: </th>
                    <td>
                        <input type="text" name="userID" size="45"
                               value="<c:out value='${relation.UserID}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>TariffID: </th>
                    <td>
                        <input type="text" name="tariffID" size="45"
                               value="<c:out value='${relation.TariffID}' />"
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

