<%@page import="model.Product"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="products" scope="request" class="java.util.ArrayList" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Products</title>
	<%! Iterator<Product> itr = null; %>
	<% itr = products.iterator(); %>
</head>
<body>
	<table border="1">
		<tr>
			<th>Code</th>
			<th>Price</th>
			<th>Description</th>
			<th>Quantity</th>
		</tr>
		<%
			while(itr.hasNext()){
				Product pro = itr.next();
		%>
				<tr>
					<td><%= pro.getCode() %></td>
					<td><%= pro.getPrice() %></td>
					<td><%= pro.getDescription() %></td>
					<td><%= pro.getQuantity() %></td>
				</tr>
		<% } %>
	</table>
</body>
</html>