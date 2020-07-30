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
@WebServlet(urlPatterns = {"/edit_student_controller"})
@MultipartConfig(maxFileSize =32354432)
public class edit_student_controller extends HttpServlet {

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       String semail = request.getParameter("email");
        String sname = request.getParameter("name");
        String stu_id = request.getParameter("id");
        String code = request.getParameter("code");
        String psemail = request.getParameter("emailp");
        String psname = request.getParameter("namep");
        String pstu_id = request.getParameter("idp");
        //String pfilename= request.getParameter("filenamep");
        //String psemail="nasimzafrulhasn@gmail.com";
       // String psname="Zafrul hasan nasim";
        //String pstu_id="it-18003";
        Part part = request.getPart("image");// we get path of the image
       System.out.println(semail+sname+stu_id);
        System.out.println(psemail+psname+pstu_id);
        String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
         if(!"".equals(sname)||(!"".equals(semail))||(!"".equals(stu_id))){
       try {
           PreparedStatement ps=DBConnection.getConnection().prepareStatement("update student_account set email=? , name=? , id=? where  email=? and  name=? and id=?");
            ps.setString(1, semail);
            ps.setString(2, sname);
            ps.setString(3, stu_id);
           ps.setString(4, psemail);
            ps.setString(5, psname);
            ps.setString(6, pstu_id);
            ps.executeUpdate();
           System.out.println("djjf");
           System.out.println(semail+sname+stu_id);
           
            PreparedStatement ps4=DBConnection.getConnection().prepareStatement("update student_list set email=? , name=?, id=? where  email=? and name=? and id=?");
            ps4.setString(1, semail);
            ps4.setString(2, sname);
            ps4.setString(3, stu_id);
            ps4.setString(4, psemail);
            ps4.setString(5, psname);
            ps4.setString(6, pstu_id);
            ps4.executeUpdate();
           
            
            PreparedStatement ps5=DBConnection.getConnection().prepareStatement("update classwork_submit set email=? ,student_name=?,student_id=? where  email=? and student_name=? and student_id=? ");
            ps5.setString(1, semail);
            ps5.setString(2, sname);
            ps5.setString(3, stu_id);
            ps5.setString(4, psemail);
             ps5.setString(5, psname);
            ps5.setString(6, pstu_id);
            ps5.executeUpdate();
            
            
             PreparedStatement ps6=DBConnection.getConnection().prepareStatement("update classwork_mark set student_email=? ,student_id=? where  student_email=? and student_id=? ");
            ps6.setString(1, semail);
            ps6.setString(2, stu_id);
            ps6.setString(3, psemail);
            ps6.setString(4, pstu_id);
            ps6.executeUpdate();
           
            
            
             PreparedStatement ps7=DBConnection.getConnection().prepareStatement("update attendence_list set Student_name=? ,class_id=? where  Student_name=? and class_id=? ");
            ps7.setString(1, sname);
            ps7.setString(2, stu_id);
            ps7.setString(3, psname);
            ps7.setString(4, pstu_id);
            
            ps7.executeUpdate();
           
       } catch (SQLException ex) {
           Logger.getLogger(edit_student_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(edit_student_controller.class.getName()).log(Level.SEVERE, null, ex);
       }
         }
         
         
         if(!"".equals(filename)){
       try {
           
           PreparedStatement ps8=DBConnection.getConnection().prepareStatement("update student_account set file=? , filename=? where  email=? and name=? ");
            InputStream is = part.getInputStream();
               ps8.setBlob(1, is);
               ps8.setString(2, filename);
               ps8.setString(3, semail);
               ps8.setString(4, sname);
               ps8.executeUpdate();
       
       } catch (SQLException ex) {
           Logger.getLogger(edit_student_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(edit_student_controller.class.getName()).log(Level.SEVERE, null, ex);
       }
         }
         
         
         try {
           
           PreparedStatement ps9=DBConnection.getConnection().prepareStatement("select * from student_account   where  email=? and name=? and id=?");
               ps9.setString(1, semail);
               ps9.setString(2, sname);
               ps9.setString(3, stu_id);
               ResultSet rs = ps9.executeQuery();
               if(rs.next()){
                   String profilename = rs.getString("filename");
                    request.setAttribute("sname", sname);
            request.setAttribute("semail", semail);
            request.setAttribute("sfilename", profilename);
            request.getRequestDispatcher("edit_student_acc.jsp").forward(request,response);
               }
       
       } catch (SQLException ex) {
           Logger.getLogger(edit_student_controller.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(edit_student_controller.class.getName()).log(Level.SEVERE, null, ex);
       }
         
           
}
}