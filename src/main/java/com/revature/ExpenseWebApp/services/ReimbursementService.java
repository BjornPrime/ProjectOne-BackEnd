package com.revature.ExpenseWebApp.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.models.User;

public class ReimbursementService {
	
	public static void createReimbursement(Reimbursement reimbursement, User user) {
		reimbursement.setRequestDate(Timestamp.valueOf(LocalDateTime.now()));
		reimbursement.setRequestor(user.getUserID());
	}
}
