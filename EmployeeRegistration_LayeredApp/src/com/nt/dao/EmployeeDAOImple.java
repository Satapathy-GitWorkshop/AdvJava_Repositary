package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImple implements EmployeeDAO {
private static final String  INSERT_EMPLOYEE_QUERY="INSERT INTO LAYERED_EMPLOYEE VALUES(EMPNO_SEQ.NEXTVAL,?,?,?,?,?,?)";
	
	//helper methods
	private Connection  getPooledJdbcConnection()throws Exception{
		Connection con=null;
		//register JDBC driver s/w
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  //establish the connection
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		return con;
		
	}//method
	

	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
	    //get Pooled jdbc con object
		con=getPooledJdbcConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_EMPLOYEE_QUERY);
		//set values to query params
		ps.setString(1,bo.getEname() );
		ps.setString(2,bo.getEadd());
		ps.setDate(3,bo.getDoj());
		ps.setFloat(4, bo.getBasicSalary());
		ps.setFloat(5,bo.getGrossSalary());
		ps.setFloat(6, bo.getNetSalary());
		//execute the SQL Query
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}


}
