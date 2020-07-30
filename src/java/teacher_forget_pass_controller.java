/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/teacher_forget_pass_controller"})
public class teacher_forget_pass_controller extends HttpServlet {

    
   
   

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String stupass1=request.getParameter("pass");
                String stupass2= request.getParameter("repass");
              // System.out.println(stupass1);
        
         String user="";
        String pass="";
        String stuid="";
        String stuname="";
        String stupass="";
        String stuid3="";
        String stuname3="";
        String stupass3="";
     
         String email= request.getParameter("email");
         
        //String code1="ict-3109";
        try {
            
              user=email;
              PreparedStatement ps1=DBConnection.getConnection().prepareStatement("select * from email where email=?");
              ps1.setString(1, email);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                 AESEncryptionDecryption ae = new AESEncryptionDecryption();
              String pass1 = rs1.getString("pass");
              String decryp_pass= ae.decrypt(pass1, email);
               pass=decryp_pass;
               
            }
           
           PrintWriter out = response.getWriter();
           //System.out.println(stupass1);
           //System.out.println(stupass2);
           if("".equals(request.getParameter("pass"))){
              PreparedStatement ps5=DBConnection.getConnection().prepareStatement("select * from teacher_list where email=?");
              
               ps5.setString(1, email);
               ResultSet rs4 = ps5.executeQuery();
               if(rs4.next()){
                   stupass3=rs4.getString("pass");
                   stuname3=rs4.getString("name");
                   
                   String to=email;
                   
                   String subject="Forget password !";
                   
                   String msg = String.format("%nYour name:%s%n%nyour password:%s%n%n",stuname3,stupass3 );
                   
                   Mailer.send(user,pass,to,subject,msg);
                   out.println("<script type=\"text/javascript\">");
                         out.println("alert('sucesssfully! password  sent by email');");
                         out.println("</script>");
                       
                   request.getRequestDispatcher("forget_pass_teacher.jsp").include(request, response);
               }
           }
               else{ 
               if(stupass1 == null ? stupass2 == null : stupass1.equals(stupass2)){
                   PreparedStatement ps4=DBConnection.getConnection().prepareStatement("update teacher_list set pass=? where   email=? ");
                   ps4.setString(1, stupass1);
                   
                   
                   ps4.setString(2, email);
                   ps4.executeUpdate();
                   
                   
                   
                   PreparedStatement ps3=DBConnection.getConnection().prepareStatement("select * from teacher_list where  email=?");
                   
                   ps3.setString(1, email);
                   ResultSet rs2 = ps3.executeQuery();
                   if(rs2.next()){
                       stupass=rs2.getString("pass");
                       stuname=rs2.getString("name");
                       
                       String to=email;
                       
                       String subject="Forget password !";
                       
                       String msg = String.format("%nYour name:%s%n%nyour password:%s%n%n",stuname,stupass );
                       
                       Mailer.send(user,pass,to,subject,msg);
                       out.println("<script type=\"text/javascript\">");
                         out.println("alert('sucesssfully! password reset and sent by email');");
                         out.println("</script>");
                       request.getRequestDispatcher("forget_pass_teacher.jsp").include(request, response);
                   }
               }
               else{
                   out.println("<script type=\"text/javascript\">");
                         out.println("alert('Set both password not same');");
                         out.println("</script>");
                       request.getRequestDispatcher("forget_pass_teacher.jsp").include(request, response);
               }
               }
           
           
           
            
        } catch (SQLException ex) {
            Logger.getLogger(attendance_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(attendance_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        

       
    

  

    }

    
    

}
