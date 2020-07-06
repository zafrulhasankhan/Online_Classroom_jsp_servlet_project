/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import db.course;
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
@WebServlet(urlPatterns = {"/courselist_controller_2"})
public class courselist_controller_2 extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          PrintWriter out = response.getWriter();
ArrayList<course> course_list = new ArrayList<course>();
         String tecname = request.getParameter("name");
         String tecemail = request.getParameter("email");
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE teacher_name=? AND teacher_email=?), \"post not yet\") as course_code ");
             ps0.setString(1, tecname);
            ps0.setString(2, tecemail);
           
            ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int stuno = Integer.parseInt(rs0.getString(1));
                if(stuno!=0){
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select *from add_course where teacher_name=? and teacher_email=?");
             ps.setString(1, tecname);
            ps.setString(2, tecemail);
            ResultSet rs =   ps.executeQuery();
            while(rs.next()){
                
                course u = new course();
               u.setId(rs.getInt("course_id"));
                u.setName(rs.getString("course_name"));
                u.setCode(rs.getString("course_code"));
               
                
                
                System.out.println(u);
                course_list.add(u);
                
                request.setAttribute("course_list",course_list);
                
            }
            request.getRequestDispatcher("course_list_2.jsp").forward(request,response);
                }
                else{
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'ohh sorry !' ,  ' No classwork and attendance added yet ' ,  'error' );");
			out.println("});");
			out.println("</script>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(courselist_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(courselist_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
}