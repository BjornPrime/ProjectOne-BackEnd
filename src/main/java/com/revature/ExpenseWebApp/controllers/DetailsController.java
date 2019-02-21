package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.services.ReimbursementService;

public class DetailsController implements Controller {
	
	@Override
	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		ObjectMapper om = new ObjectMapper();
		int entryID = om.readValue(req.getInputStream(), Integer.class);
		Reimbursement reimbursement = ReimbursementService.getDetails(entryID);
		om.writeValue(resp.getWriter(), reimbursement);
	}

}
