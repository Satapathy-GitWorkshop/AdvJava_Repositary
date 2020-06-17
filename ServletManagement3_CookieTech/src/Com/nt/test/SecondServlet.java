package Com.nt.test;

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
		float income,tax=0.0f;
		Cookie cookie[]=null;
		String pname,fname,gender=null;
//Get PrintWriter		
		 pw=res.getWriter();
//Set Respnse ContentType
		 res.setContentType("text/html");
//Receive Form2 data Dynamically
	income=Float.parseFloat(req.getParameter("income"));
	tax=Float.parseFloat(req.getParameter("tax"));
//Get the Cookie
		 cookie=req.getCookies();
//Get the Cookie  Value
		 pname=cookie[0].getValue();
		 fname=cookie[1].getValue();
		 gender=cookie[2].getValue();
//Diplay The Receive Cookie/Form2 Data in Client side
pw.println("<h1 style='color:red;text-algn:center:'>Cookie Value Are</h1>")	;
pw.println("<b>Candidate Name:"+pname+"<br>");
pw.println("<b>Father Name:"+fname+"<br>");
pw.println("<b>Gender:"+gender+"<br>");
pw.println("<b>Income:"+income+"<br>");
pw.println("<b>Tax:"+tax+"<br>");
//Closing the Stream
pw.close();


	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {	
		doGet(req, res);
	}

}
