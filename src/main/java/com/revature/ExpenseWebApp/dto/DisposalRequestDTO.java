package com.revature.ExpenseWebApp.dto;

public class DisposalRequestDTO {
	
	private int statusUpdate;
	private int reimbursementID;
	public int getStatusUpdate() {
		return statusUpdate;
	}
	public void setStatusUpdate(int statusUpdate) {
		this.statusUpdate = statusUpdate;
	}
	public int getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	@Override
	public String toString() {
		return "RespondRequestDTO [statusUpdate=" + statusUpdate + ", reimbursementID=" + reimbursementID + "]";
	}
	
	public DisposalRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
