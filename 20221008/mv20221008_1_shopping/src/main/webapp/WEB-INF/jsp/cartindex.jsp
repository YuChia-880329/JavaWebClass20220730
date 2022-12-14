<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
</head>
<body>
	<h3>Cart Page</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		
		<c:set var="total" value="0" />
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total" value="${total + item.product.price * item.quantity }" />
			<tr>
				<td>
					<a href="${pageContext.request.contextPath }/cart/remove/${item.product.id }" onclick="return confirm('確定要刪除${item.product.name}?')">Remove</a>
				</td>
				<td>${item.product.id }</td>
				<td>${item.product.name }</td>
				<td>
					<img src="${pageContext.request.contextPath }/${item.product.photo}" width="150">
				</td>
				<td>${item.product.price }</td>
				<td>${item.quantity }</td>
				<td>${item.product.price * item.quantity }</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td align="right" colspan="6">Sum</td>
			<td>${total }</td>
		</tr>
	</table>
	
	<br/>
	<a href="${pageContext.request.contextPath }/productcart">Continue Shopping</a>
</body>
</html>