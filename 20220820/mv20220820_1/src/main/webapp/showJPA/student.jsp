<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student JPA</title>
</head>
<body>
	<ul>
		<c:forEach var="st" items="${students }">
			<li>
				<c:out value="Student ID : ${st.id }" />
				<c:out value="Student Name : ${st.stuName }" />
				<c:out value="Student Age : ${st.age }" />
			</li>
		</c:forEach>
		
	</ul>
</body>
</html>