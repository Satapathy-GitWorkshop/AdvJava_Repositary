package com.nt.AttributeTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/fourthurl")
public class FourthServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
	       ServletContext sc=null;
	       HttpSession ses=null;
		//Get PrintWriter
				PrintWriter pw=res.getWriter();
				//Set Response ContentType
				res.setContentType("text/html");
				//create session Attribute object
				 ses=req.getSession();
				//Read Both req,session Attribute Value
				pw.println("<br>4rd Servlet reqAttribute Value="+req.getAttribute("name"));
				pw.println("<br>4rd Servlet SessionAttribute Value="+ses.getAttribute("adds"));
				//get ServletContext
				sc=getServletContext();
				pw.println("<br>4rd Servlet ContextAttribute Value="+sc.getAttribute("color"));
				
		
	}
		
	

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
