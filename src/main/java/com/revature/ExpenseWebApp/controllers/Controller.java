package com.revature.ExpenseWebApp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	void handleGet(HttpServletRequest request, HttpServletResponse response);
	void handlePost(HttpServletRequest request, HttpServletResponse response);
}
