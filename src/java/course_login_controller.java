/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.post;
import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/course_login_controller"})
public class course_login_controller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // String code = request.getParameter("code");
       HttpSession session = request.getSession();
       String pass = request.getParameter("pass");
        System.out.println(pass);
       String email = request.getParameter("email");
       String spass = request.getParameter("spass");
        System.out.println(pass);
       
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE password=?),\"post not yet\") as course_code ");
            ps0.setString(1, pass);
             
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int count = Integer.parseInt(rs0.getString(1));
                if(count==0){
                    
                    String ncerror = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Oh,sorry!</strong> This Pin number does not march any course !Try again...  \n" +
"            </div>";
                    request.setAttribute("pass", spass);
                    request.setAttribute("email", email);
                    request.setAttribute("ncerror", ncerror);
                    session.setAttribute("npu", "no");
                    request.getRequestDispatcher("course_login_form.jsp").forward(request,response); 
                }
                else{
                
            /*PreparedStatement  ps0 = DBConnection.getConnection().prepareStatement("Select * from add_course  where  password=? ");
            ps0.setString(1, pass);
             ResultSet rs0 = ps0.executeQuery();
           if(rs0.next()){
               String code = rs0.getString("course_code");
               System.out.println(code);*/
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from add_course  where  password=? ");
           // ps.setString(1, code);
            ps.setString(1, pass);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               String code = rs.getString("course_code");
               // String pass1 = rs.getString("password");
               //request.setAttribute("code", code);
               System.out.println(code+spass+email+"dkj");
               getServletContext().setAttribute("code",code);
               getServletContext().setAttribute("email",email);
               getServletContext().setAttribute("spass",spass);
               RequestDispatcher rd=getServletContext().getRequestDispatcher("/student_post_list_controller");
               rd.forward(request,response);
                 
           
           }
           else
           {
              String error = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; \">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:red;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Oh,sorry!</strong> Incorrect course code Or password !Try again...  \n" +
"            </div>";
            request.setAttribute("errorMsg",error);
         request.getRequestDispatcher("course_login_form.jsp").forward(request,response); 
           }
                }
            }
                   
        } catch (SQLException ex) {
            Logger.getLogger(course_login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(course_login_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
                 
    }
}
    
    

   

