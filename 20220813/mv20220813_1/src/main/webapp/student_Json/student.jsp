<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Student Json</title>
	
	<script type="text/javascript">
		var students = [];
		function sendStuJson(){

			let jsonStr = JSON.stringify(students);
			let hidden = document.getElementById("stuData");
			hidden.value = jsonStr;
			alert(hidden.value);
			return true;
			
		}
		
		function add(){
			let userName = document.getElementById("user_name").value;
			let userAge = parseInt(document.getElementById("user_age").value);
			
			let student = {};
			student.name = userName;
			student.age = userAge;
			
			students.push(student);
			let jsonStr = JSON.stringify(students);
			alert(jsonStr);
		}
		
		
	</script>
</head>
<body>
	Student Name:<input type="text" id="user_name" value="Alan"><br>
	Student Age:<input type="text" id="user_age" value="20"><br>
	<button onclick="add()">add</button>
	<form action="../json" onsubmit="return sendStuJson();">
		<input type="hidden" id="stuData" name="stuData">
		<button>Send</button>
	</form>
</body>
</html>