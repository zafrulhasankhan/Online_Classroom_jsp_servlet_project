/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.attend;
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
@WebServlet(urlPatterns = {"/datewise_report_controller"})
public class datewise_report_controller extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String code = request.getParameter("code");
          String date= request.getParameter("date");
          ArrayList<attend> attendlist = new ArrayList<attend>();
        try {
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from attendence_list  where course_code=? and date=? ");
            ps1.setString(1, code);
            ps1.setString(2, date);
            ResultSet rs=ps1.executeQuery();
             while(rs.next()){
                 attend a = new attend();
                 a.setId(rs.getString("class_id"));
                 a.setName(rs.getString("Student_name"));
                 a.setAttendance(rs.getString("Attendence"));
                 attendlist.add(a);
                 request.setAttribute("attendlist",attendlist);
                 request.setAttribute("code",code);
                 request.setAttribute("date", date);
             }
                
        } catch (SQLException ex) {
            Logger.getLogger(datewise_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(datewise_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("date_attend_list.jsp").forward(request,response);
    }

    
}
