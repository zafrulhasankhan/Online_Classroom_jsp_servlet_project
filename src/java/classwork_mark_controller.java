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
@WebServlet(urlPatterns = {"/classwork_mark_controller"})
public class classwork_mark_controller extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        ArrayList<classwork> worklist = new ArrayList<classwork>();
       String code = request.getParameter("code");
        String cwno = request.getParameter("cwno");
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(mark) FROM classwork_mark WHERE course_code=? and classworkno=?),\"post not yet\") as mark ");
            ps0.setString(1, code);
            ps0.setString(2, cwno);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int count= Integer.parseInt(rs0.getString(1));
                if(count==0){
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  ' Hey ' ,'No classwork mark get yet',  'error' );");
			out.println("});");
			out.println("</script>");
                }
                else{
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from classwork_mark  where course_code=? and classworkno=?");
            ps.setString(1,code);
            ps.setString(2,cwno);
                    ResultSet rs1 =   ps.executeQuery();
                    while(rs1.next()){
                        classwork cw = new classwork();
                        
                         
                          cw.setStudent_id(rs1.getString("student_id"));
                           cw.setMark(rs1.getString("mark"));
                           cw.setStudent_email(rs1.getString("student_email"));
                           worklist.add(cw);
                        System.out.println(cw);
                request.setAttribute("worklist",worklist);
                request.setAttribute("code", code);
                request.setAttribute("cwno", cwno);
                    }
                    request.getRequestDispatcher("classwork_mark_list.jsp").forward(request,response);
                }
        }
        } catch (SQLException ex) {
            Logger.getLogger(classwork_mark_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classwork_mark_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   

}
