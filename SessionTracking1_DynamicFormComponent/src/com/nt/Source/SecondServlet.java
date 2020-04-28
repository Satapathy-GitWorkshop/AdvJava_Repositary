package com.nt.Source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//Get PrintWriter
		pw=res.getWriter();
		//Set Response ContentType
		res.setContentType("text/html");
		//Read Html Form Data And FirstServlet Dynamic Form Data
		pw.println("<h1 style='color:red;text-align:center'>Html Form Data</h1>");
		pw.println("<br>Name is:"+req.getParameter("pname"));
		pw.println("<br>Age is:"+req.getParameter("page"));
		pw.println("<br>Maretial Status:"+req.getParameter("ms"));
		pw.println("<br>Second Form Data:"+req.getParameter("st1")+"<br>"+req.getParameter("st2"));
		//Close The Stream
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}//class
