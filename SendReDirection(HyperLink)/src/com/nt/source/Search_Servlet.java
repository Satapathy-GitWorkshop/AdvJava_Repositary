package com.nt.source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class Search_Servlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw=res.getWriter();
		//Set Response ContentType
		   res.setContentType("text/html");
		 //Receive Form Component
		   String ss=req.getParameter("ss");
		  //Add hyperlink to SendRedrection
		   pw.println("<a href ='https://www.google.com/search?q="+ss+"'>Go to google</a>");
		   //closing The Stream
		   pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
