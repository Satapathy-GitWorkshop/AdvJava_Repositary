package com.nt.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;


@WebServlet(value="/Resource_Downloading")
public class Resource_Downloading extends HttpServlet {   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		File file=null;	
		String fname=null;
		ServletContext sc=null;
		String mimetype=null;
		InputStream is=null;
		OutputStream os=null;
		//Read the Form data on Hyperlink And To be Downloaded
		fname=req.getParameter("filename");
		//Create Fil Object and loacting the file to be Download
		file=new File("C:/files_upload/"+fname);
		//get the length of the file
		res.setContentLengthLong(file.length());
		//Get ServletContext Object
		sc=getServletContext();
		//get MIME type of the file
		mimetype=sc.getMimeType("C:/files_upload/"+fname);
		res.setContentType(mimetype!=null?mimetype:"application/octet-stream");
		//Create InputStream pointing to the file to be Download
		is= new FileInputStream(file);
		//Create Output stream stream pointing to response object
		os= res.getOutputStream();
		//set values to content-Disposition header
		res.setHeader("Content-Disposition","attachment;fileName="+fname);
		//Copy the File Content to Res Object
		IOUtils.copy(is,os);
		//close Stream 
		is.close();
		os.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Resource_Downloading.doPost()");
		doGet(req, res);
	}

}
