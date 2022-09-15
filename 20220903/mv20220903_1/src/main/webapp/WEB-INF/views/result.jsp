<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Data</title>
</head>
<body>
	<h2>提交的學生資料是-</h2>
	<table>
		<tr>
			<td>名字 : </td>
			<td>${student.name }</td>
		</tr>
		<tr>
			<td>年齡 : </td>
			<td>${student.age }</td>
		</tr>
		<tr>
			<td>編號 : </td>
			<td>${student.id }</td>
		</tr>
	</table>
</body>
</html>