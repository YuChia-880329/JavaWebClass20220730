<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User UI</title>
</head>
<body>
	<form action="user" method="Post">
		<input type="text" value="${defaultName }" name="name" /><br/>
		<button>submit</button>
	</form>
</body>
</html>