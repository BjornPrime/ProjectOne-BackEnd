package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.daos.ReimbursementDao;
import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.services.ReimbursementService;

public class ReimbursementController implements Controller {

	public void handleGet(HttpServletRequest req, HttpServletResponse resp) {
		Reimbursement reimbursement = ReimbursementService.retrieveReimbursement(req.getAttribute("request-id"));
		ObjectMapper om = new ObjectMapper();
		
		Writer writer = resp.getWriter();
		
		om.writeValue(writer, reimbursement);
		
	}

	public void handlePost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			InputStream is = req.getInputStream();
		
			ObjectMapper om = new ObjectMapper();

			Reimbursement reimb = om.readValue(is, Reimbursement.class);
			
			ReimbursementService.createReimbursement(reimb);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		}

}
