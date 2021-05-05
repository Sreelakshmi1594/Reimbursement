package com.revature.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.UserController;
import com.revature.dao.ReimbDaoImplement;
import com.revature.model.ReimbursementModel;
import com.revature.service.ReimbService;

public class RequestDispatcher1 {
	
public static String process(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		res.setHeader("Progma", "no-cache");
		res.setDateHeader("Expires", 0);
		switch(req.getRequestURI()) {
			case "/Reimbursement/MasterServlet":
				return UserController.login(req,res);
				
			default:
					System.out.println("in default");
					return "/Html/Login.html";
				
			
		
		}
		
	}

public static void printData(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	res.setHeader("Progma", "no-cache");
    res.setDateHeader("Expires", 0);
	List<ReimbursementModel> list;
	ReimbService reimbser = new ReimbService(new ReimbDaoImplement());
	list=reimbser.getAccountStatusPending();
	res.setContentType("text/html");
	ServletOutputStream out; 
	out = res.getOutputStream();
	out.print("<html><body style='background: linear-gradient(to right, #b92b27, #1565c0);'>");
	out.print("<a style='position: absolute; top: 8px; right: 100px; font-size: 18px; color:white;' href=\"/Reimbursement/LogoutServlet\" color:'white'>Logout</a>" + "<br>");
	out.print("<br><table border='1' width='100%'>"); 
	out.print("<tr><th>Reimbursement Id</th><th>Amount</th><th>Description</th><th>Status</th></tr>"); 
	for(ReimbursementModel rm2 : list) {
    	int statusid = rm2.getStatusId();
    	if(statusid==1) {
    		out.print("<form action=\"/Reimbursement/getrejected.json\" method='post'>");
    		out.print("<tr><td><input type='hidden' name='id' value='"+rm2.getReimbId()+"'/>"+rm2.getReimbId()+
    				"</td><td><input type='hidden' name='amount' value='"+rm2.getReimbAmount()+"'/>"+rm2.getReimbAmount()+
    				"</td><td><input type='hidden' name='description' value='"+rm2.getReimbDescription()+"'/>"+rm2.getReimbDescription()+
    				"</td><td><button type='submit' name='reimbid' value='1'>"
    				+ "Approve"
    				+ "</button><button type='submit' name='reimbid' value='2'>Deny</button>"
    				+ "</td></tr>");
    		out.print("</form>");
		}
		
	}
    		
    	out.print("</table></body></html>");		
    	

}

}
