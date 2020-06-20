/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/create_classwork_controller"})
@MultipartConfig(maxFileSize = 16177216)
public class create_classwork_controller extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String code=request.getParameter("code");
	        String body=request.getParameter("body");
                String dl=request.getParameter("date");
                String name= request.getParameter("filename");
		Part part = request.getPart("image");// we get path of the image
                
		      System.out.println(code);
                
        try {    
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into classwork values(?,?,?,?,?)");
            ps.setString(1, code);
		ps.setString(2, body);
                ps.setString(3, dl);
                ps.setString(4, name);
		InputStream is = part.getInputStream();
			    ps.setBlob(5, is);
                
                
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
			
			RequestDispatcher rd = request.getRequestDispatcher("create_classwork_form.jsp");
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
			
			RequestDispatcher rd = request.getRequestDispatcher("create_classwork_form.jsp");
			rd.include(request, response);
		}
        } catch (SQLException ex) {
            Logger.getLogger(create_classwork_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(create_classwork_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

