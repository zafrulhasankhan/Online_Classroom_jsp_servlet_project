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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/datewise_report_controller"})
public class datewise_report_controller extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session =request.getSession();
        String tecemail=request.getParameter("email");
        String tecname=request.getParameter("name");
        String tecfilename=request.getParameter("filename");
         String code = request.getParameter("code");
          String date= request.getParameter("date");
          ArrayList<attend> attendlist = new ArrayList<attend>();
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(Attendence) FROM attendence_list WHERE course_code=? and date=?),\"post not yet\") as Attendence ");
            ps0.setString(1, code);
             ps0.setString(2, date);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int present = Integer.parseInt(rs0.getString(1));
                if(present==0){
                        session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "asa");
                            session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                             session.setAttribute("se", "no");
                            session.setAttribute("name", tecname);
                            session.setAttribute("email", tecemail);
                            request.setAttribute("filename", tecfilename);        
                            request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                }
                else{
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from attendence_list  where course_code=? and date=? ");
            ps1.setString(1, code);
            ps1.setString(2, date);
            ResultSet rs=ps1.executeQuery();
             while(rs.next()){
                 attend a = new attend();
                 String class_id= rs.getString("class_id");
                 a.setId(rs.getString("class_id"));
                 a.setName(rs.getString("Student_name"));
                 a.setAttendance(rs.getString("Attendence"));
                 
                 request.setAttribute("attendlist",attendlist);
                 request.setAttribute("code",code);
                 request.setAttribute("date", date);
                 
             PreparedStatement ps4= DBConnection.getConnection().prepareStatement("SELECT filename FROM `student_list` WHERE id=? and course_code=?");
             ps4.setString(1, class_id);
             ps4.setString(2, code);
             ResultSet rs4=ps4.executeQuery();
             if(rs4.next()){
                
               
                 String sfilename = rs4.getString("filename");
                 System.out.println();
                
                 a.setSfilename(sfilename);
             }
             attendlist.add(a);
             }
             session.setAttribute("tecemail", tecemail);
             session.setAttribute("tecname", tecname);
             request.setAttribute("filename", tecfilename);
              request.getRequestDispatcher("date_attend_list.jsp").forward(request,response);
                }
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(datewise_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(datewise_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
}
