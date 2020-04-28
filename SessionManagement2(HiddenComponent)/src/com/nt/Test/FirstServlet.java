package com.nt.Test;

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
		//Get Writer
		pw=res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
		//Receive Form Componnet Value
		String father=req.getParameter("fname");
		String person=req.getParameter("pname");
		String age=req.getParameter("page");
		String mstatus=req.getParameter("ms");
		
//Set condition according to your requirememt
		if(mstatus.equals("single")) {
			pw.println("<form action='secondurl' method='post'>");
			pw.println("Why u Want to Marry:<input type='text' name='st1'><br>");
			pw.println("When did u Want To Marry:<input type='text' name='st2'><br>");
			//Add the html form page as req hiden Component
			pw.println("<input type='hidden' name='fhname' value="+father+">");
			pw.println("<input type='hidden' name='phname' value="+person+">");
			pw.println("<input type='hidden' name='hage' value="+age+">");
			pw.println("<input type='hidden' name='hmstatus' value="+mstatus+">");
		    pw.println("<input type='submit' value='Continue'>");
		    pw.println("</form>");
		}
		else {
			pw.println("<form action='secondurl' method='post'>");
			pw.println("Spouse Name:<input type='text' name='st1'><br>");
			pw.println("No.of Children:<input type='text' name='st2'><br>");
			//Add the html form page as req hiden Component
			pw.println("<input type='hidden' name='fhname' value="+father+">");
			pw.println("<input type='hidden' name='phname' value="+person+">");
			pw.println("<input type='hidden' name='hage' value="+age+">");
			pw.println("<input type='hidden' name='hmstatus' value="+mstatus+">");
		    pw.println("<input type='submit' value='Continue'>");
		    pw.println("</form>");
		}
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
