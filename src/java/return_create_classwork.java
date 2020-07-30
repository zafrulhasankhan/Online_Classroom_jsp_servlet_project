/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.classwork;
import dao.post;
import db.DBConnection;
import static java.awt.SystemColor.window;
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

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/return_create_classwork"})
public class return_create_classwork extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String code = request.getParameter("code");
        String email = request.getParameter("email");
         String cname = request.getParameter("cname");
         String tecname = request.getParameter("tecname");
         String tecfilename = request.getParameter("tecfilename");
          PrintWriter out = response.getWriter();
         System.out.println(email+code+cname+tecname+tecfilename);
         //System.out.println(spass);
         //String code ="ict-3109";
        // String email="nasimzafrulhasan@gmail.com";
        // String spass="12";
      /* String co="kjkjadad";
       getServletContext().setAttribute("var",co);
       RequestDispatcher rd=getServletContext
().getRequestDispatcher("/date");
rd.forward(request,response);*/

      ArrayList<classwork> worklist = new ArrayList<classwork>();
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM classwork WHERE course_code=?),\"post not yet\") as course_code  ");
            ps0.setString(1, code);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int count= Integer.parseInt(rs0.getString(1));
                //int count=0;
                if(count==0){
                    String msg = String.format("No classwork uploaded yet in '%s'.", code);
           
                    //getServletContext().setParameter("code", code);
                getServletContext().setAttribute("msg", msg);
                 getServletContext().setAttribute("code",code);
                  getServletContext().setAttribute("email",email);
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/no_classwork_msg");
               rd.forward(request,response);
                    
                   
                }
                else{
                    
                    PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from classwork where course_code=?");
                    ps1.setString(1,code);
                    ResultSet rs1 =   ps1.executeQuery();
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
                    PreparedStatement ps2 = DBConnection.getConnection().prepareStatement("select * from student_list where email=? ");
                    ps2.setString(1, email);
                    //ps2.setString(2, spass);
                    ResultSet rs2= ps2.executeQuery();
                    if(rs2.next()){
                        String sname= rs2.getString("name");
                        String sid=rs2.getString("id");
                        request.setAttribute("sname", sname);
                        request.setAttribute("sid", sid);
                        request.setAttribute("email", email);
                        request.setAttribute("cname", cname);
                        request.setAttribute("tecname", tecname);
                        request.setAttribute("tecfilename", tecfilename);
                    }
               }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(return_create_classwork.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(return_create_classwork.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("classworklist1.jsp").forward(request,response);
    }

   

}
