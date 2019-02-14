package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.services.UserService;

public class UserController implements Controller {

	public void handleGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			User user = UserService.getUser(req.getAttribute("user-id"));
			ObjectMapper om = new ObjectMapper();
			
			Writer writer = resp.getWriter();
			
			
			om.writeValue(writer, user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			InputStream is = req.getInputStream();
			
			ObjectMapper om = new ObjectMapper();
			
			User user = om.readValue(is, User.class);
			
			UserService.createUser(user);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
