package com.revature.ExpenseWebApp.services;

import java.util.List;

import com.revature.ExpenseWebApp.daos.ReimbursementDao;
import com.revature.ExpenseWebApp.dto.DisposalRequestDTO;
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

	public static List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = ReimbursementDao.retrieveReimbursements();
		return reimbursements;
	}
	
	public static List<Reimbursement> getReimbursements(int userID) {
		List<Reimbursement> reimbursements = ReimbursementDao.retrieveReimbursements(userID);
		return reimbursements;
	}

	public static Reimbursement getDetails(int entryID) {
		Reimbursement reimbursement = ReimbursementDao.retrieveDetails(entryID);
		return reimbursement;
	}

	public static void disposeReimbursement(DisposalRequestDTO disposal) {
		System.out.println("disposing reimbursement");
		ReimbursementDao.updateReimbursement(disposal);
		
	}

}
