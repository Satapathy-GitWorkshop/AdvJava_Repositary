package com.nt.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class FormServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	                                                      throws ServletException,IOException{
		
		   String name=null,gender=null,ms=null,addrs=null,qlfy=null,crs[]=null,hb[]=null;
		  int age=0;
		
PrintWriter pw=null;
//Get PrintWriter Object
pw=res.getWriter();
//Set content type
res.setContentType("text/html");
//Read values from data
name=req.getParameter("tname");
age=Integer.parseInt(req.getParameter("tage"));
gender=req.getParameter("gen");
ms=req.getParameter("ms");
addrs=req.getParameter("taddress");
qlfy=req.getParameter("qlfy");
crs=req.getParameterValues("crs");
hb=req.getParameterValues("hb");

//write request processing logic
if(gender.equalsIgnoreCase("M"))
{
if(age<=5)
	pw.println(name+"you are baby");
else if(age<=12)
	pw.println(name+"You are samll boy");
else if(age<19)
	  pw.println(name+"You are teen ager");
	  else if(age<=35)
		  pw.println(name+"You are young man");
	  else if(age<=50)
		  pw.println(name+"You are middle age man");
		  else if(age<=90)
			  pw.println(name+"you are old man");
		  else
			  pw.println(name+"You are gonna be expired");
}//if

else if(gender.equalsIgnoreCase("F")) {
	if(age<=5)
		pw.println(name+"you are baby Girl");
	else if(age<=12)
		pw.println(name+"You are samll girl");
	else if(age<19)
		  pw.println(name+"You are teen age  girl");
		  else if(age<=35)
			  pw.println(name+"You are young Laddy");
		  else if(age<=50)
			  pw.println(name+"You are middle age girl");
			  else if(age<=90)
				  pw.println(name+"you are old girl");
			  else
				  pw.println(name+"You are gonna be expired");
	}// elseif
	
pw.println("<br>name="+name);
pw.println("<br>age="+age);
pw.println("<br>Gender="+gender);
pw.println("<br>Marriatial Status="+ms);
pw.println("<br>Addres="+addrs);
pw.println("<br>Qualifiaction="+qlfy);
pw.println("<br>Course="+Arrays.toString(crs));
pw.println("<br>Hibbies="+Arrays.toString(hb));
	}//do get
	
		public void doPost(HttpServletRequest req,HttpServletResponse res)
		                                                      throws ServletException,IOException{
			doGet(req,res);
		}//do post
}//class