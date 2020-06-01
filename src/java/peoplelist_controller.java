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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/peoplelist_controller"})
public class peoplelist_controller extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        System.out.println(code);
        //String cod="ict-2207";
        ArrayList<people> peoplelist = new ArrayList<people>();
        try {
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from student_list  where course_code=? ");
            ps1.setString(1, code);
            ResultSet rs=ps1.executeQuery();
             while(rs.next()){
                
                people po =new people();
                
                po.setStudentlist(rs.getString("name"));
               po.setClass_id(rs.getString("id"));
               po.setEmail(rs.getString("email"));
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                peoplelist.add(po);
                
                request.setAttribute("peoplelist",peoplelist);
                
                
            }
             PreparedStatement ps2 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=? ");
             ps1.setString(1, code);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 
                 HttpSession session = request.getSession();
                
                 String tecname = rs1.getString("teacher_name");
                session.setAttribute("tecname", tecname);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(peoplelist_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(peoplelist_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("peoplelist.jsp").forward(request,response);
    }

}
