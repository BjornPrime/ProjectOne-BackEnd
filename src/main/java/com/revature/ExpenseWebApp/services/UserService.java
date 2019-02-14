package com.revature.ExpenseWebApp.services;

import com.revature.ExpenseWebApp.daos.UserDao;
import com.revature.ExpenseWebApp.models.User;

public class UserService {
	
	public static void createUser(User user) {
		
		user = UserDao.insertUser(user);
		
	}
	
	public static User getUser(Object userID) {
		
		User user;
		
		if(userID.getClass() == Integer.class) {
			return user = UserDao.retrieveUser(userID);
		} else {
			return null;
		}
	}
}
