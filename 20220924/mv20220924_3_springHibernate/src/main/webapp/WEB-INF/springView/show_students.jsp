<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Students</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="stu" items="${ stuList }">
			<tr>
				<td>${ stu.id }</td>
				<td>${ stu.stuName }</td>
				<td>${ stu.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>