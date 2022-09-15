<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="LoginBean.jsp" method="post">
		User:<input type="text" name="user" value="Mary"></br>
		Password:<input type="password" name=password value="123456"></br>
		Phone:<input type="text" name="phone" value="0923654785"></br>
		<input type="submit" value="Login">
	</form>
</body>
</html>