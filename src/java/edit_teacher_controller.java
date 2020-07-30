/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/edit_teacher_controller"})
@MultipartConfig(maxFileSize =32354432)
public class edit_teacher_controller extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       String ptecemail = request.getParameter("emailp");
        String ptecname = request.getParameter("namep");
        String tecemail = request.getParameter("email");
        String tecname = request.getParameter("name");
        
        Part part = request.getPart("image");// we get path of the image
       
        String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
        if(!"".equals(tecname)||(!"".equals(tecemail))){
        try {
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("update teacher_list set email=? , name=? where  email=? and name=? ");
            ps.setString(1, tecemail);
            ps.setString(2, tecname);
            ps.setString(3, ptecemail);
            ps.setString(4, ptecname);
            ps.executeUpdate();
           
            PreparedStatement ps4=DBConnection.getConnection().prepareStatement("update add_course set teacher_email=? , teacher_name=? where  teacher_email=? and teacher_name=? ");
            ps4.setString(1, tecemail);
            ps4.setString(2, tecname);
            ps4.setString(3, ptecemail);
            ps4.setString(4, ptecname);
            ps4.executeUpdate();
           
            
            PreparedStatement ps5=DBConnection.getConnection().prepareStatement("update email set email=? , name=? where  email=? and name=? ");
            ps5.setString(1, tecemail);
            ps5.setString(2, tecname);
            ps5.setString(3, ptecemail);
            ps5.setString(4, ptecname);
            ps5.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(edit_teacher_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(edit_teacher_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       if(!"".equals(filename)){
        
           try {
               PreparedStatement ps1=DBConnection.getConnection().prepareStatement("update teacher_list set file=? , filename=? where  email=? and name=? ");
               InputStream is = part.getInputStream();
               ps1.setBlob(1, is);
               ps1.setString(2, filename);
               ps1.setString(3, tecemail);
               ps1.setString(4, tecname);
               ps1.executeUpdate();
           } catch (SQLException ex) {
               Logger.getLogger(edit_teacher_controller.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(edit_teacher_controller.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        try {
            PreparedStatement ps2=DBConnection.getConnection().prepareStatement("select * from teacher_list  where  email=? and name=? ");
            ps2.setString(1, tecemail);
            ps2.setString(2, tecname);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()){
                String lfilename = rs2.getString("filename");
                session.setAttribute("email", tecemail);
			session.setAttribute("name", tecname);
                        String ncerror = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Successfully !</strong> Edited and update your profile...  \n" +
"            </div>";
                        request.setAttribute("ssa", ncerror);
                        request.setAttribute("filename",lfilename);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(edit_teacher_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(edit_teacher_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
                                 
       
                  
    }

    
}
