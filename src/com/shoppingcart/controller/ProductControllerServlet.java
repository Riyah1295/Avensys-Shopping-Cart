package com.shoppingcart.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shoppingcart.dataUtil.ProductDataUtil;
import com.shoppingcart.entity.Product;

/**
 * Servlet implementation class ProductControllerServlet
 */
@WebServlet("/ProductControllerServlet")
public class ProductControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// initialize product data util
	private ProductDataUtil productDataUtil;
	
	@Resource(name="jdbc/shopping")
	private DataSource dataSource;
	
	

	@Override
	public void init() throws ServletException {
		try {
			productDataUtil = new ProductDataUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String productCommand = request.getParameter("productCommand");
			
			if(productCommand == null) {
				productCommand = "LIST";
			}
			switch(productCommand) {
			case "LIST":
				listProducts(request, response);
				break;
			case "ADD":
				addProduct(request, response);
				break;
			case "UPDATE":
				updateProduct(request, response);
				break;
			case "DELETE":
				deleteProduct(request, response);
				break;
			case "VIEW":
				viewProduct(request,response);
				break;
			default:
				listProducts(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}



	private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get from db
		String id=request.getParameter("Product_Id");
		int pId = Integer.parseInt(id);
		Product product_info=productDataUtil.getProduct(pId);
		request.setAttribute("ProductInfo", product_info);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
		//forward to jsp
		dispatcher.forward(request, response);
		
	}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get from db
		List<Product> productList= productDataUtil.getProducts();
		// request set attribute
		request.setAttribute("PRODUCT_LIST", productList);
		//get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/catalogue.jsp");
		//forward to jsp
		dispatcher.forward(request, response);
	}
	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read product from form
		String product_Name=request.getParameter("product_Name");
		String product_Price=request.getParameter("product_Price");
		String product_Desc=request.getParameter("product_Desc");
		
		int price=Integer.parseInt(product_Price);
		double dprice=price;
		
		//create new product
		Product product= new Product(product_Name, product_Desc, dprice);
		// productDbUtil add product to db
		productDataUtil.addProduct(product);
		//list products
		listProducts(request, response);
	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String product_IdToDel = request.getParameter("product_id");
		int pId = Integer.parseInt(product_IdToDel);
		productDataUtil.deleteProduct(pId);
		listProducts(request,response);
		
	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String product_Id = request.getParameter("product_Id");
		String product_Price=request.getParameter("product_Price");
		String product_Name=request.getParameter("product_Name");
		String product_Desc=request.getParameter("product_Desc");
		
		int pId = Integer.parseInt(product_Id);
		int price = Integer.parseInt(product_Price);
		
		Product product = new Product(pId, product_Name, product_Desc, price);
		productDataUtil.updateProduct(product);
		
	}
}
