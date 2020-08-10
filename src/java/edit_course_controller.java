/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/edit_course_controller"})
public class edit_course_controller extends HttpServlet {

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
        
        String cname = request.getParameter("cname");
        String code = request.getParameter("code");
        String pin= request.getParameter("pin");
       
         String pcname = request.getParameter("pcname");
        String pcode = request.getParameter("pcode");
        String ppin= request.getParameter("ppin");
        
        String tecname = request.getParameter("name");
        String tecemail = request.getParameter("email");
        String tecfilename = request.getParameter("filename");
        
        /*try {
            PreparedStatement  ps0 = DBConnection.getConnection().prepareStatement ("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE password=?),\"0\" ) as course_code");
         ps0.setString(1, pin);
              ResultSet rs0 =ps0.executeQuery();
                if(rs0.next()){
                    //String clasno = rs.getString("class_no");
                   // System.out.println(clasno);
                   int count=Integer.parseInt(rs0.getString(1));
                    if(count==0)
                    {*/
              
         if(!"".equals(cname)||(!"".equals(code))||(!"".equals(pin))){
             
            try {
                /*
                if(pin == null ? ppin == null : pin.equals(ppin)){ 
                
                PreparedStatement ps=DBConnection.getConnection().prepareStatement("update add_course set course_name=? , course_code=?  where  course_code=? and course_name=? ");
                ps.setString(1, cname);
               ps.setString(2, code);
                //ps.setString(3, pin);
                ps.setString(3, pcode);
                 ps.setString(4, pcname);
               // ps.setString(6, ppin);
               ps.executeUpdate();
               
               
               session.setAttribute("ssp", "no");
                          session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
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
                            String ncourse = "<div class=\"alert alert-warning\" style=\"display:inline-table; color:white; background:green; \">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:red;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>hey!</strong>  course pin match others. change the   course pin !.....  \n" +
"            </div>"; 
                      request.setAttribute("ncd", ncourse);
        session.setAttribute("email", tecemail);
        session.setAttribute("name", tecname);
          request.setAttribute("filename", tecfilename);
               //RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               //rd.forward(request,response);
                }
                else{*/
                PreparedStatement  ps0 = DBConnection.getConnection().prepareStatement ("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE password=?),\"0\" ) as course_code");
         ps0.setString(1, pin);
              ResultSet rs0 =ps0.executeQuery();
                if(rs0.next()){
                    //String clasno = rs.getString("class_no");
                   // System.out.println(clasno);
                    System.out.println(pin);
                   int count=Integer.parseInt(rs0.getString(1));
                    System.out.println(count+"count");
                    if(pin == null ? ppin == null : pin.equals(ppin)){
                    if(count==1)
                    {
                        
                    
                PreparedStatement ps=DBConnection.getConnection().prepareStatement("update add_course set course_name=? , course_code=? , password=? where  course_code=? and course_name=? and password=?");
                ps.setString(1, cname);
               ps.setString(2, code);
                ps.setString(3, pin);
                ps.setString(4, pcode);
                 ps.setString(5, pcname);
                ps.setString(6, ppin);
               
                ps.executeUpdate();
                }
                    }
                    else if(count==0){
                        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update add_course set course_name=? , course_code=? , password=? where  course_code=? and course_name=? and password=?");
                ps.setString(1, cname);
               ps.setString(2, code);
                ps.setString(3, pin);
                ps.setString(4, pcode);
                 ps.setString(5, pcname);
                ps.setString(6, ppin);
               
                ps.executeUpdate();
                    }
                    else{
                         session.setAttribute("ssp", "no");
                          session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
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
                            String ncourse = "<div class=\"alert alert-warning\" style=\"display:inline-table; color:white; background:green; \">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:red;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>hey sorry!</strong>  course pin match others course. change the   course pin !.....  \n" +
"            </div>"; 
                      request.setAttribute("ncd", ncourse);
        session.setAttribute("email", tecemail);
        session.setAttribute("name", tecname);
          request.setAttribute("filename", tecfilename);
               RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
        
                    }
                }
                PreparedStatement ps1=DBConnection.getConnection().prepareStatement("update student_list set  course_code=? where  course_code=? ");
                ps1.setString(1, code);
                ps1.setString(2, pcode);
                ps1.executeUpdate();
                
                
                 PreparedStatement ps2=DBConnection.getConnection().prepareStatement("update post set  course_code=? where  course_code=? ");
                ps2.setString(1, code);
                ps2.setString(2, pcode);
                ps2.executeUpdate();
                
                
                 PreparedStatement ps3=DBConnection.getConnection().prepareStatement("update classwork_submit set  course_code=? where  course_code=? ");
                ps3.setString(1, code);
                ps3.setString(2, pcode);
                ps3.executeUpdate();
                
                PreparedStatement ps4=DBConnection.getConnection().prepareStatement("update classwork_mark set  course_code=? where  course_code=? ");
                ps4.setString(1, code);
                ps4.setString(2, pcode);
                ps4.executeUpdate();
                
                 PreparedStatement ps5=DBConnection.getConnection().prepareStatement("update classwork set  course_code=? where  course_code=? ");
                ps5.setString(1, code);
                ps5.setString(2, pcode);
                ps5.executeUpdate();
                
                
                PreparedStatement ps6=DBConnection.getConnection().prepareStatement("update attendence_list set  course_code=? where  course_code=? ");
                ps6.setString(1, code);
                ps6.setString(2, pcode);
                ps6.executeUpdate();
            
            } catch (SQLException ex) {
                Logger.getLogger(edit_course_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(edit_course_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
         }
                    
      
                            session.setAttribute("ssp", "no");
                          session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
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
                            session.setAttribute("se", "se");
        session.setAttribute("email", tecemail);
        session.setAttribute("name", tecname);
          request.setAttribute("filename", tecfilename);
               RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
                    }
                    /*else{
                        
                         session.setAttribute("ssp", "no");
                          session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
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
                            String ncourse = "<div class=\"alert alert-warning\" style=\"display:inline-table; color:white; background:green; \">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:red;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>hey!</strong>  course pin match others. change the   course pin !.....  \n" +
"            </div>"; 
                      request.setAttribute("ncd", ncourse);
        session.setAttribute("email", tecemail);
        session.setAttribute("name", tecname);
          request.setAttribute("filename", tecfilename);
               RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
                        
                        
                        
                        
                    }
                }
               
            /* } catch (SQLException ex) {
            Logger.getLogger(edit_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(edit_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    //}

    

}

