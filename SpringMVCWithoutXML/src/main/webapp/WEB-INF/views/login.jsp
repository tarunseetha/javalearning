<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Welcome to login page</h2>
	<frm:form action="validate" method="post" modelAttribute="frmUser">
		<table border=1 style="background-color: yellow;" >
			<tr>
				<td>Username:</td>
				<td><frm:input path="userName" /></td>
				<td><frm:errors path="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><frm:password path="userPassword" /></td>
				<td><frm:errors path="userPassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</frm:form>

</body>
</html>