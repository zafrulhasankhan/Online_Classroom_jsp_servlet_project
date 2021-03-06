/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/classwork_submit_controller"})
@MultipartConfig(maxFileSize = 16177216)
public class classwork_submit_controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cw_no = request.getParameter("cw_no");
        String code = request.getParameter("code");
        String sname = request.getParameter("sname");
        String sid = request.getParameter("sid");
        String email = request.getParameter("email");
        String pcom = request.getParameter("pcom");
        System.out.println(sid+cw_no);
        Part part = request.getPart("file");
         String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
        System.out.println(filename);
        PrintWriter out = response.getWriter();
        try {
            PreparedStatement ps0=DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM classwork_submit WHERE student_id=? and classworkno=?),\"post not yet\") as course_code ");
            ps0.setString(1, sid);
             ps0.setString(2, cw_no);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int count = Integer.parseInt(rs0.getString(1));
                if(count!=0){
                String csc1 = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Ohh  !</strong> Classwork Already submitted...  \n" +
"            </div>";
                        
                   request.setAttribute("csc", csc1);
                   request.setAttribute("email", email);
                   request.setAttribute("code", code);
			RequestDispatcher rd = request.getRequestDispatcher("classwork_submit_msg.jsp");
			rd.forward(request, response); 
                }else{
                    
                    try {
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into classwork_submit values(?,?,?,?,?,?,?,?)");
            ps.setString(1, cw_no);
            ps.setString(2, code);
            ps.setString(3, sname);
            ps.setString(4, sid);
            ps.setString(5, filename);
            InputStream is = part.getInputStream();
	    ps.setBlob(6, is);
            ps.setString(7, email);
            ps.setString(8, pcom);
            int n=ps.executeUpdate();
              HttpSession session = request.getSession();
		if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        String csc = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Successfully !</strong> Classwork submitted...  \n" +
"            </div>";
                        
                   request.setAttribute("csc", csc);
                   request.setAttribute("email", email);
                   request.setAttribute("code", code);
			RequestDispatcher rd = request.getRequestDispatcher("classwork_submit_msg.jsp");
			rd.forward(request, response); 
                        
                       
		}
                else{
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'something went wrong  !' ,  ' ' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
			
		}
        } catch (SQLException ex) {
            Logger.getLogger(classwork_submit_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classwork_submit_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(classwork_submit_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(classwork_submit_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}