package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.services.UserService;

public class SignupController implements Controller {

	@Override
	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
	//	UserService userService = new UserService();
		
		ObjectMapper om = new ObjectMapper();
		User user = om.readValue(req.getInputStream(), User.class);
		user = UserService.signup(user);
		om.writeValue(resp.getWriter(), user);
		Controller.super.handlePost(req, resp);
	}
}
