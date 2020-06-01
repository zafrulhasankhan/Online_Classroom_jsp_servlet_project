/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/student_list_controller"})
public class student_list_controller extends HttpServlet {

 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String name = request.getParameter("name");
       String email = request.getParameter("email");
       String id = request.getParameter("id");
       String code = request.getParameter("code");
       String pass = request.getParameter("pass");
       
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into student_list values(?,?,?,?,?)");
             ps.setString(1, name);
              ps.setString(2, email);
              ps.setString(3, id);
              ps.setString(4, code);
              ps.setString(5, pass);
               ps.executeUpdate();       
                    } catch (SQLException ex) {
            Logger.getLogger(student_list_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(student_list_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       request.getRequestDispatcher("course_login_form.jsp").forward(request,response);
    }

    
}
