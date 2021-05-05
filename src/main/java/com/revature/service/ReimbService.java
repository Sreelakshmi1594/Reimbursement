package com.revature.service;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import com.revature.dao.ReimbDaoImplement;
import com.revature.model.ReimbursementModel;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
								
public class ReimbService {
	
	public final static Logger log = Logger.getLogger(ReimbService.class);

	private ReimbDaoImplement rDao;
	public ReimbService() {
		
	}
	public ReimbService(ReimbDaoImplement rDao) {
		super();
		this.rDao = rDao;
		log.trace("in rdao");
		log.info("Inside reimbservice");
	}
	 public void getReimb(float amount, String description, InputStream receipt, int authorId, int typeId) {
		 rDao.createReimb(amount, description, receipt, authorId, typeId);
		 
	 }
	 
	 public List getDetails(int authodId) {
		
		List <ReimbursementModel> rm1;
		 rm1 = rDao.getReimbDetails(authodId);
		 return rm1;
	 }
	 
	 public List getAccountStatusPending() {
		 List <ReimbursementModel> rm1;
		 rm1 = rDao.getAll();
		 System.out.println("from service" + rm1);
		 return rm1;
	 }
	 
	 public String updatestatus(int statusid, int reimbid) {
		 rDao.update(statusid, reimbid);
		 return "Sucess";
	 }
}
