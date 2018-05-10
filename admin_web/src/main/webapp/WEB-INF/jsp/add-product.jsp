<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Add product</title>
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
		<form:form modelAttribute="product">
			<h1 align="center" style="font-family: arial">Product Form</h1>
			<table style="position: center;">
				<!-- 				<tr> -->
				<!-- 					<td>Product Id</td> -->
				<%-- 					<td><form:input path="productId" placeholder="1" --%>
				<%-- 							cssClass="text_input" /></td> --%>
				<!-- 				</tr> -->
				<!-- 				<tr> -->
				<!-- 					<td>Barcode :</td> -->
				<%-- 					<td colspan="1"><form:input path="barcode" --%>
				<%-- 							placeholder="Barcode" cssClass="password_input" /></td> --%>
				<!-- 				</tr> -->
				<tr>
					<td>Store :</td>
					<td><form:input path="store" placeholder="only interger"
							cssClass="text_input" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><form:input path="description"
							placeholder="description" cssClass="text_input" /></td>
				</tr>
				<tr>
					<td>Notes :</td>
					<td><form:input path="notes" placeholder="notes"
							cssClass="text_input" /></td>
				</tr>
				<tr>
					<td>Price :</td>
					<td><form:input path="price" placeholder="0.0"
							cssClass="text_input" /></td>
					<td class="errors" id="price_error"><form:errors path="price" /></td>
				</tr>
				<tr>
					<td colspan="3"><hr /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="ADD" class="button" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>