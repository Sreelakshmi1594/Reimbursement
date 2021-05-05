package com.revature.model;

public class ReimbursementType {
	private String reimbType;

	public ReimbursementType(String reimbType) {
		super();
		this.reimbType = reimbType;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbType=" + reimbType + "]";
	}
	

}
