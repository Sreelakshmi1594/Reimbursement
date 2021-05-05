package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

public interface ReimbursementDao<T>{
	List<T> getAll();
	List getReimbDetails(int author);
	void update(int statusid,int authorid);
	void updateResolvingTime(int reimbid);
	void createReimb(float amount,String description,InputStream receipt,int authorId,int typeId);
	public List gettingAccountStatus();

}
