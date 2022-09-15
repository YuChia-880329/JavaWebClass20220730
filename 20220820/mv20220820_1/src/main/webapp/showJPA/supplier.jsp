<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Supplier</title>
</head>
<body>

	<table border="1" width="75%">
		<c:forEach var="sup" items="${sups }">
			<tr>
				<td>
					<c:out value="Supplier ID : ${sup.id }" />
				</td>
				<td>
					<c:out value="Supplier Name : ${sup.name }"></c:out>
				</td>
				<td>
					<c:out value="Street : ${sup.street }" />
				</td>
				<td>
					<c:out value="City : ${sup.city }" />
				</td>
				<td>
					<c:out value="State : ${sup.state }" />
				</td>
				<td>
					<c:out value="Zip : ${sup.zip }" />
				</td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>