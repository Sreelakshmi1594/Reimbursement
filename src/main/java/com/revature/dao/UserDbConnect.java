package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDbConnect {
	
	
	
	private final String URL ="jdbc:postgresql://project-1.cbfqi6kwun7b.us-east-2.rds.amazonaws.com:5432/reimbursementdb";
	private final String username ="reimbursementuser";
	private final String password ="password";
	
	public Connection getDbConnection() throws SQLException{
		 
//			Class.forName("org.Postgresql.Driver");
			DriverManager.registerDriver(new org.postgresql.Driver());
			return DriverManager.getConnection(URL, username, password);
		
		
	}
}
