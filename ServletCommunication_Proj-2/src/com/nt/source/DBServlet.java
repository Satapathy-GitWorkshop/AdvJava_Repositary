package com.nt.source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/DBServlet")
public class DBServlet extends HttpServlet {
	Connection con ;
	PreparedStatement ps;
	ResultSet rs=null;
	RequestDispatcher rd=null,rd1=null,rd2=null;
	public void init() {
		try {
			//Register JDBC DRiver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //Establish The Connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","9658");
			 //create PreaparedStatement Object
			 ps=con.prepareStatement("SELECT PTNO,PTNAME,PTADDS FROM PATIENT WHERE PTNO=?");
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//init()

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			
			//General Setting
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			//Set Header Content
			rd1=req.getRequestDispatcher("/Header");
			rd1.include(req,res);
			//Read form Data
			int no=Integer.parseInt(req.getParameter("tptno"));
			//set Paramater Values to Query Parameter
			if(ps!=null) {
			ps.setInt(1,no);
			//Execute the Sql Query
			 rs=ps.executeQuery();
			}//if
			//Process The ResultSet
			
			if(rs.next()) {
				pw.println("<br>Patient No::"+rs.getInt(1));
				pw.println("<br>Patient Name::"+rs.getString(2));
				pw.println("<br>Patient Address::"+rs.getString(3));			
			}//innerif
			else {
				pw.println("<br>No Patient Found");
			//Error Servlet
				rd=req.getRequestDispatcher("/Errror_Servlet");	
				rd.forward(req,res );
				}		
		//set FooterContent
			rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req,res);
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet(-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}//doPost(-)
	public void destroy() {
		try {
			if(ps!=null)
				ps.close();
		}//try
	catch(Exception e1) {
		e1.printStackTrace();
	}
		try {
			if(con!=null)
				con.close();
		}//try
		catch(Exception e2) {
			e2.printStackTrace();
		}
	}//destroy()
}//class