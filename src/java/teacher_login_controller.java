/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/teacher_login_controller"})
public class teacher_login_controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String email = request.getParameter("email");
       String  pass = request.getParameter("pass");
        System.out.println(email);
       
        PrintWriter out = response.getWriter();
        try {
            
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from teacher_list  where email=? and pass=? ");
            ps.setString(1, email);
            ps.setString(2, pass);
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
              String name = rs.getString("name");
              String filename=rs.getString("filename");
                //String pass1 = rs.getString("password");
               //request.setAttribute("code", code)
               System.out.println(name);
               //request.setAttribute("name", name);
              //request.setAttribute("email", email);
              PreparedStatement  ps0 = DBConnection.getConnection().prepareStatement ("SELECT ifnull((SELECT COUNT(email) FROM email WHERE email=?),\"0\" ) as email");
              ps0.setString(1, email);
              ResultSet rs0 =ps0.executeQuery();
                if(rs0.next()){
                    //String clasno = rs.getString("class_no");
                   // System.out.println(clasno);
                   int count=Integer.parseInt(rs0.getString(1));
                    if(count==0)
                    {
                        
                    request.setAttribute("email", email);
                    request.setAttribute("name", name);
                    request.setAttribute("filename", filename);
                    RequestDispatcher rd = request.getRequestDispatcher("email_verification.jsp");
                    rd.forward(request,response);
                    }
                    else{
                        HttpSession session = request.getSession();
                        session.setAttribute("email", email);
                        session.setAttribute("name", name);
                        //session.setAttribute("nos", name);
                       // session.setAttribute("ssp", name);
                 //request.setAttribute("name", name);
                          session.setAttribute("ssp", "no");
                         // session.setAttribute("ssp", "no");
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
                    PreparedStatement  ps3 = DBConnection.getConnection().prepareStatement ("SELECT ifnull((SELECT COUNT(course_code) FROM add_course WHERE teacher_email=?),\"0\" ) as course_code");
                     ps3.setString(1, email);
              ResultSet rs3 =ps3.executeQuery();
                if(rs3.next()){
                    //String clasno = rs.getString("class_no");
                   // System.out.println(clasno);
                   int count1=Integer.parseInt(rs3.getString(1));
                    if(count1==0)
                    {
                        String ncourse = "<div class=\"alert alert-warning\" style=\"display:inline-table; color:white; background:green; \">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:red;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Oh,sorry!</strong> No course added yet !.....  \n" +
"            </div>"; 
                      request.setAttribute("ncd", ncourse);
                    }
                }
              //request.setAttribute("email", email);
              request.setAttribute("filename", filename);
               RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
           }
                }
           }
           else{
                         out.println("<script type=\"text/javascript\">");
                         out.println("alert('User or password incorrect');");
                         out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("teacher_login_form.jsp");
			rd.include(request, response); 
           }
              
          
        } catch (SQLException ex) {
            Logger.getLogger(teacher_login_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(teacher_login_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          
        }
        
    }

   


