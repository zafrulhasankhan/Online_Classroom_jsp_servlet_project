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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.course;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/all_course_controller"})
public class all_course_controller extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ArrayList<course> course_list = new ArrayList<course>();
         
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select *from add_course");
            ResultSet rs =   ps.executeQuery();
            while(rs.next()){
                
                course u = new course();
               u.setId(rs.getInt("course_id"));
                u.setName(rs.getString("course_name"));
                u.setCode(rs.getString("course_code"));
               
                
                
                System.out.println(u);
                course_list.add(u);
                
                request.setAttribute("course_list",course_list);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(all_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(all_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("course_list.jsp").forward(request,response);
    }
    
}
