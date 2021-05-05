package com.revature.model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
//import java.time.Instant;

public class ReimbursementModel {
	
	private int reimbId;
	private float reimbAmount;
	Timestamp reimbSubmitted; 
	Timestamp reimbResolved;
	private String reimbDescription;
	InputStream receipt;
	private int author;
	private int resolver;
	private int statusId;
	private int typeId;
	

	public ReimbursementModel(int reimbId, float reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDescription, InputStream receipt, int author, int resolver, int statusId, int typeId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.receipt = receipt;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.typeId = typeId;
	}
	public ReimbursementModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ReimbursementModel(int reimbId,float reimbAmount, String reimbDescription,int statusId) {
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.statusId = statusId;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(float reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	public InputStream getReceipt() {
		return receipt;
	}
	public void setReceipt(InputStream receipt) {
		this.receipt = receipt;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "ReimbursementModel [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbSubmitted="
				+ reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription
				+ ", receipt=" + receipt + ", author=" + author + ", resolver=" + resolver + ", statusId=" + statusId
				+ ", typeId=" + typeId + "]";
	}
	
	
	
	

	


}