package com.nt.source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Header")
public class Header extends HttpServlet {
	
    
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter 
		PrintWriter pw=null;
		pw=res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
		//set Header Content
		
		pw.println("<h1 style='color:red;text-align:center'><marquee>N A R E S H  I T </marquee></h1>");
		//closing Stream
		    //pw.close();				
	}		

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
