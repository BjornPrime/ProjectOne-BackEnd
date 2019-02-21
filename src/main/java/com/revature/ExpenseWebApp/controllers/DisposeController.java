package com.revature.ExpenseWebApp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ExpenseWebApp.dto.DisposalRequestDTO;
import com.revature.ExpenseWebApp.services.ReimbursementService;

public class DisposeController implements Controller {
	
	@Override
	public void handlePost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		ObjectMapper om = new ObjectMapper();
		DisposalRequestDTO disposal = om.readValue(req.getInputStream(), DisposalRequestDTO.class);
		ReimbursementService.disposeReimbursement(disposal);
	}
}
