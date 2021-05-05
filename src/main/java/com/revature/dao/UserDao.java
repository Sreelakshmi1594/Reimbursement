package com.revature.dao;

import java.util.List;

public interface UserDao<T>{
	List<T> getAll();
	T checkLogin(String emailId,String password);

}
