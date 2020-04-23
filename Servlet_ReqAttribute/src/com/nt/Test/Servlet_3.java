package com.nt.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/thirdurl")
public class Servlet_3 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw= res.getWriter();
		//Set Content Type
		res.setContentType("text/html");
		//Read the Attribute
		String name=(String)req.getAttribute("name");
		pw.println("<h1 style ='color:red;text-align':center>Third-Servlet Attribute Value:"+""+""+name+"</h1>");
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
