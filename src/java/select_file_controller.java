/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.post;
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
@WebServlet(urlPatterns = {"/select_file_controller"})
public class select_file_controller extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String code = request.getParameter("code");
        String code1=request.getParameter("code");
        System.out.println(code);
         ArrayList<post> postlist = new ArrayList<post>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from post where course_code=? ");
            ps.setString(1, code);
            ResultSet rs =   ps.executeQuery();
            while(rs.next()){
                
                post po =new post();
                po.setCode(rs.getString("course_code"));
                po.setName(rs.getString("filename"));
                po.setBody(rs.getString("body"));
                 po.setTime(rs.getTimestamp("date"));
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                postlist.add(po);
                
                request.setAttribute("postlist",postlist);
                request.setAttribute("code", code);
                
            }
       
             PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select course_name from add_course where course_code=? ");
             ps1.setString(1, code1);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 String name = rs1.getString("course_name");
                 HttpSession session = request.getSession();
                session.setAttribute("name", name);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(select_file_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(select_file_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
         request.getRequestDispatcher("postlist.jsp").forward(request,response);
    }
}