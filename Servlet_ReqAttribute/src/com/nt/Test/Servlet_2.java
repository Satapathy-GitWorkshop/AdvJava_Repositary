package com.nt.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class Servlet_2 extends HttpServlet {	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw= res.getWriter();
		//Set Content Type
		res.setContentType("text/html");
		//Read the Attribute
		String name=(String)req.getAttribute("name");
		pw.println("<br>Second-Servlet Attribute Value:"+name);
		RequestDispatcher rd=req.getRequestDispatcher("/thirdurl");
		rd.forward(req, res);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
