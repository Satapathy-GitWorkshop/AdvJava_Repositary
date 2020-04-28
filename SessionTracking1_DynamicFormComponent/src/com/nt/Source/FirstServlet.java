package com.nt.Source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//Get PrintWriter
		pw=res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
		//Receive The Form Component
		String name=req.getParameter("pname");
		String age=req.getParameter("page");
		String mstatus=req.getParameter("ms");
	//Put Conditon for Check wheather MArried or Not
		
		if(mstatus==null)
			mstatus="single";
		
		if(mstatus.equals("married")) {
			pw.println("<h1 style='color:red;text-align:center'>Provide Married Life Details</h1>");
			pw.println("<form action='secondurl'method='post'>");
			pw.println("<b>Spouse Name:<input type='text' name='st1'><br>");
			pw.println("<b>No.of Children:<input type='text' name='st2'><br>");
			pw.println("<input type='submit' value='Press'>");
	        pw.println("</form>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Provide Bachlor Life Deatils</h1>");
			pw.println("<form action='secondurl'method='post'>");
			pw.println("<b>When Do You Want to Marry:<input type='text' name='st1'><br>");
			pw.println("<b>Why do you want to marry  :<input type='text' name='st2'><br>");
			pw.println("<input type='submit' value='Press'>");
	        pw.println("</form>");
		}
		// Close The Stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
