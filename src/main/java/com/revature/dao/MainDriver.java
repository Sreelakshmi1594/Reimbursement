package com.revature.dao;

import java.util.List;
import java.util.Scanner;

import com.revature.model.ReimbursementModel;


public class MainDriver {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----Welcome----");
		// Read user input
		System.out.println("Enter Email id:");
		String email = sc.next();  
		System.out.println("Enter password:");
		String password= sc.next();
		UserDaoImplement us = new UserDaoImplement();
	    us.checkLogin(email, password);
	    us.getAll();
	    ReimbDaoImplement rm = new ReimbDaoImplement();
	    List <ReimbursementModel> rm1;
	    rm1 = rm.getReimbDetails(4567891);
	   
//	    rm1= rm.getAll();
	    for(ReimbursementModel rm2 : rm1) {
	    	System.out.println(rm2);
	    }
		
		
	}

}
