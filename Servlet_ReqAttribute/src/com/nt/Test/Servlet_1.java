package com.nt.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class Servlet_1 extends HttpServlet {	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//Get Printwriter
	 PrintWriter pw=res.getWriter();
	 //Set Response ContentType
	 res.setContentType("text/html");
	 //Set Req Attribute 
	 req.setAttribute("name","chiku");
	 pw.println("<br>First-Servlet Attribute Value:"+req.getAttribute("name"));
	 //create RequestDispather
	 RequestDispatcher rd=req.getRequestDispatcher("/secondurl");
	 rd.forward(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
