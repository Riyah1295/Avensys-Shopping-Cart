package com.shoppingcart.dataUtil;

import java.sql.*;
import java.util.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.shoppingcart.entity.Cart;
import com.shoppingcart.entity.CartProduct;
import com.shoppingcart.entity.Product;

public class ShoppingCartUtil {

	@Resource(name = "jdbc/Shopping")
	private DataSource dataSource;

	
	
	public ShoppingCartUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<CartProduct> getCartItems(String username) throws Exception {

			List<CartProduct> cartProduct = new ArrayList<>();
			CartProduct tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM shopping.cart WHERE Username=?";
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1, username);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int cartId= rs.getInt("Cart_Id");
					String user = rs.getString("Username");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					int quantity = rs.getInt("Quantity");
					double Total_Quantity_Price = rs.getDouble("Total_Quantity_Price");
					// Create new product object
					tempProduct = new CartProduct(cartId, user, product_name, product_desc, product_price, quantity, Total_Quantity_Price);
					cartProduct.add(tempProduct);
				}
				
				return cartProduct;
				}
				finally
				{
				close(con,pstmt,rs);
				}
	}

	/*public CartProduct getCartProductItem(String username, int productId) throws Exception {

		Cart cart = null;
		Product product = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String query;
		try {
			// Connect to DB
			con = dataSource.getConnection();

			// Create SQL statement to get Cart
			query = "SELECT * FROM shopping.cart WHERE username=? AND Product_Id=?";

			// Create prepared statement
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setInt(2, productId);

			// Execute query
			rst = pstmt.executeQuery();

			// Return cart
			if (rst.next()) {
				int quantity = rst.getInt("Quantity");
				cart = new Cart(username, productId, quantity);
			}

			// Create SQL statement to get Product
			query = "SELECT * FROM shopping.product WHERE Product_Id=?";

			// Create prepared statement
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, productId);

			// Execute query
			rst = pstmt.executeQuery();

			// Return product
			if (rst.next()) {
				String product_name = rst.getString("Product_Name");
				String product_desc = rst.getString("Product_Desc");
				double product_price = rst.getDouble("Product_Price");
				// Create new product object
				product = new Product(productId, product_name, product_desc, product_price);
			}
			// Return CartProduct
			return new CartProduct(cart, product);

		} finally {
			// Close JDBC
			close(con, pstmt, rst);
		}
	}
	*/
	public void updateShoppingCartItem(Cart cartItem) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String query;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			query = "UPDATE shopping.cart SET Quantity = ? WHERE Username = ? AND Product_Id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cartItem.getQuantity());
			pstmt.setString(2, cartItem.getUsername());
			pstmt.setInt(3, cartItem.getProductId());
			pstmt.executeQuery();

		} finally {
			// Close JDBC connection
			close(con, pstmt, rst);
		}
	}

	public void deleteShoppingCartItem(String username, int productId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String query;
		try {
			// Connect to DB
			con = dataSource.getConnection();
			// Create query and execute query
			query = "DELETE FROM shopping.cart WHERE Username = ? AND Product_Id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setInt(2, productId);
			pstmt.executeQuery();

		} finally {
			// Close JDBC connection
			close(con, pstmt, rst);
		}
	}

	public void addCartDetails(String username, String product_name, String product_desc, Double product_price, int quantity, Double total_quantity_price) throws Exception {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
			//create a connection
			con = dataSource.getConnection();
			//create sql query 
			String qry = "INSERT INTO shopping.cart(Username, Product_Name, Product_Desc, Product_Price, Quantity, Total_Quantity_Price) VALUES(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			//set the parameters for the students
			pstmt.setString(1, username);
			pstmt.setString(2, product_name);
			pstmt.setString(3, product_desc);
			pstmt.setDouble(4, product_price);
			pstmt.setInt(5, quantity);
			pstmt.setDouble(6, total_quantity_price);
			
			//execute the sql query
			pstmt.execute();
			}
			finally
			{
			close(con,pstmt,null);
			}
		}
    
    	private void close(Connection con, Statement stmt, ResultSet rst) {
		try {
			if (rst != null) {
				rst.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

    	
		public List<Product> getJacketItems() throws SQLException {
			
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_jacket";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Jacket_id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
			
	    
		}

		public List<Product> getPantsItems() throws Exception {
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_pants";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Pants_id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<Product> getShirtItems() throws Exception {
			
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_shirt";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Shirt_id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<Product> getShortItems() throws Exception {
			
			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_shorts";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Shorts_Id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		public List<Product> getShoeItems() throws SQLException {

			List<Product> product = new ArrayList<>();
			Product tempProduct = null;
			Connection con = null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			try {
				//create a connection
				con = dataSource.getConnection();
				//create sql query 
				String qry = "SELECT * FROM product_shoe";
				pstmt = con.prepareStatement(qry);
				//execute the sql query
				rs= pstmt.executeQuery();
				
				while (rs.next())
				{
					int product_id = rs.getInt("Shoe_Id");
					String product_name = rs.getString("Product_Name");
					String product_desc = rs.getString("Product_Desc");
					double product_price = rs.getDouble("Product_Price");
					// Create new product object
					tempProduct = new Product(product_id, product_name, product_desc, product_price);
					product.add(tempProduct);
				}
				
				return product;
				}
				finally
				{
				close(con,pstmt,rs);
				}
		}

		

}