package com.revature.ExpenseWebApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	public static Connection conn = getConnection();
	
	public static Connection getConnection() {
		String url = "";
		String role ="";
		String password = "";
		Connection conn = null;
		
		try {conn = DriverManager.getConnection(url, role, password);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
