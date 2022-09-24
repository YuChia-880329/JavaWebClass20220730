<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Student</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" ></script>
	<script type="text/javascript">
		function addStudent(){
			let Urls = "result";
			let student = {};
			student.id = $("#id").val();
			student.stuName = $("#name").val();
			student.age = $("#age").val();

			$.post(Urls, student, function(data){
				$("#msg").html(data);
			})
		}
	</script>
</head>
<body>
	<h2>Student Form</h2>
	<spring:form>
		<table>
			<tr>
				<td>
					<spring:label path="id">ID</spring:label>
				</td>
				<td>
					<spring:input path="id" id="id"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:label path="stuName">Name</spring:label>
				</td>
				<td>
					<spring:input path="stuName" id="name"/>
				</td>
			</tr>
			<tr>
				<td>
					<spring:label path="age">Age</spring:label>
				</td>
				<td>
					<spring:input path="age" id="age"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="send" onclick="addStudent()">
				</td>
			</tr>
		</table>
	</spring:form>
	
	<div id="msg"></div>
</body>
</html>