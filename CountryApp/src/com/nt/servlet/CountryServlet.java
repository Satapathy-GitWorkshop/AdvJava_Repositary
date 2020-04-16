package com.nt.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CountryServlet extends HttpServlet{
	@Override 
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			                                       throws ServletException,IOException{
	String stateIndia[]= {"Odisha","Bihar","kolkata"};
	String USAstate[]= {"california","Florida","Texas"};
	String Chinastate[]= {"Hubei","Hainan","Hunan"};
	String country=null;
	
	//Read Data from Html component
	country=req.getParameter("country");
	
	PrintWriter pw=res.getWriter();
	//Set ContentTycpe
	res.setContentType("text/html");
	
if(country.equals("India")) {
	pw.println("<center><h1 style='color:red'>State="+Arrays.toString(stateIndia)+"</h1></center>");
}
if(country.equals("USA")) {
	pw.println("State="+Arrays.toString(USAstate));
}
if(country.equals("China")) {
	pw.println("State="+Arrays.toString(Chinastate));
}
pw.close();
	}

	@Override 
	public void doPost(HttpServletRequest req,HttpServletResponse res) 
			                                       throws ServletException,IOException{	
		doGet(req,res);
	}
}
