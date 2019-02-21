package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;
import java.io.Writer;

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
		
//		HttpSession session = req.getSession();
//		session.setAttribute("userID", user.getUserID());
//		if(user.getUserRole() == 2) {
//			session.setAttribute("isManager", true);
//		} else {
//			session.setAttribute("isManager", false);
//		};
//		
		
		om = new ObjectMapper();
		Writer writer = resp.getWriter();
		om.writeValue(writer, user);
		
		System.out.println("log in invoked");
		System.out.println(resp);
//		HttpSession session = req.getSession();
//		session.setAttribute("user", user);
		
//		Controller.super.handlePost(req, resp);
	}
}
