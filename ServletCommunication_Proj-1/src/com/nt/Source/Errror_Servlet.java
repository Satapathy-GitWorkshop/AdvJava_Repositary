package com.nt.Source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/Errror_Servlet",name="err")
public class Errror_Servlet extends HttpServlet {
	
	
   PrintWriter pw = null;
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter Object
		pw= res.getWriter();
		//Set response ContentType
		res.setContentType("text/html");
		pw.println("<h1 style='color:red;text-align:center:'>Please Chosse Correct No:</h1>");
		pw.println("<h1 style='color:red;text-align:center:'>ThankYou Try Again :)</h1>");
		pw.println("<a href='input.html'>HoMe</a>");
		//close Stream
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
