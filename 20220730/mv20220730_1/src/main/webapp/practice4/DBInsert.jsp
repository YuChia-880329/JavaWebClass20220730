<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="uid" value="${param.uid }"></c:set>
	<c:set var="age" value="${param.age }"></c:set>
	<c:set var="FName" value="${param.FName }"></c:set>
	<c:set var="LName" value="${param.LName }"></c:set>
	
	
	<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei"
	user="root" password="1234"/>
	
	
	<sql:update dataSource="${sample }" >
		INSERT INTO myEmployees(id, age, firstName, lastName) 
		VALUES(${uid }, ${age }, '${FName }', '${LName }')
	</sql:update>
	
	
	<sql:query dataSource="${sample }" var="result">
		SELECT * FROM classicmodels.myEmployees
	</sql:query>
	
	<table border="1" width="50%">
		<tr>
			<th>EMP ID</th>
			<th>Age</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach var="row" items="${result.rows }">
			<tr>
				<td>${row.id }</td>
				<td>${row.age }</td>
				<td>${row.firstName }</td>
				<td>${row.lastName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>