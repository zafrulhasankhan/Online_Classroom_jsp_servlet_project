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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/attendance_sent_email_controller"})
public class attendance_sent_email_controller extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String user="";
        String pass="";
        String code1= request.getParameter("code");
        String afilename= request.getParameter("afilename");
        String tecname="";
        try {
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from add_course where course_code=?");
            ps.setString(1, code1);
            ResultSet rs = ps.executeQuery();
           if(rs.next()){
              String email = rs.getString("teacher_email");
               tecname=rs.getString("teacher_name");
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
        
       String stuids="";
       String stuemails="";
       String stunames="";
       String marks="";
       String presents="";
       String totals="";
       String pers="";
String stuname[]=request.getParameterValues("stuname");
String stuid[]=request.getParameterValues("stuid");
String stuemail[]=request.getParameterValues("stuemail");
String present[]=request.getParameterValues("present");
String total[]=request.getParameterValues("total");
String per[]=request.getParameterValues("per");
for(int i=0;i<stuid.length;i++){
        
        stuids=stuid[i];
        stuemails=stuemail[i];
        stunames=stuname[i];
        presents=present[i];
        totals=total[i];
        pers=per[i];
        String code= request.getParameter("code");
        System.out.println(stuemails);
        System.out.println();
    
        response.setContentType("text/html");
        
        String to=stuemails;
         
        String subject="Attendance reports !";
        
        String msg = String.format("course code: %s,Your ID :%s, Name: %s ,presented class:%s,Total class:%s,Percentage:%s",code,stuids,stunames,presents,totals,pers );
        
        Mailer.send(user,pass,to,subject,msg);

        
        //RequestDispatcher rd = request.getRequestDispatcher("newjsp.jsp");
                //rd.forward(request, response);
    }
HttpSession session = request.getSession();
  String ssa = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Successfully  !</strong> sent Attendance to all of students ...  \n" +
"            </div>";
                     request.setAttribute("ssa", ssa);
                     session.setAttribute("email", user);
                            session.setAttribute("name", tecname);
                            request.setAttribute("filename", afilename);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
                     
    }

}


