<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="bean.LoginBean">
		<jsp:setProperty name="person" property="*" />
	</jsp:useBean>
	
	<h2>
		User:<jsp:getProperty name="person" property="user" /></br>
		Password:<jsp:getProperty name="person" property="password" /></br>
		Phone:<jsp:getProperty name="person" property="phone" /></br>
	</h2>
</body>
</html>