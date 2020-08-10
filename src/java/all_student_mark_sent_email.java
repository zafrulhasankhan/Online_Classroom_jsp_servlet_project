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
@WebServlet(urlPatterns = {"/all_student_mark_sent_email"})
public class all_student_mark_sent_email extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String atecfile= request.getParameter("tecfile");
        String atecname= request.getParameter("tecname");
        String user="";
        String pass="";
       
        String code1= request.getParameter("code");
        System.out.println(code1);
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
       
       String stuids="";
       String stuemails="";
       String stunames="";
       String stumarks="";
       
        
String stuid[]=request.getParameterValues("stuid");
String stuname[]=request.getParameterValues("stuname");
String stuemail[]=request.getParameterValues("stuemail");
String stumark[]=request.getParameterValues("stumark");
for(int i=0;i<stuid.length;i++){
        
        stuids=stuid[i];
        stunames=stuname[i];
        stuemails=stuemail[i];
        stumarks=stumark[i];
        String code= request.getParameter("code");
         String cwno= request.getParameter("cw_no");
        
        response.setContentType("text/html");
        
        String to=stuemails;
        
        
        String subject="Casswork marks!";
        
        String msg = String.format("Hi %s%n%ncourse code: %s%n%nYour ID :%s%n%nclasswork no: %s%n%nYour Marks:%s",stunames,code,stuids,cwno,stumarks );
        
        Mailer.send(user,pass,to,subject,msg);

        
        //RequestDispatcher rd = request.getRequestDispatcher("newjsp.jsp");
                //rd.forward(request, response);
    }
 HttpSession session = request.getSession();
 session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                             session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "no");
String ssa = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Successfully  !</strong> sent marks to all of students ...  \n" +
"            </div>";
                     request.setAttribute("ssa", ssa);
                     session.setAttribute("email", user);
                            session.setAttribute("name", atecname);
                            request.setAttribute("filename", atecfile);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
   
    
        
    }

   // request.setAttribute("pass",code1);
//request.getRequestDispatcher("datefind.jsp").forward(request,response);
}
