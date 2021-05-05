package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDaoImplement;
import com.revature.model.User;
import com.revature.service.UserService;

public class UserController {
	
	static UserService userServ = new UserService(new UserDaoImplement());
	
	public static String login(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
		res.setDateHeader("Expires", 0);
		if(!req.getMethod().equals("POST")) {
			return "/Html/Login.html";
		}
		
		User user = userServ.getVerifyLogin(req.getParameter("email"),req.getParameter("password"));
		
		if(user == null) {
			req.getRequestDispatcher("/Html/Logout.html").forward(req, res);
			return "/Html/Login.html";
		}else {
			req.getSession().setAttribute("User", user);
			System.out.println(user.getUserId()); 
			if(user.getRole_id()==2) {
			return "Html/UserPage.html";
			}else {
				
				return "Html/ManagerFile.html";
			}
		}
	}


}
