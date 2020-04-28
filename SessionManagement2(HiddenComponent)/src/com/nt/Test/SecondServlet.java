package com.nt.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	   pw=res.getWriter();
	   res.setContentType("text/html");
	   //Receive The Html Form Page
	   String fname=req.getParameter("fhname");
	   String pname=req.getParameter("phname");
	   String page=req.getParameter("hage");
	   String pms=req.getParameter("hmstatus");
	   //Display The Receive Componnet
	   pw.println("<br>Html Form Data");
	   pw.println("<br>FatherName:"+fname);
	   pw.println("<br>PersonName:"+pname);
	   pw.println("<br>PersonAge:"+page);
	   pw.println("<br>MaritialStatus:"+pms);
	   //Display The 1st Servlet Value
	   pw.println("<br>FirstServetVAlue:"+req.getParameter("st1")+"<br>"+req.getParameter("st2"));
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
