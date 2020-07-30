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
@WebServlet(urlPatterns = {"/select_course_controller"})
public class select_course_controller extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
       String code =(String) getServletContext().getAttribute("code");
       String code1 = request.getParameter("code");
       
       String atecname = request.getParameter("name");
       String atecemail = request.getParameter("email");
       String afilename = request.getParameter("filename");
       String email =(String) getServletContext().getAttribute("email");
       String spass =(String) getServletContext().getAttribute("spass");
        //String code1="ict-3109";
       // System.out.println(email);
       //String pemail =(String) getServletContext().getAttribute("pemail");
       //String pname =(String) getServletContext().getAttribute("pname");
       //String pfilename =(String) getServletContext().getAttribute("pfilename");
        //System.out.println(pfilename);
         ArrayList<post> postlist = new ArrayList<post>();
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM post WHERE course_code=? or course_code=?),\"post not yet\") as course_code  ");
             ps0.setString(1, code);
             ps0.setString(2, code1);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int present = Integer.parseInt(rs0.getString(1));
                if(present==0){
                            session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "np");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                            session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "no");
                            session.setAttribute("name", atecname);
                            session.setAttribute("email", atecemail);
                            request.setAttribute("filename", afilename);        
                            request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                }
                else{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from post where course_code=? or  course_code=? ");
            ps.setString(1, code);
             ps.setString(2, code1);
            ResultSet rs =   ps.executeQuery();
            while(rs.next()){
                
                post po =new post();
                po.setCode(rs.getString("course_code"));
                po.setName(rs.getString("filename"));
                po.setBody(rs.getString("body"));
                 po.setTime(rs.getString("date"));
                 System.out.println(rs.getString("date"));
                po.setPoster_filename(rs.getString("poster_filename"));
                po.setPoster_name(rs.getString("poster_name"));
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                postlist.add(po);
                
                request.setAttribute("postlist",postlist);
                request.setAttribute("code", code);
                request.setAttribute("code", code1);
                request.setAttribute("email", email);
                request.setAttribute("spass", spass);
            }
                }
            }
             PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=? or course_code=? ");
             ps1.setString(1, code);
              ps1.setString(2, code1);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 String course_name = rs1.getString("course_name");
                 session.setAttribute("course_name", course_name);
                 String tecname = rs1.getString("teacher_name");
                session.setAttribute("tecname", tecname);
                request.setAttribute("cname", course_name);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(select_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(select_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("name", atecname);
        session.setAttribute("email", atecemail);
          request.setAttribute("filename", afilename);  
           
          request.getRequestDispatcher("postlist.jsp").forward(request,response);
    }
}