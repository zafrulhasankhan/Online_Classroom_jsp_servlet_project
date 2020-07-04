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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String tecname = request.getParameter("tecname");
         String tecemail = request.getParameter("tecemail");
        // System.out.println(tecemail);
        //System.out.println(tecname);
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Delete from add_course where course_code = ?");
            ps.setString(1, code);
            int n=ps.executeUpdate();
              
            
        } catch (SQLException ex) {
            Logger.getLogger(delete_course_cotroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(delete_course_cotroller.class.getName()).log(Level.SEVERE, null, ex);
        }
         getServletContext().setAttribute("tecname",tecname);
         getServletContext().setAttribute("tecemail",tecemail);
               RequestDispatcher rd=getServletContext().getRequestDispatcher("/courselist_controller");
               rd.forward(request,response);
    }
}