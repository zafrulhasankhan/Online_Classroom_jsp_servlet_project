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
@WebServlet(urlPatterns = {"/delete_course_cotroller"})
public class delete_course_cotroller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String tecname = request.getParameter("name");
         String tecemail = request.getParameter("email");
         String filename= request.getParameter("filename");
        // System.out.println(tecemail);
        //System.out.println(tecname);
                         PrintWriter out = response.getWriter();
                         out.println("<script type=\"text/javascript\">");
                         out.println("alert('Are you want to delete course');");
                         out.println("</script>");
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Delete from add_course where course_code = ?");
            ps.setString(1, code);
            int n=ps.executeUpdate();
              
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("Delete from attendence_list where course_code = ?");
            ps1.setString(1, code);
            ps1.executeUpdate();
            
             PreparedStatement ps2 = DBConnection.getConnection().prepareStatement("Delete from classwork where course_code = ?");
            ps2.setString(1, code);
            ps2.executeUpdate();
            
            PreparedStatement ps3 = DBConnection.getConnection().prepareStatement("Delete from classwork_mark where course_code = ?");
            ps3.setString(1, code);
            ps3.executeUpdate();
            
            PreparedStatement ps4 = DBConnection.getConnection().prepareStatement("Delete from classwork_submit where course_code = ?");
            ps4.setString(1, code);
            ps4.executeUpdate();
            
            PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("Delete from post where course_code = ?");
            ps5.setString(1, code);
            ps5.executeUpdate();
            
            PreparedStatement ps6= DBConnection.getConnection().prepareStatement("Delete from student_list where course_code = ?");
            ps6.setString(1, code);
            ps6.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(delete_course_cotroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(delete_course_cotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = request.getSession();
                            
                       session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "dc");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                             session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "no");
         session.setAttribute("name",tecname);
         session.setAttribute("email",tecemail);
         request.setAttribute("filename", filename);
               RequestDispatcher rd=request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
    }
}