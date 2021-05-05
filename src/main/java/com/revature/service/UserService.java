package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbDaoImplement;
import com.revature.dao.UserDaoImplement;
import com.revature.model.User;

public class UserService {
	public final static Logger log = Logger.getLogger(UserService.class);
	private UserDaoImplement urDao;
	public UserService() {
		
	}
	public UserService(UserDaoImplement urDao) {
		super();
		this.urDao = urDao;
		log.info("Inside User service class");
	}
	
	public User getVerifyLogin(String email,String password) {
		log.info("validating user credential");
		User user= (User) urDao.checkLogin(email,password);
		if(user.getEmail() !=null) {
			return user;
			
		}
		return null;
	}

}
