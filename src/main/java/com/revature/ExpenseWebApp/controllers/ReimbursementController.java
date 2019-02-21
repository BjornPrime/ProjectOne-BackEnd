package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.models.User;
import com.revature.ExpenseWebApp.services.ReimbursementService;

public class ReimbursementController implements Controller {

	public User getUserFromSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			resp.sendError(401);
			return null;
		}
		
		return user;
	}
	
	public void handleGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		User user = this.getUserFromSession(req, resp);
		
//		String reimbursementsFromString = req.getParameter("reimb_author");
//		List<Reimbursement> reimbursements;
//		
//		if (reimbursementsFromString == null) {
//			reimbursements = ReimbursementService.getReimbursements();
//		} else {
//			int fromId = Integer.parseInt(reimbursementsFromString);
//			
//			reimbursements = ReimbursementService.getReimbursementsSince(fromId);
//		}
//		
//		Cookie[] cookieList = req.getCookies();
//		
//		for(Cookie cookie : cookieList) {
//			System.out.println(cookie.getValue());
//		}
//		
		List<Reimbursement> reimbursements = ReimbursementService.getReimbursements();
		ObjectMapper om = new ObjectMapper();
		
		Writer writer = resp.getWriter();
		
		om.writeValue(writer, reimbursements);
		
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		ObjectMapper om = new ObjectMapper();
		int userID = om.readValue(req.getReader(), Integer.class);
		List<Reimbursement> reimbursements = ReimbursementService.getReimbursements(userID);

		om = new ObjectMapper();
		om.writeValue(resp.getWriter(), reimbursements);
//		Reimbursement reimbursement = om.readValue(req.getReader(), Reimbursement.class);
//		ReimbursementService.createReimbursement(reimbursement);
//		
//		try {
//			InputStream is = req.getInputStream();
//		
//			ObjectMapper om = new ObjectMapper();
//
//			Reimbursement reimb = om.readValue(is, Reimbursement.class);
//			
//			ReimbursementService.createReimbursement(reimb);
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		}

}
