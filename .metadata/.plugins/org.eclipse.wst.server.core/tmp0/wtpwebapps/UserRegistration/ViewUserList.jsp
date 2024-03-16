<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h2>User Management</h2>

    <!-- Display existing users -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <a href="ViewUserServlet?id=${user.id}">View</a> |
                    <a href="EditUserServlet?id=${user.id}">Edit</a> |
                    <a href="DeleteUserServlet?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p><a href="AddUser.jsp">Add User</a></p>
</body>
</html>