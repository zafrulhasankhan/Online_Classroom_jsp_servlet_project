/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.DBConnection;
import java.io.InputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(name = "post_form_controller", urlPatterns = {"/post_form_controller"})
@MultipartConfig(maxFileSize = 16177216)
public class post_form_controller extends HttpServlet {
//private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		Part part = request.getPart("image");// we get path of the image
                String body = request.getParameter("body");
		// now we take image file from the given path thats why we use file input stream
		//FileInputStream fis=new FileInputStream(new File(image));
		// fis contains bits and binaries of the image
		// now we store these data into data base.
		//Connection con=DBConnection.getConnection();
		try {
		PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into post values(?,?,?,?,?)");
		ps.setString(1, code);
		ps.setString(2, name);
		InputStream is = part.getInputStream();
			    ps.setBlob(3, is);
                ps.setString(4, body);
                java.util.Date now = new java.util.Date();
java.sql.Timestamp c = new java.sql.Timestamp(now.getTime());
             ps.setTimestamp(5, c);
		int n=ps.executeUpdate();
		if(n>0) {
			response.getWriter().println("Successfully uploaded");
                        
                        
		}
		}catch(Exception e) {System.out.println(e);}
	}

}