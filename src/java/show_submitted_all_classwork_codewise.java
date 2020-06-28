/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.classwork;
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
@WebServlet(urlPatterns = {"/show_submitted_all_classwork_codewise"})
public class show_submitted_all_classwork_codewise extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<classwork> worklist = new ArrayList<classwork>();
        String code = request.getParameter("code");
        String classworkno = request.getParameter("classworkno");
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from classwork_submit where course_code=? and classworkno=?");
              ps.setString(1,code);
               ps.setString(2,classworkno);
                    ResultSet rs1 =   ps.executeQuery();
                    while(rs1.next()){
                        classwork cw = new classwork();
                        cw.setStudent_email(rs1.getString("email"));
                         cw.setStudent_name(rs1.getString("student_name"));
                          cw.setStudent_id(rs1.getString("student_id"));
                           cw.setFilename(rs1.getString("filename"));
                           System.out.println(rs1.getBlob("file"));
                           worklist.add(cw);
                        System.out.println(cw);
                request.setAttribute("worklist",worklist);
                request.setAttribute("code", code);
                request.setAttribute("classworkno", classworkno);
                    }
                    PreparedStatement  ps1 = DBConnection.getConnection().prepareStatement("Select * from add_course  where course_code=?");
                    ps1.setString(1,code);
                    ResultSet rs2 =   ps1.executeQuery();
                    if(rs2.next()){
                        String coursename = rs2.getString("course_name");
                        request.setAttribute("name", coursename);
                    }
            
                    } catch (SQLException ex) {
            Logger.getLogger(show_submitted_all_classwork_codewise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(show_submitted_all_classwork_codewise.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("submitted_work_list.jsp").forward(request,response);
    }

    

}
