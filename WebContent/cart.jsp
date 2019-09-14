<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>

<title>Shopping Cart</title>
 <link type="text/css" rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
		<title>Shopping Cart</title>
		<style>
				body {font-family: "Times New Roman", Georgia, Serif;}
				h1, h2, h3, h4, h5, h6 {
				  font-family: "Playfair Display";
				  letter-spacing: 5px;
				}
		</style>
</head>
<body>
 <div class="w3-top">
  <div class="w3-bar w3-white w3-padding w3-card" style="letter-spacing:4px;">
    <a href="#home" class="w3-bar-item w3-button">Singapore Shopping Spree</a>
    <!-- Right-sided navbar links. Hide them on small screens -->
    <div class="w3-right w3-hide-small">
      <a href="#about" class="w3-bar-item w3-button">About</a>
      <a href="#menu" class="w3-bar-item w3-button">Menu</a>
      <a href="#contact" class="w3-bar-item w3-button">Contact</a>
    </div>
  </div>
</div>
        
     
<!-- Page content -->
<div class="w3-content" style="max-width:1100px">

  <!-- About Section -->

    <div class="w3-col m6 w3-padding-large">
        <br>
      <h1 class="w3-center">Review your purchase</h1><br>
      <table border="1" style="text-align:center">
        <tr>
       		<th>Cart_Id</th>
       		<th>User</th>
            <th>Product_Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total_Price_Of_Item</th>
            
            
        </tr>  
        <c:forEach var="cartItems" items="${CART_LIST}">
      	  <tr>
        
        
        		<td>${ cartItems.cartId }</td>
                <td>${ cartItems.user } </td>
               	<td>${ cartItems.product_name }</td>
               	<td>${ cartItems.product_desc }</td>
               	<td>${ cartItems.product_price }</td>
               	<td>${ cartItems.quantity }</td>
               	<td>${ cartItems.total_Quantity_Price }</td>
          		<td><input type="submit" value="Edit Quantity"/></td>
           		<td><input type="submit" value="Remove item"/></td>
           		<td><input type="submit" value="Purchase Now"/></td>
          </tr>	
        </c:forEach> 
            
            
       
          
      </table>
    </div>
    
  </div>
       
  
  <hr>
  
 

  <hr>

  <!-- Contact Section -->
  <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  
<!-- End page content -->
</div>

<!-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-32">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer>




</body>
</html>