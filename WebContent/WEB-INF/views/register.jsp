<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Exam</title>
</head>
<body>
	<h1>Register Page</h1>
	<div align="center">
		<form:form action="saveUser" method="post" modelAttribute="user">
			<table>
				<form:hidden path="id" />

				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Save User"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>