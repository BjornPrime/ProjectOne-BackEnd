package com.revature.ExpenseWebApp.delegate;

import com.revature.ExpenseWebApp.controllers.DisposeController;
import com.revature.ExpenseWebApp.controllers.Controller;
import com.revature.ExpenseWebApp.controllers.LoginController;
import com.revature.ExpenseWebApp.controllers.LogoutController;
import com.revature.ExpenseWebApp.controllers.ReimbursementController;
import com.revature.ExpenseWebApp.controllers.SignupController;
import com.revature.ExpenseWebApp.controllers.SubmitController;
import com.revature.ExpenseWebApp.controllers.UserController;
import com.revature.ExpenseWebApp.controllers.DetailsController;

public enum Delegate {
	//should these be for each action or each controller?
	LOGIN(new LoginController()),
	SIGNUP(new SignupController()),
	LOGOUT(new LogoutController()),
	SUBMIT(new SubmitController()),
	DISPOSE(new DisposeController()),
	USERS(new UserController()),
	DETAILS(new DetailsController()),
	REIMBURSEMENTS(new ReimbursementController()),
	NOT_FOUND(new Controller() {});
	
	public Controller controller;
	
	private Delegate(Controller controller) {
		this.controller = controller;
	}
	
	public static Delegate getDelegate(String str) {
		
		if (str == null) return NOT_FOUND;
		
		String upper = str.toUpperCase();
		
		for(Delegate delegate : Delegate.values()) {
			if (upper.contentEquals(delegate.name())) {
				return delegate;
			}
		}
		return NOT_FOUND;
	}
}
