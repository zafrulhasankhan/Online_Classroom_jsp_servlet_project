/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/add_course_controller"})
public class add_course_controller extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         PrintWriter out = response.getWriter();
        String tecname = request.getParameter("tecname");
         String tecemail = request.getParameter("tecemail");
         String filename=request.getParameter("filename");
       String name = request.getParameter("name");
       String code = request.getParameter("code");
       String pass = request.getParameter("pass");
       String repass = request.getParameter("repass");
        System.out.println(pass);
        System.out.println(repass);
        System.out.println(name);
       if(pass == null ? repass == null : pass.equals(repass)){
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE course_code=? or password=?),\"post not yet\") as course_code");
            ps0.setString(1, code);
           ps0.setString(2, pass);
            ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int stuno = Integer.parseInt(rs0.getString(1));
                if(stuno==0){
            
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into add_course values(course_id,?,?,?,?,?)");
            ps.setString(1, tecname);
            ps.setString(2, tecemail);
            ps.setString(3, name);
              ps.setString(4, code);
              ps.setString(5, pass);
               
                 int n=ps.executeUpdate();
                if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        
                            session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "sac");
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
                            session.setAttribute("name", tecname);
                            session.setAttribute("email", tecemail);
                            request.setAttribute("filename", filename);        
                            request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                        
                        
		}
                else{
			 session.setAttribute("email", tecemail);
                session.setAttribute("name", tecname);
                request.setAttribute("filename", filename);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp?");
			rd.forward(request, response);  
		}
                }
                else{
                  
		           session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "ae");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(add_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(add_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       else{
                          session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "cp");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                             session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                session.setAttribute("email", tecemail);
                session.setAttribute("name", tecname);
                request.setAttribute("filename", filename);
	        RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp?");
		rd.forward(request, response);  
       }
    }
}
