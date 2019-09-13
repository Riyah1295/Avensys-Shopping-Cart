package com.shoppingcart.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
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
	
	@Resource(name="jdbc/shopping")
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
			if(theCommand == null) { // FOR BACKEND TESTING ONLY, REMOVE IF THERE IS HTML/JSP PAGES AVAILABLE
				theCommand = "REGISTER";
			}
			switch(theCommand) {
			case "LOGIN":
				loginUser(request,response);
				break;
			case "VIEW":
				viewUserProfile(request,response);
				break;
			case "REGISTER":
				registerUser(request,response);
				break;
			default:
				registerUser(request, response);
			}
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		/**
		 * 1. retrieve user email and password and verify
		 * 2. execute sql statement to find user
		 * 3. save result set into new Student object and display.
		 */
		String input_email = request.getParameter("");
		String input_password = request.getParameter("");
		User thisUser = userDataUtil.loginUser(input_email,input_password);
		if(thisUser== null) { // this means no such email or password exist in the db, this will return back to login page to display error
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/.jsp"); // TODO: return to login page and display error message
			request.setAttribute("", "username or password is incorrect."); // TODO: add the error msg name tag
			dispatcher.forward(request, response);
		}else { // thisUser has data inside, meaning the username and password matches
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/.jsp"); // TODO: redirect to welcome page 
			request.setAttribute("", ""); // TODO: might have attributes you want to display, might add later.
			dispatcher.forward(request, response);
		}
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 1. Read input that is passed in
		 * 2. create new user object to save the input
		 * 3. insert new user into database
		 */
//		String user_firstname = request.getParameter(""); // TODO: find out the exact name of the input
//		String user_lastname = request.getParameter("");
//		String user_username = request.getParameter("");
//		String user_email = request.getParameter("");
//		String user_password = request.getParameter("");
//		String user_gender = request.getParameter("");
//		String user_dob = request.getParameter("");
//		String user_address = request.getParameter("");
//		String user_contact = request.getParameter("");
		String user_firstname = "fdsafsa";
		String user_lastname =  "fdsafsa";
		String user_username =  "fdsafsa";
		String user_email =  "fdsafsa@fdsa.co";
		String user_password =  "fdsafsa";
		String user_gender =  "fdsafsa";
		String user_dob =  "1995-01-01";
		String user_address =  "fdsafsa";
		String user_contact =  "999";
		
		User theUser = new User(user_username,user_password,user_firstname,user_lastname,user_email, user_gender, user_dob,user_address,user_contact);
		
		userDataUtil.registerUser(theUser);
		System.out.println("db insertion success");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/.jsp"); // TODO: change this page to a thankyou page
		
		dispatcher.forward(request, response);
	}

	private void viewUserProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		/**
		 * 1. retrieve user id from page
		 * 2. execute sql statement in data util and retrieve user data from the user id
		 * 3. save result set to new student object and set attribute
		 */
		String user_username = request.getParameter("");
		User userProfile = userDataUtil.viewUserProfile(user_username);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/.jsp"); // TODO: change the jsp to the profile page
		request.setAttribute("", userProfile); // TODO: remember set the attribute name
		dispatcher.forward(request, response);
		
	}


}
