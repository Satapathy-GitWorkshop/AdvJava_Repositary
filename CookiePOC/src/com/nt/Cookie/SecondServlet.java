package com.nt.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {       
    
   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cookie[]=null;
		pw=res.getWriter();
		res.setContentType("text/html");
//Recevie cookie/req1 data from ServletOne
		cookie=req.getCookies();
//Print The into Dynamic form Pages
	if(cookie!=null) {
		pw.println("<table border='1' bgclor='red'>");
		pw.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
		for(Cookie ck:cookie) {
			pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		}//foreach loop
		pw.println("</table>");
	}//if
	else {
		pw.println("<br><b>No Cookie  Avalble</b>");
	}
	//Close The Stream 
	pw.close();
		
	}//doGet(-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
