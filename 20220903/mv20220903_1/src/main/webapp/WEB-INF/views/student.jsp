<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
	<form:form method="post" action="addStudent" >
		<table>
			<tr>
				<td><form:label path="name">名字:</form:label> </td>
				<td><form:input path="name"/> </td>
			</tr>
			<tr>
				<td><form:label path="age">年齡:</form:label> </td>
				<td><form:input path="age"/> </td>
			</tr>
			<tr>
				<td><form:label path="id">編號:</form:label> </td>
				<td><form:input path="id"/> </td>
			</tr>
			<tr>
				<td colspan="2">
					<button>提交表單</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>