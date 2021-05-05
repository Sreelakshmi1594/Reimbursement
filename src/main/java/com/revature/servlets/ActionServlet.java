package com.revature.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.log4j.Logger;

import com.revature.dao.ReimbDaoImplement;
import com.revature.model.ReimbursementModel;
import com.revature.model.User;
import com.revature.service.ReimbService;


@MultipartConfig


public class ActionServlet extends HttpServlet{
	
	public final static Logger log = Logger.getLogger(ActionServlet.class);	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
        res.setDateHeader("Expires", 0);
		res.setContentType("text/html"); 
		HttpSession session=req.getSession(false);
		User user = (User)session.getAttribute("User");
		PrintWriter out=res.getWriter();
		out.print("<html><body style='background: linear-gradient(to right, #b92b27, #1565c0);'>");
		log.info("inside User account");
		out.print("<p style='color:white;'>Welcome" +" " + user.getFirstName() + "</p><br>");
		out.print("<a style='position: absolute; top: 8px; right: 100px; font-size: 18px; color:white;' href='/Reimbursement/LogoutServlet'>Logout</a>");
		ActionRequestDispatcher.printData(req,res);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        res.setHeader("Progma", "no-cache");
        res.setDateHeader("Expires", 0);
		res.setContentType("text/html;charset=UTF-8");  
        PrintWriter out=res.getWriter(); 
        out.print("<html><body style='background: linear-gradient(to right, #b92b27, #1565c0);'>");
        out.print("It Has Been Successfull Submitted" + 
        "<a style='position: absolute; top: 8px; right: 16px; font-size: 18px; color:white;' href='/Reimbursement/LogoutServlet'>Logout</a>");
        ActionRequestDispatcher.process(req, res);
        
	}

	
	

}
