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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/show_submitted_all_classwork_codewise"})
public class show_submitted_all_classwork_codewise extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        ArrayList<classwork> worklist = new ArrayList<classwork>();
        String code = request.getParameter("code");
        String classworkno = request.getParameter("classworkno");
        String tecname = request.getParameter("name");
         String tecemail= request.getParameter("email");
          String filename = request.getParameter("filename");
          System.out.println(classworkno);
        //String code1 =(String) getServletContext().getAttribute("code");
       //String classworkno1 =(String) getServletContext().getAttribute("classworkno");
       //String code1="ict-3109";
       //String classworkno1="1";
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(student_id) FROM classwork_submit WHERE course_code=? and classworkno=? ),\"post not yet\") as student_id ");
            ps0.setString(1, code);
             ps0.setString(2, classworkno);
             //ps0.setString(3, code1);
            // ps0.setString(4, classworkno1);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int present = Integer.parseInt(rs0.getString(1));
                if(present==0){
                    /*msg er jnno */
                         String nos="nos";
                         
                           session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "nos");
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
                             session.setAttribute("se", "no");
                           
                         //session.setAttribute("ssp", code);
                         /*msg er jnno */
                         session.setAttribute("tecemail", tecemail);
                         session.setAttribute("tecname", tecname);
                         request.setAttribute("filename", filename);
                         request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                }
                else{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from classwork_submit where course_code=? and classworkno=?");
              ps.setString(1,code);
               ps.setString(2,classworkno);
               //ps.setString(3,code1);
               //ps.setString(4,classworkno1);
                    ResultSet rs1 =   ps.executeQuery();
                    while(rs1.next()){
                        classwork cw = new classwork();
                        cw.setStudent_email(rs1.getString("email"));
                         cw.setStudent_name(rs1.getString("student_name"));
                          cw.setStudent_id(rs1.getString("student_id"));
                           cw.setFilename(rs1.getString("filename"));
                           cw.setComment(rs1.getString("pcomment"));
                           System.out.println(rs1.getBlob("file"));
                           worklist.add(cw);
                        System.out.println(cw);
                request.setAttribute("worklist",worklist);
                request.setAttribute("code", code);
                //request.setAttribute("code", code1);
                request.setAttribute("classworkno", classworkno);
                //request.setAttribute("classworkno", classworkno1);
                    }
                    PreparedStatement  ps1 = DBConnection.getConnection().prepareStatement("Select * from add_course  where course_code=? ");
                    ps1.setString(1,code);
                     //ps1.setString(2,code1);
                    ResultSet rs2 =   ps1.executeQuery();
                    if(rs2.next()){
                        String coursename = rs2.getString("course_name");
                        request.setAttribute("name", coursename);
                    }
                    session.setAttribute("tecemail", tecemail);
                    session.setAttribute("tecname", tecname);
                    request.setAttribute("filename", filename);
                    request.getRequestDispatcher("submitted_work_list.jsp").forward(request,response);
                }
            }
            
                    } catch (SQLException ex) {
            Logger.getLogger(show_submitted_all_classwork_codewise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(show_submitted_all_classwork_codewise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

}
