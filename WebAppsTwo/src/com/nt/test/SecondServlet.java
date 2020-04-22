package com.nt.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/s2url")
public class SecondServlet extends HttpServlet {	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriterObject
		PrintWriter pw= res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
		//Read  FormComponent
		int data=Integer.parseInt(req.getParameter("t1"));
		//CalCulating Cube Value
		int cube=data*data*data;
		pw.println("<br>Second Servlet Cube Value:"+cube);			
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
}
