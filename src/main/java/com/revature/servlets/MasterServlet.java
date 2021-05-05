package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
        res.setDateHeader("Expires", 0);
		res.setContentType("text/html"); 
		req.getRequestDispatcher(RequestDispatcher1.process(req,res)).forward(req, res);
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
        res.setDateHeader("Expires", 0);
        RequestDispatcher1.printData(req, res);
	}
}
