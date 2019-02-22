package com.revature.ExpenseWebApp.services;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.ExpenseWebApp.daos.UserDao;
import com.revature.ExpenseWebApp.dto.LoginRequestDTO;
import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.util.HttpException;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	private static UserService userService = new UserService();
	public static UserService getUserService() {
		return userService;
	}
	
	public static User signup(User user) {
		if (user.getEmail().isEmpty()) {
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
			return user = UserDao.retrieveUser((int)userID);
		} else {
			return null;
		}
	}

	public User login(LoginRequestDTO dto) {
		System.out.println(dto);
		User user = userDao.getUserByEmail(dto.getEmail());
		System.out.println(user);
		if(user != null && user.getPassword().equals(BCrypt.hashpw(dto.getPassword(), user.getSalt()))) {
			return user;
		}
		throw new HttpException(401, "Invalid login credentials");
	}
}
