<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create DB</title>
</head>
<body>
	<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei"
	user="root" password="1234"/>
	<sql:update dataSource="${sample}" var="result">
		create table if not exists myEmployees
		(
			id int not null primary key,
			age int not null,
			firstName varchar(255),
			lastName varchar(255)
		)
	</sql:update>

	<c:out value="Finish"></c:out>
</body>
</html>