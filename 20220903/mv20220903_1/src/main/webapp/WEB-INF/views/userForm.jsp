<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
	<table>
		<form:form action="addUser" method="POST">
			<tr>
				<td>
					<form:label path="name">名字 : </form:label>
					<form:input path="name"/>
				<td>
			</tr>
			<tr>
				<td>
					<form:label path="password">密碼 : </form:label>
					<form:password path="password"/>
				<td>
			</tr>
			<tr>
				<td>
					<form:label path="address">地址 : </form:label>
					<form:textarea path="address"/>
				<td>
			</tr>
			<tr>
				<td>
					<form:label path="receivePaper">訂閱 : </form:label>
					<form:checkbox path="receivePaper"/>
				<td>
			</tr>
			<tr>
				<td>
					<form:label path="favoriteFrameworks">框架 : </form:label>
					<form:checkboxes items="${webFrameWorkList }" path="favoriteFrameworks"/>
				<td>
			</tr>
			<tr>
				<td colspan="2">
					<button>submit</button>
				</td>
			</tr>
		</form:form>
	</table>
</body>
</html>