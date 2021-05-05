package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class JsonMasterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
        res.setDateHeader("Expires", 0);
		res.setContentType("text/html"); 
		HttpSession session=req.getSession(false);
		JsonDispatcherServlet.process(req, res);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
        res.setDateHeader("Expires", 0);
        JsonDispatcherServlet.process(req, res);
	}

}
