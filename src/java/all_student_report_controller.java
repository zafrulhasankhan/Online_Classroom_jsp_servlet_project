/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.people;
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

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/all_student_report_controller"})
public class all_student_report_controller extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String code = request.getParameter("code");
      ArrayList<people> peoplelist = new ArrayList<people>();
        try {
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from attendence_list  where course_code=? ");
            ps1.setString(1, code);
            ResultSet rs=ps1.executeQuery();
             while(rs.next()){
                
                people po =new people();
                
                po.setStudentlist(rs.getString("name"));
               po.setClass_id(rs.getString("class_id"));
               po.setEmail(rs.getString("present"));
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                peoplelist.add(po);
                
                request.setAttribute("peoplelist",peoplelist);
                request.setAttribute("code",code);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(all_student_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(all_student_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
