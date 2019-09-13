<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Avensys ShopLah!</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body {font-family: "Times New Roman", Georgia, Serif;}
h1, h2, h3, h4, h5, h6 {
  font-family: "Playfair Display";
  letter-spacing: 5px;
}
</style>

</head>
<body>

<!-- Navbar (sit on top) -->
<div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="index.html" class="w3-bar-item w3-button">Avensys ShopLah!</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
        <a href="#jacket" class="w3-bar-item w3-button">Jacket</a>
     <a href="#pants" class="w3-bar-item w3-button">Pants</a>
        <a href="#shirt" class="w3-bar-item w3-button">Shirt</a>
    <a href="#short" class="w3-bar-item w3-button">Short</a>
	 <a href="#shoe" class="w3-bar-item w3-button">Shoe</a>
	       
      
    </div>
  </div>
</div>


<!-- Page content -->

  
<hr>


  <!-- Product Section -->
  <div class="w3-container w3-padding-64" id="contact">
          <center>
      <h1>Our Products</h1><br>
             
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
          </center>

      
      
    
  </div>
  

<!-- End page content --> 
    
    
    

<!-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-32">
<p>Avensys ShopLah! Copyright 2019</p>
</footer>

</body>
</html>
