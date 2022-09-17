<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>javaguides.net</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
	<script src="<c:url value="/resources/js/jquery3.6.0.min.js" />" ></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
</head>
<body>
 	<div class="container">
  		<div class="col-md-offset-2 col-md-7">
   			<h1>${message}</h1><hr />

   			<table class="table table-striped table-bordered">
    			<tr>
     				<td><b>First Name </b>: ${user.firstName}</td>
    			</tr>
    			<tr>
     				<td><b>Last Name </b> : ${user.lastName}</td>
    			</tr>
    			<tr>
     				<td><b>UserName </b> : ${user.userName}</td>
    			</tr>
    			<tr>
     				<td><b>Email </b>: ${user.email}</td>
    			</tr>
   			</table>
  		</div>
 	</div>
</body>
</html>
