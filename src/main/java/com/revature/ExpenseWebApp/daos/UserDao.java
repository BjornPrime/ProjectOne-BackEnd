package com.revature.ExpenseWebApp.daos;

import java.sql.Connection;
import java.sql.DriverManager;

import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.util.HttpException;

public class UserDao {
//	
//	List<User> users = new ArrayList<>();
//	Map<S>
	
	Connection conn = DriverManager.getConnection()
	
	public User createUser(User user) {
		if (//check email
				) {
				throw new HttpException(400, "Email in use");
		}
		
		if (//check username?
				) {
			throw new HttpException(400, "Username in use")
		}
		
		//add user to db
}

	public User getUserByEmail(String email) {
		// search db by email and return user
		return null;
	}
