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
        String code = request.getParameter("code");
       String pass = request.getParameter("pass");
       String email = request.getParameter("email");
       String spass = request.getParameter("spass");
        System.out.println(pass);
       
        try {
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from add_course  where course_code=? and password=? ");
            ps.setString(1, code);
            ps.setString(2, pass);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               String code1 = rs.getString("course_code");
                String pass1 = rs.getString("password");
               //request.setAttribute("code", code);
               
               getServletContext().setAttribute("code",code);
               getServletContext().setAttribute("email",email);
               getServletContext().setAttribute("spass",spass);
               RequestDispatcher rd=getServletContext().getRequestDispatcher("/select_course_controller");
               rd.forward(request,response);
                 
           }else
           {
              String error = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; \">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:red;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Oh,sorry!</strong> Incorrect course code Or password !Try again...  \n" +
"            </div>";
            request.setAttribute("errorMsg",error);
         request.getRequestDispatcher("course_login_form.jsp").forward(request,response); 
           }
                    
        } catch (SQLException ex) {
            Logger.getLogger(course_login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(course_login_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
                 
    }
    
    

   
}
