/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(urlPatterns = {"/teacher_register_controller"})
@MultipartConfig(maxFileSize =32354432)
public class teacher_register_controller extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
       String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
       String email = request.getParameter("email");
       String name = request.getParameter("name");
       Part part = request.getPart("image");
      String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
        System.out.println(pass);
       
       if(pass == null ? repass == null : pass.equals(repass)){ 
       try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(email) FROM teacher_list WHERE email=? ),\"post not yet\") as email");
            ps0.setString(1, email);
           
            ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int stuno = Integer.parseInt(rs0.getString(1));
                if(stuno==0){
                
                
           PreparedStatement  ps = DBConnection.getConnection().prepareStatement("insert into teacher_list values(?,?,?,?,?) ");
           ps.setString(1, name);
           ps.setString(2, email);
           ps.setString(3, pass);
           InputStream is = part.getInputStream();
              ps.setBlob(4, is);
                ps.setString(5, filename);   
           int n=ps.executeUpdate();
                
		if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        /*out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Yes' ,  'successfully registered !' ,  'success' );");
			out.println("});");
			out.println("</script>");*/
			 out.println("<script type=\"text/javascript\">");
                         out.println("alert('Yes, successfully registered');");
                         out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("teacher_login_form.jsp");
			rd.include(request, response);
                        
                        
		}
                else{
			out.println("<script type=\"text/javascript\">");
                         out.println("alert('Incorrect id or password');");
                         out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("teacher_register.jsp");
			rd.include(request, response);
		}
                }
                else{
                    out.println("<script type=\"text/javascript\">");
                         out.println("alert('Email already exists');");
                         out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("teacher_register.jsp");
			rd.include(request, response);
                }
            }
       } catch (SQLException ex) {
           Logger.getLogger(teacher_register_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(teacher_register_controller.class.getName()).log(Level.SEVERE, null, ex);
       }
       }
       else{
                         out.println("<script type=\"text/javascript\">");
                         out.println("alert('Entered Both password not same ');");
                         out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("teacher_register.jsp");
			rd.include(request, response);
       }

    
}
}