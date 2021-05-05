package com.revature.model;

public class UserRole {
	private String userRole;

	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRole [userRole=" + userRole + "]";
	}
	

}
