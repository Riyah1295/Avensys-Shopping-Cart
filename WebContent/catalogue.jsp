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
    		<c:url var="Jacket" value="CartControllerServlet">
				<c:param name="command" value="JACKET" />
				<c:param name="username" value="${ username }"/>
			</c:url>
			 <a href="${ Jacket }" class="w3-bar-item w3-button">Jackets</a>
			
        
      	  <c:url var="Pants" value="CartControllerServlet">
				<c:param name="command" value="PANTS" />
				<c:param name="username" value="${ username }"/>
			</c:url>
        <a href="${ Pants }" class="w3-bar-item w3-button">Pants</a>
        
        <c:url var="Shirt" value="CartControllerServlet">
				<c:param name="command" value="SHIRT" />
				<c:param name="username" value="${ username }"/>
			</c:url>
        <a href="${ Shirt }" class="w3-bar-item w3-button">Shirt</a>
        
        <c:url var="Short" value="CartControllerServlet">
				<c:param name="command" value="SHORT" />
				<c:param name="username" value="${ username }"/>
			</c:url>
        <a href="${ Short }" class="w3-bar-item w3-button">Short</a>
        
        <c:url var="Shoe" value="CartControllerServlet">
				<c:param name="command" value="SHOE" />
				<c:param name="username" value="${ username }"/>
			</c:url>
        <a href="${ Shoe }" class="w3-bar-item w3-button">Shoe</a>
	       
      
    </div>
  </div>
</div>


<!-- Page content -->

  
<hr>

	<!-- Product Section -->
		<div class="w3-container w3-padding-64" id="contact">
			
			<h1>Our Products</h1>
			<br>
				
				<c:forEach var="product" items="${ PRODUCT_LIST }">
				
							<form action="CartControllerServlet">
								<input name="productName" value="${ product.product_name }" readonly>
								<input name="productDesc" value="${ product.product_description }" readonly>
								<input name="productPrice" value="${ product.product_price }" readonly>
								<input type="hidden" name="username" value="${ username }">
								<input type="hidden" name="quantity" value="3" />
								<input type="hidden" name="command" value="ADD" />
								<input type="submit" value="add to cart"/>
							</form>
							
						<br>
					
					</c:forEach>
				
					
				
				
			
		</div>
		


		
			

	

 

      
      
    
  </div>
  

<!-- End page content --> 
    
    
    

<!-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-32">
<p>Avensys ShopLah! Copyright 2019</p>
</footer>

</body>
</html>