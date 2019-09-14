package com.shoppingcart.dataUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.shoppingcart.entity.Product;

public class ProductDataUtil {

	@Resource(name="jdbc/shopping")
	private DataSource dataSource;

	public ProductDataUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	private void close(Connection con, Statement stmt, ResultSet rst)  {
		try {
			if(rst!= null) {
				rst.close();
			}
			if(stmt!= null) {
				stmt.close();
			}
			if(con!= null) {
				con.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProducts() throws SQLException {
		List<Product> products = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rst = null;
		
		try {
			con = dataSource.getConnection();
			
			String qry="select * from shopping.product";
			
			stmt=con.prepareStatement(qry);
			
			rst=stmt.executeQuery(qry);
			
			while(rst.next()) {
				int product_Id= rst.getInt("Product_Id");
				String product_Name= rst.getString("Product_Name");
				String product_Desc= rst.getString("Product_Desc");
				double product_Price= rst.getInt("Product_Price");
				
				
				Product tempProduct = new Product(product_Id, product_Name, product_Desc, product_Price);
				
				products.add(tempProduct);
			}
			return products;
		}
		finally {
			close(con,stmt,rst);
		}
	}

	public Product getProduct(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(int pId) {
		// TODO Auto-generated method stub
		
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	
	
}