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
@WebServlet(urlPatterns = {"/create_classwork_controller"})
@MultipartConfig(maxFileSize = 16177216)
public class create_classwork_controller extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tecname="";
                String course_name="";
        String user="";
                String pass="";
         PrintWriter out = response.getWriter();
                String cw_no=request.getParameter("cw_no");
                String code=request.getParameter("code");
	        String body=request.getParameter("body");
                String dl=request.getParameter("date");
                Part part = request.getPart("image");// we get path of the image
                String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
		      System.out.println(filename);
                  
                
           
             PreparedStatement ps0;
        try {
            ps0 = DBConnection.getConnection().prepareStatement(" SELECT ifnull((SELECT COUNT(course_code) FROM classwork WHERE classworkno=?),\"0\" ) as classworkno");
            ps0.setString(1, cw_no);
            ResultSet rs =ps0.executeQuery();
                if(rs.next()){
                    //String clasno = rs.getString("class_no");
                   // System.out.println(clasno);
                   int clasno=Integer.parseInt(rs.getString(1));
                    if(clasno!=0)
                    {
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Classwork No. Already Exists !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
                        
                        request.getRequestDispatcher("create_classwork_form.jsp").include(request,response);
                    }
                    else{
                        try {  
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into classwork values(?,?,?,?,?,?)");
            
            ps.setString(1, cw_no);
            ps.setString(2, code);
		ps.setString(3, body);
                ps.setString(4, dl);
                ps.setString(5, filename);
		InputStream is = part.getInputStream();
			    ps.setBlob(6, is);
                
                
		int n=ps.executeUpdate();
               
		if(n>0) {
                    
                    PreparedStatement ps3=DBConnection.getConnection().prepareStatement("select * from add_course where course_code=?");
            ps3.setString(1, code);
            ResultSet rs3 = ps3.executeQuery();
           if(rs3.next()){
              String email = rs3.getString("teacher_email");
              user=email;
              PreparedStatement ps4=DBConnection.getConnection().prepareStatement("select * from email where email=?");
              ps4.setString(1, email);
            ResultSet rs1 = ps4.executeQuery();
            if(rs1.next()){
                 AESEncryptionDecryption ae = new AESEncryptionDecryption();
              String pass1 = rs1.getString("pass");
              String decryp_pass= ae.decrypt(pass1, email);
               pass=decryp_pass;
              
            }
           }
            PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=?");
                        ps5.setString(1, code);
                        ResultSet rs5 = ps5.executeQuery();
 
       if(rs5.next()){
         tecname=rs5.getString("teacher_name");
          course_name = rs5.getString("course_name");
       }
           
                        PreparedStatement ps6 = DBConnection.getConnection().prepareStatement("select * from student_list where course_code=?");
                        ps6.setString(1, code);
                        ResultSet rs6 = ps6.executeQuery();
 
       while(rs6.next()){
        
        String email = rs6.getString("email");
        String stuname = rs6.getString("name");
       
        System.out.println(email);
        
        String to=email;
         
        String subject=" Classwork Announcement !";
        
        String msg = String.format("Hi %s , %s posted a new classwork in %s . %n%nClasswork: %s  %nUploaded file: '%s'%n%nDeadline:%s.......visit classroom to see more",stuname,tecname,course_name,body,filename,dl);
        
        Mailer.send(user,pass,to,subject,msg);
       }
                    
                    
			//response.getWriter().println("Successfully uploaded");
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Yes' ,  'successfully created classwork !' ,  'success' );");
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
                
        } catch (SQLException ex) {
            Logger.getLogger(create_classwork_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(create_classwork_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
              
               
            
    }
}

