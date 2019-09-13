<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form Page</h1>
	<form action="UserControllerServlet" method="GET">
	<input type="hidden" name="command" value="LOGIN" />
		<div>Username: <input type="text" name="username_login" /></div>
		<div>Password: <input type="password" name="password_login" /></div>
		<input type="submit" value="LOGIN" />
		<small>${ ERROR_MSG }</small>
	</form>
	
</body>
</html>