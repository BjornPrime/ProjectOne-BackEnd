package com.revature.ExpenseWebApp.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.util.DatabaseConnect;
import com.revature.ExpenseWebApp.util.HttpException;

public class UserDao {
//	
//	List<User> users = new ArrayList<>();
//	Map<S>
//	String url = "";
//	String role = "";
//	String password = null;
//	public static Connection conn = null;
//	
//	try{
//		conn = DriverManager.getConnection(url, role, password);
//	} catch(SQLException e) {
//		e.printStackTrace();
//	}
	
	public static User createUser(User user) {
		
		Connection conn = DatabaseConnect.conn;
		
		System.out.println(user);

		try{
			String query = "SELECT * FROM users WHERE email = ?";
			
			
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, user.getEmail());
			
			
			ResultSet resultSet = statement.executeQuery();
		
			if(resultSet.next()) {
				throw new HttpException(400, "Email already in use");
			}
			
			query = "SELECT * FROM users WHERE username = ?";
			
			statement = conn.prepareStatement(query);
			statement.setString(1, user.getUsername());
			
			resultSet = statement.executeQuery();
			
			
			if (resultSet.next()) {
				throw new HttpException(400, "Username already in use");
			}
			
			query = "INSERT INTO users (first_name, last_ name, password, username, email, role_id) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
			
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getEmail());
			statement.setInt(6, user.getUserRole());
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				user.setUserID(resultSet.getInt("id"));
				return user;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
		
		//add user to db

	public User getUserByEmail(String email) {
		// search db by email and return user
		return null;
	}

	public static User retrieveUser(int userID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
