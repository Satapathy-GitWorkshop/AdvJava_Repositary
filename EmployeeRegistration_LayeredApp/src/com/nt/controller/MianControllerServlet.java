package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImple;
import com.nt.vo.EmployeeVO;

@WebServlet(value="/Controller")
public class MianControllerServlet extends HttpServlet {
	private EmployeeMgmtService service;
	@Override
	public void init() throws ServletException{
		service=new EmployeeMgmtServiceImple();
	}
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Create Vo Class Object
		EmployeeVO vo = null;
		EmployeeDTO dto= null;
		String result=null;
		PrintWriter pw= null;
		//Read From Data
		vo=new EmployeeVO();
		vo.setEname(req.getParameter("ename"));
		vo.setEadd(req.getParameter("eadd"));
		vo.setDoj(req.getParameter("doj"));
		vo.setBasicSalary(req.getParameter("basicSalary"));
		//create PrintWriter 
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		//Convert VO--DTO
		dto= new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setEadd(vo.getEadd());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		dto.setDoj(java.sql.Date.valueOf(vo.getDoj()));
		//Use Service class 
		 try {
			 result=service.registerEmployee(dto);
			 pw.println("<h1 style='color:red;text-align:center'>Result :: "+result+"</h1>");
		 }//try
		 catch(Exception e) {
			 pw.println("<h1>Internal Problem ---- Try Again</h1>");
			 e.printStackTrace();
		 }
		//add hyperlink
		 pw.println("<br><br> <a href='employee_register.html'>home</a>");
		 //close stream
		 pw.close();
		
	}
		

	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}
	@Override
	public void destroy() {
	service=null;
	}

}


