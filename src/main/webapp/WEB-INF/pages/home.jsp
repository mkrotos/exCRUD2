<%--
  Created by IntelliJ IDEA.
  User: makro
  Date: 18.09.2018
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Base Screen</title>
</head>

<body>
<div align="center">
    <h1>Employee List</h1>
    <h3>
        <a href="<c:url value="/newEmployee"/>">New Employee</a>
    </h3>
    <table border="1">

        <th width="120">Name</th>
        <th width="150">Email</th>
        <th width="150">Address</th>
        <th width="100">Phone</th>
        <th width="75">Action</th>

        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>${employee.telephone}</td>

                <td><a href="<c:url value="/editEmployee?id=${employee.id}"/>">Edit</a>
                    <a href="<c:url value="/deleteEmployee?id=${employee.id}"/>">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
