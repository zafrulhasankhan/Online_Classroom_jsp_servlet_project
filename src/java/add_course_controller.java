/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.DBConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/add_course_controller"})
public class add_course_controller extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tecname = request.getParameter("tecname");
       String name = request.getParameter("name");
       String code = request.getParameter("code");
       String pass = request.getParameter("pass");
        System.out.println(name);
       
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into add_course values(course_id,?,?,?,?)");
            ps.setString(1, tecname);
            ps.setString(2, name);
              ps.setString(3, code);
              ps.setString(4, pass);
               ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(add_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
