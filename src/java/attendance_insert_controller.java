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
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/attendance_insert_controller"})
public class attendance_insert_controller extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String ids="";
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
     String classno=request.getParameter("classno");
     String code=request.getParameter("code");
    System.out.println(names);
            try {
                PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into attendence_list values('"+classno+"','"+ids+"','"+names+"','"+attends+"','"+date+"','"+code+"')");
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

    
}
}