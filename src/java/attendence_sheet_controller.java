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
@WebServlet(urlPatterns = {"/attendence_sheet_controller"})
public class attendence_sheet_controller extends HttpServlet {

   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String code = request.getParameter("code");
        System.out.println(code);
        //String cod="ict-2207";
        ArrayList<people> attendlist = new ArrayList<people>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from student_list  where course_code=?  ");
            ps.setString(1, code);
            ResultSet rs=ps.executeQuery();
             while(rs.next()){
                
                people po =new people();
                
                po.setStudentlist(rs.getString("name"));
               po.setClass_id(rs.getString("id"));
               
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                attendlist.add(po);
                
                request.setAttribute("attendlist",attendlist);
                request.setAttribute("code",code);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(attendence_sheet_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(attendence_sheet_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
         request.getRequestDispatcher("attendence_sheet.jsp").forward(request,response);
    }

}