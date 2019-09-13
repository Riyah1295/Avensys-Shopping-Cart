package com.shoppingcart.dataUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.shoppingcart.entity.User;

public class UserDataUtil {
	
	@Resource(name="jdbc/") // TODO: add database schema name
	private DataSource dataSource;

	public UserDataUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void registerUser(User theUser) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String query = "";
		}
		
	}

}
