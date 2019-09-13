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
<p><a href="">My Cart</a></p>
<table border="1">
	<tr>
		<th>Product Name</th>
		<th>Product Description</th>
		<th>Product Price</th>
		<th></th>
	</tr>
	<c:forEach var="product" items="${ PRODUCT_LIST }">
		<tr>
			<td>${ product.product_name }</td>
			<td>${ product.product_description }</td>
			<td>${ product.product_price }</td>
			<c:url var="tempLink" value="CartControllerServlet">
				<c:param name="command" value="ADD" />
				<c:param name="productId" value="${ product.product_id }" />
			</c:url>
			<td><a href="${ tempLink }">Add to Cart</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>