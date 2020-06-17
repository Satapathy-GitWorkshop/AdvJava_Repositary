package com.nt.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cookie1,cookie2,cookie3,cookie4=null;
		//Get PrintWriter Obkect
		pw=res.getWriter();
		//Set Response Content Type
		res.setContentType("text/html");
//Create Two Types Cookie
		//In memory Cookie
		cookie1=new Cookie("Name","Sauarav");
	    cookie2=new Cookie("Title", "Satpathy");
	    //Persitance Cookie
	    cookie3=new Cookie("Age","22");
	    cookie4=new Cookie("Adds","Odisha");
	    cookie3.setMaxAge(1250);
	    cookie4.setMaxAge(1200);
//Set Cookie to response 
	    res.addCookie(cookie1);
	     res.addCookie(cookie2);
	    res.addCookie(cookie3);
	    res.addCookie(cookie4);
//Checkig Message
	    pw.println("<br><b>Cookie Are sucessfully inserted");
//Closing the Stream
	    pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
