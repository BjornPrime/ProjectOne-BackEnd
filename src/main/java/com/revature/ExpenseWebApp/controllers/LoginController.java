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
		
		ObjectMapper om = new ObjectMapper();
		LoginRequestDTO dto = om.readValue(req.getReader(), LoginRequestDTO.class);
		User user = userService.login(dto);
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		
		Controller.super.handlePost(req, resp);
	}
}
