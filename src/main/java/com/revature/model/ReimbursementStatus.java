package com.revature.model;

public class ReimbursementStatus {
private String reimbStatus;

public ReimbursementStatus(String reimbStatus) {
	super();
	this.reimbStatus = reimbStatus;
}

public String getReimbStatus() {
	return reimbStatus;
}

public void setReimbStatus(String reimbStatus) {
	this.reimbStatus = reimbStatus;
}

@Override
public String toString() {
	return "ReimbursementStatus [reimbStatus=" + reimbStatus + "]";
}


}
