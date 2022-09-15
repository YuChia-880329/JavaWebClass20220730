<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>
<body>
	<ul>
		<c:forEach var="student" items="${students }">
			<li>
				Student ID : <c:out value="${student.id }" />
				Age : <c:out value="${student.age }" />
				Name : <c:out value="${student.stuName }" />
			</li>
		</c:forEach>
	</ul>
</body>
</html>