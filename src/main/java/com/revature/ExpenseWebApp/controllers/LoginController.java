package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.dto.LoginRequestDTO;
import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.services.UserService;

public class LoginController implements Controller {
	
	UserService userService = new UserService();
	@Override
	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		System.out.println("post handler invoked");
		ObjectMapper om = new ObjectMapper();
		LoginRequestDTO dto = om.readValue(req.getReader(), LoginRequestDTO.class);
		System.out.println("dto created");
		User user = userService.login(dto);
		System.out.println("log in invoked");
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		
		Controller.super.handlePost(req, resp);
	}
}
