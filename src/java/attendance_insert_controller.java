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
@WebServlet(urlPatterns = {"/attendance_insert_controller"})
public class attendance_insert_controller extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
       String adtecemail=request.getParameter("adtecemail");
       String adname=request.getParameter("adtecname");
        
       String adfilename=request.getParameter("adfilename");
       String classno=request.getParameter("classno");
     String code=request.getParameter("code");
        System.out.println(adtecemail+adname+adfilename+"djjd");
     PrintWriter out = response.getWriter();
        try {
            PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(Attendence) FROM attendence_list WHERE course_code=? and class_no=?),\"0\" ) as Attendence");
             ps0.setString(1, code);
                ps0.setString(2, classno);
                ResultSet rs =ps0.executeQuery();
                if(rs.next()){
                    //String clasno = rs.getString("class_no");
                   // System.out.println(clasno);
                   int clasno=Integer.parseInt(rs.getString(1));
                    if(clasno!=0)
                    {
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
                            
			      
                    String ssa = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Hey  !</strong>  Already  Exists 'class no.' . The 'class no' should be unique ...  \n" +
"            </div>";
                     request.setAttribute("ssa", ssa);
                    session.setAttribute("email", adtecemail);
                            session.setAttribute("name", adname);
                            request.setAttribute("filename", adfilename);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response); 
                    }
                    else{
         /*multiple radio */               
        String te=request.getParameter("te");
        int j=Integer.parseInt(te);
        String attend[] = new String[j];
        int k=0;
        /*multiple radio */
        
       String ids="";
       String names="";
       String attends="";
       String codes="";
String id[]=request.getParameterValues("id");
String name[]=request.getParameterValues("name");
//String attend[]=request.getParameterValues("attend");
//String code[]=request.getParameterValues("code");
        
for(int i=0;i<j;i++){
    k++;
    ids=id[i];
    names=name[i];
   // attends=attend[i];
    //codes=code[i];
    String date=request.getParameter("date");
     String classno1=request.getParameter("classno");
     String code1=request.getParameter("code");
     /*multiple radio */
     attend[i] = request.getParameter(Integer.toString(k));
     attends=attend[i];
     /*multiple radio */
    System.out.println(attends);
            try {
                
                PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into attendence_list values('"+classno1+"','"+ids+"','"+names+"','"+attends+"','"+date+"','"+code1+"')");
                int n=ps.executeUpdate();
            
                 
		if(n>0) {
                    
			//response.getWriter().println("Successfully uploaded");
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
                            
				      
                    String ssa = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Successfully  !</strong> save Attendance  ...  \n" +
"            </div>";
                     request.setAttribute("ssa", ssa);
                            session.setAttribute("email", adtecemail);
                            session.setAttribute("name", adname);
                            request.setAttribute("filename", adfilename);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
                        
                        
		}
                else{
			
			
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.include(request, response);
		}
              
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(attendance_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(attendance_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
                    }
                }
        } catch (SQLException ex) {
            Logger.getLogger(attendance_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(attendance_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        
        
     /*   String ids="";
       String names="";
       String attends="";
       String codes="";
String id[]=request.getParameterValues("id");
String name[]=request.getParameterValues("name");
String attend[]=request.getParameterValues("attend");
//String code[]=request.getParameterValues("code");
        
for(int i=0;i<id.length;i++){
    ids=id[i];
    names=name[i];
    attends=attend[i];
    //codes=code[i];
    String date=request.getParameter("date");
     String classno1=request.getParameter("classno");
     String code1=request.getParameter("code");
    System.out.println(names);
            try {
                
                PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into attendence_list values('"+classno1+"','"+ids+"','"+names+"','"+attends+"','"+date+"','"+code1+"')");
                int n=ps.executeUpdate();
            
                 PrintWriter out = response.getWriter();
		if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  'successfully !' ,'saved Attendence',  'success' );");
			out.println("});");
			out.println("</script>");
			
			//RequestDispatcher rd = request.getRequestDispatcher("attendance_sheet.jsp");
			//rd.include(request, response);
                        
                        
		}
                else{
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'incorrect id or password !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.include(request, response);
		}
              
                    
                
            } catch (SQLException ex) {
                Logger.getLogger(attendance_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(attendance_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
*/
    
            
}
}