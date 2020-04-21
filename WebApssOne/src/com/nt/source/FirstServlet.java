package com.nt.source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/s1url")
public class FirstServlet extends HttpServlet {
	public static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw=res.getWriter();
		//Set ResponseContent Type
		res.setContentType("text/html");
		//Receive Form Component
		int no=Integer.parseInt(req.getParameter("t1"));
		//Calcuate The Square Value
		int square=no*no;
		pw.println("<br>First Servlet Square Value"+square);
		//Get 1st Servlet Context Object
		ServletContext sc1=getServletContext();
		//Get 2nd Servlet Context Object
		ServletContext sc2= sc1.getContext("/WebAppsTwo");
		//get Request Dispatcher Object
		RequestDispatcher rd=sc2.getRequestDispatcher("/s2url");
		//caling Include Method
		rd.include(req,res);
		//Closing Sttram
		pw.close();
	}//doGet(-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
