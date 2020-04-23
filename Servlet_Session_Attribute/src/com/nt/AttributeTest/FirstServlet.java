package com.nt.AttributeTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Get PrintWriter
		PrintWriter pw=res.getWriter();
		//Set Response ContentType
		res.setContentType("text/html");
		//create session Attribute object
				HttpSession ses=req.getSession();
		//Create req attribute
		req.setAttribute("name","chiku");
		
		//set Session Attibute Value
		ses.setAttribute("adds","odisha");
		//Create RequestDispatcher
		RequestDispatcher rd=req.getRequestDispatcher("/secondurl");
		rd.forward(req,res);
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
