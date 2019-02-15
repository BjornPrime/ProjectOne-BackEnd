package com.revature.ExpenseWebApp.services;

import com.revature.ExpenseWebApp.daos.UserDao;
import com.revature.ExpenseWebApp.dto.LoginRequestDTO;
import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.util.HttpException;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	public static User signup(User user) {
		if (user.getUserEmail().isEmpty()) {
			throw new HttpException(400, "Email can't be empty");
		}
		
		if (user.getUsername().isEmpty()) {
			throw new HttpException(400, "Username can't be empty");
		}
		
		if (user.getPassword().isEmpty()) {
			throw new HttpException(400, "Password can't be empty");
		}
	
		return user = UserDao.createUser(user);
		
	}
	
	public static User getUser(Object userID) {
		
		User user;
		
		if(userID.getClass() == Integer.class) {
			return user = UserDao.retrieveUser(userID);
		} else {
			return null;
		}
	}

	public User login(LoginRequestDTO dto) {
		User user = userDao.getUserByEmail(dto.getEmail());
		if(user != null && user.getPassword().equals(dto.getPassword())) {
			return user;
		}
		throw new HttpException(401, "Invalid login credentials");
	}
}
