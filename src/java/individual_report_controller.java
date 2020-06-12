/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/individual_report_controller"})
public class individual_report_controller extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String classid = request.getParameter("classid");
        String code = request.getParameter("code");
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("SELECT COUNT(Attendence) FROM `attendence_list` WHERE course_code=?  and class_id=? and Attendence='present'");
            ps.setString(1, code);
              ps.setString(2, classid);
              ResultSet rs =   ps.executeQuery();
              if(rs.next()){
                 int present =Integer.parseInt(rs.getString(1));
                  System.out.println(present);
                 request.setAttribute("present",present);
                // request.getRequestDispatcher("individual_report_result.jsp").forward(request,response);
                
             }
              
              
              PreparedStatement ps2= DBConnection.getConnection().prepareStatement("SELECT class_no FROM `attendence_list` WHERE course_code=? order by class_no DESC LIMIT 1");
             ps2.setString(1, code);
             ResultSet rs2=ps2.executeQuery();
             if(rs2.next()){
                 int totalclass =Integer.parseInt(rs2.getString("class_no"));
               
                 System.out.println(totalclass);
                 
                request.setAttribute("totalclass", totalclass);
                 //request.getRequestDispatcher("individual_report_result.jsp").forward(request,response);
                
             }
             PreparedStatement ps3= DBConnection.getConnection().prepareStatement("SELECT student_name FROM `attendence_list` WHERE class_id=?");
             ps3.setString(1, classid);
             ResultSet rs3=ps3.executeQuery();
             if(rs3.next()){
                
               
                 String name = rs3.getString("student_name");
                 request.setAttribute("name", name);
                 
                request.setAttribute("classid",classid);
                //request.getRequestDispatcher("individual_report_result.jsp").forward(request,response);
                
             }
            } catch (SQLException ex) {
            Logger.getLogger(individual_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(individual_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("individual_report_result.jsp").forward(request,response);
       
       
    }
}
   
