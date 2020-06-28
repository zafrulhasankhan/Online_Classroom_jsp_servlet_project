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
import static java.lang.System.out;
import java.nio.file.Paths;
import javax.servlet.RequestDispatcher;
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
		
		Part part = request.getPart("image");// we get path of the image
                String body = request.getParameter("body");
               String name=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
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
                PrintWriter out = response.getWriter();
		if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Yes' ,  'successfully sent and save post !' ,  'success' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("post_form.jsp");
			rd.include(request, response);
                        
                        
		}
                else{
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'incorrect id or password !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("post_form.jsp");
			rd.include(request, response);
		}
		}catch(Exception e) {System.out.println(e);}
	}

}