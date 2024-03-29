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
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/all_classwork_codewise"})
public class all_classwork_codewise extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<classwork> worklist = new ArrayList<classwork>();
       String code = request.getParameter("code");
        String tecname = request.getParameter("name");
         String tecemail= request.getParameter("email");
          String filename = request.getParameter("filename");
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM classwork WHERE course_code=?),\"post not yet\") as course_code  ");
            ps0.setString(1, code);
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
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "nwc");
                            session.setAttribute("asa", "no");
                             session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "no");
                session.setAttribute("email", tecemail);
                session.setAttribute("name", tecname);
                request.setAttribute("filename", filename);
	        RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp?");
		rd.forward(request, response);  
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
                    session.setAttribute("email", tecemail);
                    session.setAttribute("name", tecname);
                    request.setAttribute("filename", filename);
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
