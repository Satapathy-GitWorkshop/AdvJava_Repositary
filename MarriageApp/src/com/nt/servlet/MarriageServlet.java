package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class MarriageServlet extends HttpServlet{
	@Override
   public void doPost(HttpServletRequest req,HttpServletResponse res)
	                                               throws ServletException,IOException  {
	   

	   PrintWriter pw=null;
	   String name=null,gender=null;
	   int age=0;
//Get printwriter
pw=res.getWriter();
//set Contentype
res.setContentType("text/html");
//Get reqest parameter value
name=req.getParameter("pname");
age=Integer.parseInt(req.getParameter("page"));
gender=req.getParameter("gen");

//write req processing logic
if(gender.equalsIgnoreCase("M"))
	{
	if(age>=21)
		{
		pw.println("<h1 style='color:red'>"+"MR "+name+"You are eligible for marriage</h1>");
	}
	else
		{
		pw.println("<h1 style='color:brown'>"+"MR"+name+"You are not eligible for marriage</h1>");
	}
	}
	else{
		if(age>=18)
			{
			pw.println("<h1 style='blue:blue'>"+"MRS"+name+"You are eligible for marriage</h1>");
		}
		else{
			pw.println("<h1 style='color:black'>"+"MRS"+name+"You are  not eligible for marriage</h1>");
		}
	}
	//Adding hyper link
	pw.println("<a href='input.html'><img src='home.jpg'></a>");
	pw.close();
}
	}