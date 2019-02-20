package com.revature.ExpenseWebApp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ExpenseWebApp.controllers.Controller;
import com.revature.ExpenseWebApp.controllers.ReimbursementController;
import com.revature.ExpenseWebApp.controllers.UserController;
import com.revature.ExpenseWebApp.delegate.Delegate;
import com.revature.ExpenseWebApp.util.HttpException;

public class DispatcherServlet extends HttpServlet {
	
//	Map<Delegate, Controller> controllerRegistry = new HashMap<>();
	
	//set up controller registry on initialization
	public void init() {
//		Controller reimbursementController = new ReimbursementController();
//		Controller userController = new UserController();
//		
//		controllerRegistry.put(Delegate.REIMBURSEMENT, reimbursementController);
//		controllerRegistry.put(Delegate.USER, userController);
	}
	
	public Controller getController(HttpServletRequest req) {
		String uri = req.getRequestURI();
		System.out.println(uri);
		String[] strings = uri.split("/");
		System.out.println(strings);
		String resource = null;
		
		if(strings.length > 1) {
			resource = strings[3];
			System.out.println(resource);
			Delegate delegate = Delegate.getDelegate(resource);		
			return delegate.controller;
		} else {
			return null;
		}
		
		
	}
		
	// when receiving request, determine which controller it should go to, then add attribute to request transmitting that info
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service invoked");
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.addHeader("Access-Control-Allow-Headers", "content-type");
		// ^^^ make these two lines a private method ^^^
		// They provide responses with clearance and avoid CORS errors
		
		Controller controller = getController(req);
		if (controller == null) {
			resp.sendError(404);
			return;
		}
		req.setAttribute("controller", controller);
		System.out.println("controller set");
		try {
			super.service(req, resp);
		} catch (HttpException e) {
			resp.sendError(e.getCode());
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller = (Controller) req.getAttribute("controller");
		System.out.println("doGet invoked");
		controller.handleGet(req, resp);
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller = (Controller) req.getAttribute("controller");
		System.out.println("do Post invoked");
		controller.handlePost(req, resp);
		System.out.println("Post handled");
		super.doPost(req, resp);
	}
	
//	@Override
//	public void service(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("Landing request accepted");
//	}
}
