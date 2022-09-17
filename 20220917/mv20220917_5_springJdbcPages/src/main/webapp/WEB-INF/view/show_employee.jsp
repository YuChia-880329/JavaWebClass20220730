<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Employees</title>
</head>
<body>
	<table border="1" width="90%" cellpadding="2">
		<tr>
			<th>employeeNumber</th>
			<th>firstName</th>
			<th>extension</th>
			<th>email</th>
			<th>jobTitle</th>
		</tr>
		
		<c:forEach var="employee" items="${employees }">
			<tr>
				<td>${employee.employeeNumber }</td>
				<td>${employee.firstName }</td>
				<td>${employee.email }</td>
				<td>${employee.extension }</td>
				<td>${employee.jobTitle }</td>
			</tr>
		</c:forEach>
		
		
	</table>
	
	
	<a href="/mv20220917_5_springJdbcPages/employees/1">1</a>
	<a href="/mv20220917_5_springJdbcPages/employees/2">2</a>
	<a href="/mv20220917_5_springJdbcPages/employees/3">3</a>
</body>
</html>