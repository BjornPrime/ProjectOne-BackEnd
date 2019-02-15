package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public default void handleGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendError(404);
		return;
	};
	public default void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendError(404);
		return;
	};
}
