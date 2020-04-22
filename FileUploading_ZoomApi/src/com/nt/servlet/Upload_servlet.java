package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;


@WebServlet(value="/uploadurl")
public class Upload_servlet extends HttpServlet {   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			                                          throws ServletException, IOException {
	      PrintWriter pw=null;
	      MultipartFormDataRequest nreq=null;
	      UploadBean bean=null;
	      Vector vector=null;
	      UploadParameters param=null;
	      
	      
	      
	      
	      pw=res.getWriter();
	      res.setContentType("text/html");
	      try {
	    	  //create MultiPartFormDataRequest
	    	  nreq=new MultipartFormDataRequest(req);
	    	  //Perform the Uploading
	    	  bean= new UploadBean();
	    	  bean.setFolderstore("C:/files_upload");
	    	  //Restriction
	    	  bean.setOverwrite(true);
	    	  bean.setMaxfiles(20);
	    	  bean.setFilesizelimit(20*1024*1024);
	    	  bean.setBlacklist("*.zip,*.pdf");
	    	  //upload File
	    	   bean.store(nreq);
	    	   pw.println("<h1 style='color:green'>File uploaded successfully</");
	    	 //Display The name of upload file
	    	   vector =bean.getHistory();
	    	   for(int i=0;i<vector.size();++i) {
	    		  param=(UploadParameters)vector.elementAt(i);
	    		   pw.println("<b> Files:"+param.getAltFilename()+"Size:"+param.getFilesize()+
	    				                   "Type:"+param.getContenttype()+"Info:"+param.getStoreinfo()+"</b>");
	          }
	      }
	    	catch(Exception e)   {
	    		pw.println("<h1 style='color:red' align='center'> Unable To Load File Please Try Again"+e.getMessage()+"</h1>");
	    	}
	      finally {
	    	  pw.println("<a href='upload.html'>Home</a>");
	      }
	}	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		doGet(req, res);
	}

}
