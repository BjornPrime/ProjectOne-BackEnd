package com.revature.ExpenseWebApp.dto;

public class LoginRequestDTO {
	
	private String email;
	private String password;

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginRequestDTO [email=" + email + ", password=" + password + "]";
	}
	
	
}
