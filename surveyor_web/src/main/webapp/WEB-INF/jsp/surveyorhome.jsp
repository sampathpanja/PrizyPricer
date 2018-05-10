<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Surveyor Home</title>
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
	<div align="center">
		<h3>Surveyor Home</h3>
		<br>
		<h3>
			<a href="${pageContext.request.contextPath}/product-list.htm">Product
				list</a>
		</h3>
	</div>
</body>
</html>