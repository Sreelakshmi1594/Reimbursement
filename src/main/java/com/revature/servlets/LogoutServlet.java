package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet   
{
        protected void doGet(HttpServletRequest req, HttpServletResponse res)  
                                throws ServletException, IOException {  
            res.setContentType("text/html"); 
            res.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            res.setHeader("Progma", "no-cache");
            res.setDateHeader("Expires", 0);
            HttpSession session=req.getSession();
            session.invalidate();
            res.sendRedirect("/Reimbursement/Html/Login.html");
//            req.getRequestDispatcher("Html/Logout.html").include(req, res); 

            
    }  
}
