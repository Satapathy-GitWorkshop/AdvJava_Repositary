package com.nt.Source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/engineurl")
public class EngineServlet extends HttpServlet {
	String url=null;  
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw= res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
		//Receive For Component
		String ss=req.getParameter("ss");
		String Engine=req.getParameter("engine");
		//prepare url with query string for send redirection
		if(Engine.equals("google")) {
			url="https://www.google.com/search?q="+ss;
		}
		if(Engine.equals("bing")) {
			url="https://www.bing.com/search?q="+ss;
		}
		if(Engine.equals("yahoo")) {
			url="https://in.search.yahoo.com/search?p="+ss;
		}
//attch string to the url using sendRediect method
		res.sendRedirect(url);	
		/*Get RequestDispatcher
		RequestDispatcher rd=req.getRequestDispatcher("Engine.html");
		rd.forward(req.res);
		rd.include(req, res);*/
		
	}//doGet(-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}
}//doPost(-)
