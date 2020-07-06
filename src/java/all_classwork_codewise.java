/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.classwork;
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
@WebServlet(urlPatterns = {"/all_classwork_codewise"})
public class all_classwork_codewise extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ArrayList<classwork> worklist = new ArrayList<classwork>();
       String code = request.getParameter("code");
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM classwork WHERE course_code=?),\"post not yet\") as course_code  ");
            ps0.setString(1, code);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int count= Integer.parseInt(rs0.getString(1));
                if(count==0){
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  ' Hey ' ,'No classwork created yet',  'error' );");
			out.println("});");
			out.println("</script>");
                }
                else{
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from classwork  where course_code=?");
             ps.setString(1,code);
                    ResultSet rs1 =   ps.executeQuery();
                    while(rs1.next()){
                        classwork cw = new classwork();
                        cw.setClasswork_no(rs1.getString("classworkno"));
                         cw.setBody(rs1.getString("body"));
                          cw.setDeadline(rs1.getString("deadline"));
                           cw.setFilename(rs1.getString("filename"));
                           System.out.println(rs1.getBlob("file"));
                           worklist.add(cw);
                        System.out.println(cw);
                request.setAttribute("worklist",worklist);
                request.setAttribute("code", code);
                    }
                    PreparedStatement  ps1 = DBConnection.getConnection().prepareStatement("Select * from add_course  where course_code=?");
                    ps1.setString(1,code);
                    ResultSet rs2 =   ps1.executeQuery();
                    if(rs2.next()){
                        String coursename = rs2.getString("course_name");
                        request.setAttribute("name", coursename);
                    }
                 request.getRequestDispatcher("admin_all_classwork.jsp").forward(request,response);
                }
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(all_classwork_codewise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(all_classwork_codewise.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

  
}
