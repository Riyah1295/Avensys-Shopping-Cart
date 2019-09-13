package com.shoppingcart.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shoppingcart.dataUtil.UserDataUtil;
import com.shoppingcart.entity.User;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// initialize user's data util
	private UserDataUtil userDataUtil;
	
	@Resource(name="jdbc/") // TODO: add database schema name
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		try {
			// create user db util and connect to data pool
			userDataUtil = new UserDataUtil(dataSource);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/**
			 * 1. get command value from form
			 * 2. run switch based off command value
			 * 3. run the method for the given command
			 */
			String theCommand = request.getParameter("command");
			switch(theCommand) {
			case "VIEW":
				viewUser(request,response);
				break;
			case "REGISTER":
				registerUser(request,response);
				break;
			default:
				viewUser(request, response);
				
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/**
		 * 1. Read input that is passed in
		 * 2. create new user object to save the input
		 * 3. insert new user into database
		 */
		String user_firstname = request.getParameter(""); // TODO: find out the exact name of the input
		String user_lastname = request.getParameter("");
		String user_username = request.getParameter("");
		String user_email = request.getParameter("");
		String user_password = request.getParameter("");
		String user_gender = request.getParameter("");
		String user_dob = request.getParameter("");
		String user_address = request.getParameter("");
		String user_contact = request.getParameter("");
		
		User theUser = new User(user_username,user_password,user_firstname,user_lastname,user_email, user_gender, user_dob,user_address,user_contact);
		
		userDataUtil.registerUser(theUser);
	}

	private void viewUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


}
