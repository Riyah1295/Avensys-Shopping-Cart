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
<h1>Product Catalogue</h1>

<c:forEach var="product" items="${ PRODUCT_LIST }">
	<p>${ product.product_id }</p>
	<p>${ product.product_name }</p>
	<p>${ product.product_description }</p>
	<p>${ product.product_price }</p>
</c:forEach>
</body>
</html>