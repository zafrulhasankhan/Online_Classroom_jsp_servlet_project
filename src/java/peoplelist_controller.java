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
         String atecemail = request.getParameter("email");
          String atecname = request.getParameter("name");
           String afilename = request.getParameter("filename");
         HttpSession session = request.getSession();
        
        ArrayList<people> peoplelist = new ArrayList<people>();
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(id) FROM student_list WHERE course_code=? ),\"post not yet\") as name  ");
             ps0.setString(1, code);
            
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
            int count = Integer.parseInt(rs0.getString(1));
                if(count!=0){
                
           
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from student_list  where course_code=? ");
            ps1.setString(1, code);
            ResultSet rs=ps1.executeQuery();
             while(rs.next()){
                
                people po =new people();
                
                po.setStudentlist(rs.getString("name"));
               po.setClass_id(rs.getString("id"));
               po.setEmail(rs.getString("email"));
               po.setPhoto(rs.getString("filename"));
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                peoplelist.add(po);
                
                request.setAttribute("peoplelist",peoplelist);
                request.setAttribute("code",code);
                
            }
             PreparedStatement ps2 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=? ");
             ps2.setString(1, code);
             ResultSet rs1=ps2.executeQuery();
             if(rs1.next()){
                 
               
                String tecemail=rs1.getString("teacher_email");
                session.setAttribute("tecemail", tecemail);
               String tecname = rs1.getString("teacher_name");
                session.setAttribute("tecname", tecname);
                String course_name = rs1.getString("course_name");
                session.setAttribute("name", course_name);
                request.setAttribute("name", course_name);
                PreparedStatement ps3 = DBConnection.getConnection().prepareStatement("select * from teacher_list where name=? and email=?");
                ps3.setString(1, tecname);
                ps3.setString(2, tecemail);
                ResultSet rs3=ps3.executeQuery();
             if(rs3.next()){
              String filename= rs3.getString("filename");
                 System.out.println(filename);
             request.setAttribute("filename",filename);
             }
                 
                
             }
             request.getRequestDispatcher("peoplelist.jsp").forward(request,response);
             }
                else{
                    
                    session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                            session.setAttribute("ev", "no");
                            session.setAttribute("ns", "ns");
                            session.setAttribute("se", "no");
                    session.setAttribute("email", atecemail);
                    session.setAttribute("name", atecname);
                    request.setAttribute("filename", afilename);
                    request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(peoplelist_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(peoplelist_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        
    }

}
