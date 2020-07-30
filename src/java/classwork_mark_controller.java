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
@WebServlet(urlPatterns = {"/classwork_mark_controller"})
public class classwork_mark_controller extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        String tec_filename=request.getParameter("filename");
        String tecname=request.getParameter("tecname");
        String tecemail=request.getParameter("tecemail");
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
                          session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "ncm");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                             session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                             session.setAttribute("se", "no");
                            session.setAttribute("name", tecname);
                            session.setAttribute("email", tecemail);
                            request.setAttribute("filename", tec_filename);        
                            request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                }
                else{
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from classwork_mark  where course_code=? and classworkno=?");
            ps.setString(1,code);
            ps.setString(2,cwno);
                    ResultSet rs1 =   ps.executeQuery();
                    while(rs1.next()){
                        
                        classwork cw = new classwork();
                         String stu_id=rs1.getString("student_id");
                          cw.setStudent_id(rs1.getString("student_id"));
                           cw.setMark(rs1.getString("mark"));
                           cw.setStudent_email(rs1.getString("student_email"));
                           
                        
                        PreparedStatement  ps2 = DBConnection.getConnection().prepareStatement("Select * from student_list  where id=? ");
                        ps2.setString(1, stu_id);
                         ResultSet rs2 =   ps2.executeQuery();
                        if(rs2.next()){
                       
                         cw.setFilephoto(rs2.getString("filename"));
                            System.out.println(rs2.getString("filename"));
                        cw.setStudent_name(rs2.getString("name"));
                        }
                        worklist.add(cw);
                        System.out.println(cw);
                        request.setAttribute("worklist",worklist);
                        request.setAttribute("code", code);
                        request.setAttribute("cwno", cwno);
                        request.setAttribute("filename", tec_filename);
                        session.setAttribute("name", tecname);
                        session.setAttribute("email", tecemail);
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
