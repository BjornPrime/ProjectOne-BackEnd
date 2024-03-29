package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.services.ReimbursementService;

public class SubmitController implements Controller {
	
	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper om = new ObjectMapper();
		Reimbursement reimbursement = om.readValue(req.getReader(), Reimbursement.class);
//		
//		HttpSession session = req.getSession();
//		reimbursement.setAuthor((int) session.getAttribute("userID"));

		System.out.println(reimbursement);
		reimbursement = ReimbursementService.createReimbursement(reimbursement);
		
	}
}
