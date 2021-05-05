package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.ReimbDaoImplement;
import com.revature.model.ReimbursementModel;
import com.revature.model.User;
import com.revature.service.ReimbService;


public class JsonDispatcherServlet {
	
public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
		res.setDateHeader("Expires", 0);
		switch(req.getParameter("reimbid")) {
		
		 case "1":
			 res.setContentType("text/html");  
		     PrintWriter out=res.getWriter(); 
		     InputStream inputStream = null; 
			 System.out.println("approved");
			 String reimbId =req.getParameter("id");
			 System.out.println("hello "+req.getParameter("id"));
			 ReimbService reimbser = new ReimbService(new ReimbDaoImplement());
			 int id= Integer.parseInt(req.getParameter("id"));
			 reimbser.updatestatus(2,id);
			 res.sendRedirect("/Reimbursement/MasterServlet");
			 
			 
			 
			 break;
			 
		 case "2":
			 System.out.println("rejected");
			 System.out.println("hello "+req.getParameter("id"));
			 ReimbService reimbser1 = new ReimbService(new ReimbDaoImplement());
			 int id1= Integer.parseInt(req.getParameter("id"));
			 reimbser1.updatestatus(3,id1);
			 res.sendRedirect("/Reimbursement/MasterServlet");
			 
			 break;
			 
		
			 
		
		
		}
	}



}
