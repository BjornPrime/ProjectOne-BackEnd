package com.revature.ExpenseWebApp.services;

import com.revature.ExpenseWebApp.daos.ReimbursementDao;
import com.revature.ExpenseWebApp.models.Reimbursement;
import com.revature.ExpenseWebApp.util.HttpException;

public class ReimbursementService {
	
	public static Reimbursement createReimbursement(Reimbursement reimbursement) {
		
		reimbursement = ReimbursementDao.addReimbursement(reimbursement);
		if (reimbursement != null) {
			return reimbursement;
		}
		throw new HttpException(401, "Request not processed");
	}
	
	public static Reimbursement retrieveReimbursement(int reimbID) {
		return null;
	}

}
