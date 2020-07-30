/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
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
@WebServlet(urlPatterns = {"/edit_course_controller"})
public class edit_course_controller extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cname = request.getParameter("cname");
        String code = request.getParameter("code");
        String pin= request.getParameter("pin");
       
         String pcname = request.getParameter("pcname");
        String pcode = request.getParameter("pcode");
        String ppin= request.getParameter("ppin");
        
        String tecname = request.getParameter("name");
        String tecemail = request.getParameter("email");
        String tecfilename = request.getParameter("filename");
         if(!"".equals(cname)||(!"".equals(code))||(!"".equals(pin))){
             
            try {
                PreparedStatement ps=DBConnection.getConnection().prepareStatement("update add_course set course_name=? , course_code=? , password=? where  course_code=? and course_name=? and password=?");
                ps.setString(1, cname);
               ps.setString(2, code);
                ps.setString(3, pin);
                ps.setString(4, pcode);
                 ps.setString(5, pcname);
                ps.setString(6, ppin);
                ps.executeUpdate();
                
                PreparedStatement ps1=DBConnection.getConnection().prepareStatement("update student_list set  course_code=? where  course_code=? ");
                ps1.setString(1, code);
                ps1.setString(2, pcode);
                ps1.executeUpdate();
                
                
                 PreparedStatement ps2=DBConnection.getConnection().prepareStatement("update post set  course_code=? where  course_code=? ");
                ps2.setString(1, code);
                ps2.setString(2, pcode);
                ps2.executeUpdate();
                
                
                 PreparedStatement ps3=DBConnection.getConnection().prepareStatement("update classwork_submit set  course_code=? where  course_code=? ");
                ps3.setString(1, code);
                ps3.setString(2, pcode);
                ps3.executeUpdate();
                
                PreparedStatement ps4=DBConnection.getConnection().prepareStatement("update classwork_mark set  course_code=? where  course_code=? ");
                ps4.setString(1, code);
                ps4.setString(2, pcode);
                ps4.executeUpdate();
                
                 PreparedStatement ps5=DBConnection.getConnection().prepareStatement("update classwork set  course_code=? where  course_code=? ");
                ps5.setString(1, code);
                ps5.setString(2, pcode);
                ps5.executeUpdate();
                
                
                PreparedStatement ps6=DBConnection.getConnection().prepareStatement("update attendence_list set  course_code=? where  course_code=? ");
                ps6.setString(1, code);
                ps6.setString(2, pcode);
                ps6.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(edit_course_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(edit_course_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
         }
        HttpSession session = request.getSession();
                            session.setAttribute("ssp", "no");
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
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "se");
        session.setAttribute("email", tecemail);
        session.setAttribute("name", tecname);
          request.setAttribute("filename", tecfilename);
               RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
    }

    

}
