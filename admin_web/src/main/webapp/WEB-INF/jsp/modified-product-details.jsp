<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product list</title>
</head>
<body bgcolor="lightyellow">
	<div align="right">
		<table>
			<tr>
				<td>hi, ${pageContext.request.userPrincipal.name}</td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath}/adminlogout">logout</a></td>
			</tr>
		</table>
	</div>

	<br>

	<div class="reg-font" align="center">
		<h2>Product modified successfully</h2>
		<br>
		<table cellpadding="10px">
			<tr>
				<td>Product Id :</td>
				<td>${product.productId}</td>
			</tr>
			<tr>
				<td>Barcode :</td>
				<td>${product.barcode}</td>
			</tr>
			<tr>
				<td>Store Id :</td>
				<td>${product.store}</td>
			</tr>
			<tr>
				<td>Description :</td>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>Notes :</td>
				<td>${product.notes}</td>
			</tr>
			<tr>
				<td>Ideal price :</td>
				<td>${product.price}</td>
			</tr>
		</table>

		<br> <br> <br> <a
			href="${pageContext.request.contextPath}/product-list.htm">Product
			list</a>
	</div>
</body>
</html>