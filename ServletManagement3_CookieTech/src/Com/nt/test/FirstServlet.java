package Com.nt.test;

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
		Cookie cookie1,cookie2,cookie3=null;
//Get PrintWriter
		pw=res.getWriter();
//Set Response Content Type
		res.setContentType("text/html");
//Receive Form Component
		String pname=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String gender=req.getParameter("gender");
//Create cookie Based On the Receive Component
		cookie1=new Cookie("pname",pname);
		cookie2=new Cookie("fname",fname);
		cookie3=new Cookie("gender",gender);
//Add Cookie to Response Object;
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		res.addCookie(cookie3);
//Generate Dynamic Form Component 
		pw.println("<h1 style='color:red;text-align:center:'>Provide Income Details</h1>");
		pw.println("<form action='secondurl' method='post'>");
		pw.println("<table border='0'bgcolor='cyan align='center'>");
		pw.println("<tr><td>Anual Income:</td><td><input type='text' name='income'></td></tr>");
		pw.println("<tr><td>Tax:</td><td><input type='text' name='tax'></td></tr>");
		pw.println("<tr><td><input type='submit' value='submit'></td><td><input type='reset' value='cancel'></td></tr>");
		pw.println("</table></form>");
//Close the Stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
