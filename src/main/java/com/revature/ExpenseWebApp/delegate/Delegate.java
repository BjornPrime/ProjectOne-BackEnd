package com.revature.ExpenseWebApp.delegate;

public enum Delegate {
	USERS,
	REIMBURSEMENTS,
	BASE,
	NOT_FOUND;
	
	public static Delegate getDelegate(String str) {
		
		if (str == null) return BASE;
		
		for(Delegate delegate : Delegate.values()) {
			if (str.toUpperCase().contentEquals(delegate.name())) {
				return delegate;
			}
		}
		return NOT_FOUND;
	}
}
