<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Coffee</title>
</head>
<body>
	<table border="1" width="75%">
		<c:forEach var="cof" items="${coffees }">
			<tr>
				<td>
					<c:out value="Coffee Name : ${cof.cofName }"></c:out>
				</td>
				<td>
					<c:out value="Sup ID : ${cof.supId }"></c:out>
				</td>
				<td>
					<c:out value="Price : ${cof.price }"></c:out>
				</td>
				<td>
					<c:out value="Sales : ${cof.sales }"></c:out>
				</td>
				<td>
					<c:out value="Total : ${cof.total }"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>