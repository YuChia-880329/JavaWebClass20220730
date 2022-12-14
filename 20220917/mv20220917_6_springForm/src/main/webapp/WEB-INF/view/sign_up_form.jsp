<%@ page language="java" contentType="text/html; charset=utf-8"
 	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Spring MVC 5 - form handling | Java Guides</title>
	<script src="<c:url value="/resources/js/jquery3.6.0.min.js" />"></script>
	
	
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
	
  		<div class="col-md-offset-2 col-md-7">
  		
   			<h2 class="text-center">Spring MVC 5 Form Handling Example - Sign up Form</h2>
   			<div class="panel panel-info">
   			
    			<div class="panel-heading">
     				<div class="panel-title">Sign Up</div>
    			</div>
    			
    			<div class="panel-body">
    			
     				<form:form action="saveSignUpForm" cssClass="form-horizontal" method="post" modelAttribute="signUpForm">

      					<div class="form-group">
       						<label for="firstname" class="col-md-3 control-label">First Name</label>
       						<div class="col-md-9">
        						<form:input path="firstName" cssClass="form-control" />
       						</div>
     				 	</div>
     				 	
      					<div class="form-group">
       						<label for="lastname" class="col-md-3 control-label">Last Name</label>
       						<div class="col-md-9">
        					<form:input path="lastName" cssClass="form-control" />
       						</div>
      					</div>

      					<div class="form-group">
       						<label for="icode" class="col-md-3 control-label">User Name </label>
       						<div class="col-md-9">
        						<form:input path="userName" cssClass="form-control" />
       						</div>
      					</div>

      					<div class="form-group">
       						<label for="password" class="col-md-3 control-label">Password</label>
       						<div class="col-md-9">
        						<form:password path="password" cssClass="form-control" />
       						</div>
      					</div>
      					
      					<div class="form-group">
       						<label for="email" class="col-md-3 control-label">Email</label>
       						<div class="col-md-9">
        						<form:input path="email" cssClass="form-control" />
       						</div>
      					</div>

      					<div class="form-group">
       						<!-- Button -->
       						<div class="col-md-offset-3 col-md-9">
        						<form:button cssClass="btn btn-primary">Submit</form:button>
       						</div>
      					</div>

     				</form:form>
    			</div>
   			</div>
  		</div>
 	</div>
</body>
</html>
