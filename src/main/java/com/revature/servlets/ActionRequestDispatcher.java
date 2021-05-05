package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.revature.dao.ReimbDaoImplement;
import com.revature.model.ReimbursementModel;
import com.revature.model.User;
import com.revature.service.ReimbService;

@MultipartConfig

public class ActionRequestDispatcher {
	
public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	res.setHeader("Progma", "no-cache");
	res.setDateHeader("Expires", 0);
	ReimbService reimbser = new ReimbService(new ReimbDaoImplement());
	float amount= Float.parseFloat(req.getParameter("amount"));
    InputStream inputStream = null; 
	Part filePart= req.getPart("photo");
	if (filePart != null) {      
			inputStream = filePart.getInputStream();
		}
	
    
    HttpSession session=req.getSession(false);
	User user = (User)session.getAttribute("User");
	int iduser = user.getUserId();
	String description =req.getParameter("description");
	int typeId = Integer.parseInt(req.getParameter("type")); 
	reimbser.getReimb(amount,description,inputStream,iduser,typeId); 
	res.sendRedirect("/Reimbursement/Html/UserPage.html");
	 
	}

public static void printData(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	res.setHeader("Progma", "no-cache");
	res.setDateHeader("Expires", 0);
	List<ReimbursementModel> list;
	ReimbService reimbser = new ReimbService(new ReimbDaoImplement());
	HttpSession session=req.getSession();
	User user = (User)session.getAttribute("User");
	PrintWriter out=res.getWriter();
	list= reimbser.getDetails(user.getUserId());
	out.print("<html><body style='background: linear-gradient(to right, #b92b27, #1565c0);'>");
	out.print("<br>");
	out.print("<a style='position: absolute; top: 8px; right: 16px; font-size: 18px; color:white;' href='/Reimbursement/Html/UserPage.html'>Home</a><br>");
	out.print("<table border='1' width='100%'>"); 
	out.print("<tr><th>Reimbursement Id</th><th>Amount</th><th>Description</th><th>Status</th></tr>"); 
	for(ReimbursementModel rm2 : list) {
		int statusid = rm2.getStatusId();
		if(statusid==1) {
		out.print("<tr><td>"+rm2.getReimbId()+"</td><td>"+rm2.getReimbAmount()+"</td><td>"+rm2.getReimbDescription()+"</td><td>Pending</td></tr>");
		}
		else if(statusid==2) {
			out.print("<tr><td>"+rm2.getReimbId()+"</td><td>"+rm2.getReimbAmount()+"</td><td>"+rm2.getReimbDescription()+"</td><td>Approved</td></tr>");
			}
		else{
			out.print("<tr><td>"+rm2.getReimbId()+"</td><td>"+rm2.getReimbAmount()+"</td><td>"+rm2.getReimbDescription()+"</td><td>Denied</td></tr>");
			}
	}
		
	out.print("</table></body></html>");		
	
	
}
	
	
	


}
