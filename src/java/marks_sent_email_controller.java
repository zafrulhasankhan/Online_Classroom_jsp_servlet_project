/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.to;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/marks_sent_email_controller"})
public class marks_sent_email_controller extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String to=stuemails;
         
        String subject="Classwork marks !";
        
        String msg = String.format("course code: %s,classwork no. :%s,Your ID :%s,Your marks:%s",code,classworkno,stuids,marks );
        
        Mailer.send(user,pass,to,subject,msg);

        out.print("message has been successfully...");
        out.close();

        
    }

   
}
}