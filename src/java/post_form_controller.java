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
import static java.lang.ProcessBuilder.Redirect.to;
import java.nio.file.Paths;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(name = "post_form_controller", urlPatterns = {"/post_form_controller"})
@MultipartConfig(maxFileSize =32354432)
public class post_form_controller extends HttpServlet {
//private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
                //String code="ict-3109";
		String user="";
                String pass="";
		Part part = request.getPart("image");// we get path of the image
                String body = request.getParameter("body");
               String name=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
		
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
                      
           
                        PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from student_list,add_course where add_course.course_code=?");
                        ps1.setString(1, code);
                        ResultSet rs = ps1.executeQuery();
 
       while(rs.next()){
        String tecname=rs.getString("teacher_name");
        String email = rs.getString("email");
        String stuname = rs.getString("name");
        String course_name = rs.getString("course_name");
        System.out.println(email);
        
        String to=email;
         
        String subject=" Announcement !";
        
        String msg = String.format("Hi %s , %s posted a new announcement in %s . %n%nAnnouncement: %s  %n'%s' file has been uploaded.......visit classroom to see more",stuname,tecname,course_name,body,name);
        
        Mailer.send(user,pass,to,subject,msg);
        
        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Yes' ,  'successfully sent and save post !' ,  'success' );");
			out.println("});");
			out.println("</script>");
                        
    }
                        
		}
                else{
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'incorrect id or password !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			
		}
		}catch(Exception e) {System.out.println(e);}
                    
	}

}

