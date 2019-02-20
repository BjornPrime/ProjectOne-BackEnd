package com.revature.ExpenseWebApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	public static Connection conn = getConnection();
	
	public static Connection getConnection() {
		
		try {
			String url = "jdbc:postgresql://devdb.csansgctnbwu.us-east-2.rds.amazonaws.com:5432/devdb";
			String role ="expense_app_jdbc";
			String password = System.getenv("devdbpwd");
			
			Class.forName("org.postgresql.Driver");
//			Connection conn = null;
			
			conn = DriverManager.getConnection(url, role, password);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
