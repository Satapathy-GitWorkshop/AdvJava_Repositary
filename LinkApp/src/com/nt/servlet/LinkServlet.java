package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) 
	                                                         throws ServletException,IOException{
		String links=null;
		PrintWriter pw=null;
		Locale locales[]=null;
		//Get Writer
		pw=res.getWriter();
		//Set Content Type
		res.setContentType("text/html");
		//Read s1 req param values for which link is clicked
		links=req.getParameter("s1");
if(links.equalsIgnoreCase("link1")) {
	//Get all avalable locale
	locales=Locale.getAvailableLocales();
	
	for(Locale lc:locales) {
		pw.println(lc.getDisplayLanguage()+"<br>");
	}//for
	}//if

else if(links.equalsIgnoreCase("link2")) {
	//Get all avalable locale
	locales=Locale.getAvailableLocales();
	
	for(Locale lc:locales) {
		pw.println(lc.getDisplayCountry()+"<br>");
	}//for
}//else
else {
	pw.println("Date and Time"+new java.util.Date());
}
//Add Hyperlink
pw.println("<a href='page.html'>home</a>");
	}//doget
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res) 
                                             throws ServletException,IOException{
	   doGet(req,res);
}	
}//class