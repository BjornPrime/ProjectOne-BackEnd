package com.revature.ExpenseWebApp.models;

import java.util.Queue;

public class User {
	int userID;
	String username;
	String firstName;
	String lastName;
	String userEmail;
	String password;
	int userRole;
	Queue<Integer> userReimbs;
	Queue<Integer> needResolution;
	
	
	
	public User(int userID, String username, String firstName, String lastName, String userEmail, String password,
			int userRole, Queue<Integer> userReimbs, Queue<Integer> needResolution) {
		super();
		this.userID = userID;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.password = password;
		this.userRole = userRole;
		this.userReimbs = userReimbs;
		this.needResolution = needResolution;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public Queue<Integer> getUserRequests() {
		return userReimbs;
	}
	public void setUserRequests(Queue<Integer> userRequests) {
		this.userReimbs = userRequests;
	}
	public Queue<Integer> getNeedResolution() {
		return needResolution;
	}
	public void setNeedResolution(Queue<Integer> needResolution) {
		this.needResolution = needResolution;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userEmail=" + userEmail + ", password=" + password + ", userRole=" + userRole
				+ ", userRequests=" + userReimbs + ", needResolution=" + needResolution + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((needResolution == null) ? 0 : needResolution.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userID;
		result = prime * result + ((userReimbs == null) ? 0 : userReimbs.hashCode());
		result = prime * result + userRole;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (needResolution == null) {
			if (other.needResolution != null)
				return false;
		} else if (!needResolution.equals(other.needResolution))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userID != other.userID)
			return false;
		if (userReimbs == null) {
			if (other.userReimbs != null)
				return false;
		} else if (!userReimbs.equals(other.userReimbs))
			return false;
		if (userRole != other.userRole)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
