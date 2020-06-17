package com.nt.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			                         throws ServletException, IOException {
		PrintWriter pw=null;
		String  name,age,adds,gender=null;
		HttpSession session=null;
		//General Setting
		pw=res.getWriter();
		res.setContentType("text/html");
//Receive Form Data  ----
	name=req.getParameter("name");
	age=req.getParameter("age");
	gender=req.getParameter("gender");
	adds=req.getParameter("adds");
//Crreate Session Object
	session=req.getSession();
//Set form value to SessionAttribute
	session.setAttribute("name",name);
	session.setAttribute("age",age);
	session.setAttribute("gender",gender);
	session.setAttribute("adds",adds);
//Create Form2 data through dynamic componnet
	pw.println("<h1 style='red';tex-align:center>Second Form Component</h1>");
	pw.println("<form action='secondurl' method='post'>");
	pw.println("Why u Want to Marry:<input type='text' name='st1'><br>");
	pw.println("When did u Want To Marry:<input type='text' name='st2'><br>");
	pw.println("<input type='submit' value='Continue'>");
	pw.println("</form>");
	
//Get Sesion id
	String id=session.getId();
	pw.println("<b>The Seeion id:"+id);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
