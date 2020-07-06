/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.to;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/marks_sent_email_controller"})
public class marks_sent_email_controller extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
         String user="";
        String pass="";
        String code1= request.getParameter("code");
        //String code1="ict-3109";
        try {
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from add_course where course_code=?");
            ps.setString(1, code1);
            ResultSet rs = ps.executeQuery();
           if(rs.next()){
              String email = rs.getString("teacher_email");
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
           }
        } catch (SQLException ex) {
            Logger.getLogger(attendance_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(attendance_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       String marks="";
       String stuids="";
       String stuemails="";
String mark[]=request.getParameterValues("mark");
String stuid[]=request.getParameterValues("stuid");
String stuemail[]=request.getParameterValues("stuemail");
for(int i=0;i<stuid.length;i++){
        marks=mark[i];
        stuids=stuid[i];
        stuemails=stuemail[i];
        String code= request.getParameter("code");
        String classworkno = request.getParameter("workno");
        System.out.println(stuids);
            try {
                PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(mark) FROM classwork_mark WHERE classworkno=? and course_code=? AND student_id=?),\"post not yet\") as mark");
                ps0.setString(1, classworkno);
                ps0.setString(2, code);
                ps0.setString(3, stuids);
                ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int stuno = Integer.parseInt(rs0.getString(1));
                if(stuno==0){
                
                PreparedStatement  ps = DBConnection.getConnection().prepareStatement("insert into classwork_mark values(?,?,?,?,?) ");
                ps.setString(1, classworkno);
                ps.setString(2, code);
                ps.setString(3, stuids);
                ps.setString(4, stuemails);
                ps.setString(5, marks);
                ps.executeUpdate();
                
                 response.setContentType("text/html");
        
        String to=stuemails;
         
        String subject="Classwork marks !";
        
        String msg = String.format("course code: %s,classwork no. :%s,Your ID :%s,Your marks:%s",code,classworkno,stuids,marks );
        
        Mailer.send(user,pass,to,subject,msg);
        
                
                        //getServletContext().setAttribute("code",code);
               //getServletContext().setAttribute("classworkno",classworkno);
               //request.getRequestDispatcher("course_login_form.jsp").forward(request,response); 
               //RequestDispatcher rd=getServletContext().getRequestDispatcher("/show_submitted_all_classwork_codewise");
               //rd.forward(request,response);
               out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Yes' ,  'successfully mark sent and save !' ,  'success' );");
			out.println("});");
			out.println("</script>");
                }
                else{
                   out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Yes' ,  'Already mark sent and save !' ,  'success' );");
			out.println("});");
			out.println("</script>");
                }
            }
            } catch (SQLException ex) {
                Logger.getLogger(marks_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(marks_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        

        
    }
 
   
}
}