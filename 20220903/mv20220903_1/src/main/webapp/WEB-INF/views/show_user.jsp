<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show User</title>
</head>
<body>
	<table>
		<tr>
			<td>名字:</td>
			<td>${user.name }</td>
		</tr>
		<tr>
			<td>密碼:</td>
			<td>${user.password }</td>
		</tr>
		<tr>
			<td>地址:</td>
			<td>${user.address }</td>
		</tr>
		<tr>
			<td>訂閱:</td>
			<td>${user.receivePaper }</td>
		</tr>
		<tr>
			<td>喜歡的框架:</td>
			<c:forEach var="framework" items="${user.favoriteFrameworks }">
				<td>${framework }</td>
			</c:forEach>
		</tr>
		
	</table>
</body>
</html>