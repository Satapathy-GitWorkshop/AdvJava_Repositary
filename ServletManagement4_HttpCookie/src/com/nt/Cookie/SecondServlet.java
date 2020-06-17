package com.nt.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
    

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   HttpSession ses=null;
//General Setting
	   pw=res.getWriter();
	   res.setContentType("text/html");
//Read form2 data
	   String st1=req.getParameter("st1");
	   String st2=req.getParameter("st2");
//Access to the Seeion Object
	   ses=req.getSession(false);
//Get The Session id---
	   String id=ses.getId();
//GET the Session Attribute Value
	   String name=(String) ses.getAttribute("name");
	   String age=(String) ses.getAttribute("age");
	   String adds=(String) ses.getAttribute("adds");
	   String gender=(String) ses.getAttribute("gender");
//Printing These attribute and form data
	   pw.println("<b>Form1/Attribute Values Are----<br>");
	   pw.println("<b>Person Name:"+name+"<br>");
	   pw.println("<b> Age:"+age+"<br>");
	   pw.println("<b> Adds:"+adds+"<br>");
	   pw.println("<b> Age:"+gender+"<br>");
	   
	   pw.println("<b>Matretial Details:");
	   pw.println("Reasion of Marriage:"+st1+"<br>");
	   pw.println("Timing of Marriage:"+st2+"<br>");
//Adding Hyperlink
	 pw.println("<a href='input.html'>Home</a><br>");
//printing the Session id
	   pw.println("<b>Session id:"+id);
	   
	   
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
