package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletDB_IntiParam extends HttpServlet {
	Connection con;
	PreparedStatement ps;
	public void init() {
		try {
			System.out.println("ServletDB_IntiParam.init()");
			//Get Access to Servlet Config Object
			ServletConfig cg= getServletConfig();
			//Read init param value from web.xml
			String s1=cg.getInitParameter("driver");
			String s2=cg.getInitParameter("dburl");
			String s3=cg.getInitParameter("dbuser");
			String s4=cg.getInitParameter("dbpwd");
			//Create JDBC connection Object
			Class.forName(s1);
			con=DriverManager.getConnection(s2,s3,s4);
			//Create Preapared Statements Object
			ps=con.prepareStatement("select ptno,ptname,ptadds from patient where ptno=?");
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
	}//init
	
       
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    try {
	    	System.out.println("ServletDB_IntiParam.doGet()");
	    	//Read From Data from form page
	    	int no =Integer.parseInt(req.getParameter("tptno"));
	    	//Get printWriter Object
	    	PrintWriter pw= res.getWriter();
	    	//Set Response Content Type
	    	res.setContentType("text/html");
	    	//Set Value to Query Parameter
	    	ps.setInt(1,no);
	    	//Execute the Query
	    	ResultSet rs=ps.executeQuery();
	    	//Process The ResultSet Object
	    	if(rs!=null) {
	    		pw.println("<br>Patient No::"+rs.getInt(1));
				pw.println("<br>Patient Name::"+rs.getString(2));
				pw.println("<br>Patient Address::"+rs.getString(3));
	    	}//if
	    //Close ResultsetObject
	    	rs.close();
	    	//Close Stream Object
	    	pw.close();
	    }//try
	    catch (Exception e) {
			e.printStackTrace();
		}
	}//doGet(-)

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
 public void destroy() {
	 try {
		 if(ps!=null)
			 ps.close();
	 }
	 catch (Exception e1) {
		e1.printStackTrace();
	}
	 try {
		 if(con!=null)
			 con.close();
	 }
	 catch (Exception e2) {
		e2.printStackTrace();
	}
 }//destroy()
}//class
