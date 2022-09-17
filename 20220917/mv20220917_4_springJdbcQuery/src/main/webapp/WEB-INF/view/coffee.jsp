<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Coffees</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>COF_NAME</th>
			<th>SUP_ID</th>
			<th>PRICE</th>
			<th>SALES</th>
			<th>TOTAL</th>
		</tr>
		<c:forEach var="coffee" items="${coffees }">
			<tr>
				<td>${coffee.cofName }</td>
				<td>${coffee.supId }</td>
				<td>${coffee.price }</td>
				<td>${coffee.sales }</td>
				<td>${coffee.total }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>