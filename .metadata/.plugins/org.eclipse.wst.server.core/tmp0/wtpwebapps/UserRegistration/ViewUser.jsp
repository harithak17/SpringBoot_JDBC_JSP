<%@page import="org.servlets.Dao.UserDao"%>
<%@page import="org.servlets.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>View User</h2>   

    <%-- Display user details --%>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Date of Birth</th>
            <th>Subscribed</th>
            <th>Gender</th>
            <th>Country</th>
        </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.dob}</td>
            <td>${user.subscribed}</td>
            <td>${user.gender}</td>
            <td>${user.country}</td>
        </tr>
    </table>

    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>