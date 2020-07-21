/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/student_list_controller"})
@MultipartConfig(maxFileSize =32354432)
public class student_list_controller extends HttpServlet {

 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String name = request.getParameter("name");
      Part part = request.getPart("image");
      String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
       String email = request.getParameter("email");
       String id = request.getParameter("id");
       String code = request.getParameter("code");
       String pass = request.getParameter("pass");
       String repass = request.getParameter("repass");
       PrintWriter out = response.getWriter();
       if(pass == null ? repass == null : pass.equals(repass)){
        try {
            PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE   course_code=?),\"post not yet\") as course_code");
              ps5.setString(1, code);
            ResultSet rs5 =   ps5.executeQuery();
           
            if(rs5.next()){
                int count = Integer.parseInt(rs5.getString(1));
                
            if(count!=0){
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(id) FROM student_list WHERE (course_code=? and id=? ) or (course_code=? and email=?)),\"post not yet\") as id");
            ps0.setString(1, code);
            ps0.setString(2, id);
             ps0.setString(3, code);
            ps0.setString(4, email);
            ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int stuno = Integer.parseInt(rs0.getString(1));
                if(stuno==0){
                
            /*PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(pass) FROM student_list WHERE   email=?),\"post not yet\") as id");
              ps5.setString(1, email);
            ResultSet rs5 =   ps5.executeQuery();
           
            if(rs5.next()){
                int count = Integer.parseInt(rs5.getString(1));
                
            if(count==0){*/
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into student_list values(?,?,?,?,?,?,?)");
             ps.setString(1, name);
              ps.setString(2, email);
              ps.setString(3, id);
              ps.setString(4, code);
              ps.setString(5, pass);
              InputStream is = part.getInputStream();
              ps.setBlob(6, is);
                ps.setString(7, filename);             
              int n=ps.executeUpdate();
                
		if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  'successfully !' ,'registered',  'success' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("student_login.jsp");
			rd.include(request, response);
                        
                        
		}
                else{
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'something went wrong !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
            }
            /*else{
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'ohh sorry !' ,  ' password match with other user..change and try again' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
            }
            }
            }*/
            else{
                out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( '  Already Exists !' ,  'change email or student id ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
            }
            }
        }
        else{
                 out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( '  oh sorry !' ,  'There is no account as this course code ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
                }
       }
              
                    } catch (SQLException ex) {
            Logger.getLogger(student_list_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(student_list_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       //request.getRequestDispatcher("course_login_form.jsp").forward(request,response);
       else{
           out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'password not same !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
       }
    }

    
}
