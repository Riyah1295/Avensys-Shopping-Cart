<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Main Page header</h1>
	
	<p><a href="login_form.jsp">Go to Login Form page</a></p>
	<form action="ProductControllerServlet">
		<input type="hidden" name="command" value="LIST"/>
		<input type="submit" value="View Catalogue" />
	</form>
</body>
</html>