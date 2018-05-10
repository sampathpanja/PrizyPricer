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
				<td><a href="${pageContext.request.contextPath}/surveyorlogout">logout</a></td>
			</tr>
		</table>
	</div>

	<br>

	<div class="reg-font" align="center">
		<h2>
			<b>Surveyor Home</b>
		</h2>
		<h3 align="center">Products</h3>
		<br>
		<form:form modelAttribute="productBo" enctype="multipart/form-data">
			<table align="center" cellpadding="5px" cellspacing="2px">
				<c:if test="${empty products}">
					<tr>
						<td colspan="6"><p style="color: red" align="center">Requested
								Products are not available</p></td>
					</tr>
				</c:if>

				<c:if test="${not empty products}">
					<tr>
						<th>Product Id</th>
						<th>barcode</th>
						<th>store</th>
						<th>description</th>
						<th>notes</th>
						<th>price</th>
					</tr>
					<c:set var="products" value="${products}" />
					<c:forEach items="${products}" var="product">
						<tr align="center">
							<td>${product.productId}</td>
							<td><a
								href="${pageContext.request.contextPath}/update-product.htm?barcode=${product.barcode}">${product.barcode}</a></td>
							<td>${product.storeId}</td>
							<td>${product.description}</td>
							<td>${product.notes}</td>
							<td>${product.allPrices}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</form:form>
	</div>
</body>
</html>