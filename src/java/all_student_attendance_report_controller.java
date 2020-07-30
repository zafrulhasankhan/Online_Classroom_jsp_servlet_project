/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.allstu_report;
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
@WebServlet(urlPatterns = {"/all_student_attendance_report_controller"})
public class all_student_attendance_report_controller extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session =request.getSession();
        String tecemail=request.getParameter("email");
        String tecname=request.getParameter("name");
        String tecfilename=request.getParameter("filename");
       String code = request.getParameter("code");
       //String code="ict-3109";
        ArrayList<allstu_report> allreportlist = new ArrayList<allstu_report>();
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(Attendence) FROM attendence_list WHERE course_code=?  ), \"post not yet\") as Attendence ");
             ps0.setString(1,code);
            
           
            ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int count = Integer.parseInt(rs0.getString(1));
                if(count!=0){
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from student_list  where course_code=? ");
            ps1.setString(1, code);
            ResultSet rs1=ps1.executeQuery();
             while(rs1.next()){
                
                 allstu_report  ar= new allstu_report();
                
               ar.setStudent_name(rs1.getString("name"));
               ar.setClassid(rs1.getString("id"));
               ar.setEmail(rs1.getString("email"));
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(ar);
               
                 String id = rs1.getString("id");
                 System.out.println(id);
                 PreparedStatement ps2 = DBConnection.getConnection().prepareStatement("SELECT IFNULL((SELECT COUNT(Attendence) FROM `attendence_list` WHERE course_code=? and class_id=? and Attendence='present'), \"1\") as Attendence");
                 ps2.setString(1, code);
                 ps2.setString(2, id);
                 ResultSet rs2 =   ps2.executeQuery();
              if(rs2.next()){
                 
                 int present =Integer.parseInt(rs2.getString(1));
                  ar.setPresentno(present);
                  System.out.println(present);
                 
              }
              PreparedStatement ps3= DBConnection.getConnection().prepareStatement("SELECT class_no FROM `attendence_list` WHERE course_code=? order by class_no DESC LIMIT 1");
             ps3.setString(1, code);
             ResultSet rs3=ps3.executeQuery();
             if(rs3.next()){
                 int totalclass =Integer.parseInt(rs3.getString("class_no"));
               
                 //System.out.println(totalclass);
                 ar.setTotalday(totalclass);
                 allreportlist.add(ar);
                 request.setAttribute("allreportlist",allreportlist);
             }
                session.setAttribute("tecemail", tecemail);
                session.setAttribute("tecname", tecname);
                request.setAttribute("filename", tecfilename);
                request.setAttribute("code",code);
                request.setAttribute("tecname", tecname);
            }
             request.getRequestDispatcher("all_student_attendance_report.jsp").forward(request,response);
                }
                else
                {
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
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(all_student_attendance_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(all_student_attendance_report_controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}
}