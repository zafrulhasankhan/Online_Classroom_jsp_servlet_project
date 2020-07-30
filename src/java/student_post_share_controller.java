/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/student_post_share_controller"})
@MultipartConfig(maxFileSize =32354432) 
public class student_post_share_controller extends HttpServlet {

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
            String code=request.getParameter("code");
                //String code="ict-3109";
                String tecname="";
                String course_name="";
		String user="";
                String pass="";
                String sname=request.getParameter("name");
                String semail=request.getParameter("email");
                String sfilename=request.getParameter("filename");
                //String semail=request.getParameter("semail");
		Part part = request.getPart("image");// we get path of the image
                String body = request.getParameter("body");
               String name=Paths.get(part.getSubmittedFileName()).getFileName().toString(); 
                
               if(!"".equals(request.getParameter("email"))){
                   try {                   
                       PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into post values(?,?,?,?,?,?,?)");
                       
                       ps.setString(1, code);
                       ps.setString(2, name);
                       InputStream is = part.getInputStream();
                       ps.setBlob(3, is);
                       ps.setString(4, body);
                       
                       Date date = new Date();
                       SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
                       
                       DateFor = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
                        String stringDate = DateFor.format(date);
                       //System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z :"+stringDate);
                       //java.util.Date now = new java.util.Date();
                      // java.sql.Timestamp c = new java.sql.Timestamp(now.getTime());
                       ps.setString(5, stringDate);
                       ps.setString(6, sfilename);
                       ps.setString(7, sname);
                       int n=ps.executeUpdate();
                       
                       PrintWriter out = response.getWriter();
                       if(n>0) {
                           
                           
                           PreparedStatement ps3=DBConnection.getConnection().prepareStatement("select * from add_course where course_code=?");
                           ps3.setString(1, code);
                           ResultSet rs3 = ps3.executeQuery();
                           if(rs3.next()){
                               String email = rs3.getString("teacher_email");
                               user=email;
                               PreparedStatement ps4=DBConnection.getConnection().prepareStatement("select * from email where email=?");
                               ps4.setString(1, email);
                               ResultSet rs1 = ps4.executeQuery();
                               if(rs1.next()){
                                   AESEncryptionDecryption ae = new AESEncryptionDecryption();
                                   String pass1 = rs1.getString("pass");
                                   String decryp_pass= ae.decrypt(pass1, email);
                                   pass=decryp_pass;
                                   
                               }
                           }
                           
                           PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=?");
                           ps5.setString(1, code);
                           ResultSet rs5 = ps5.executeQuery();
                           
                           if(rs5.next()){
                               tecname=rs5.getString("teacher_name");
                               course_name = rs5.getString("course_name");
                           }
                           
                           PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from student_list where course_code=?");
                           ps1.setString(1, code);
                           ResultSet rs = ps1.executeQuery();
                           
                           while(rs.next()){
                               
                               String email = rs.getString("email");
                               String stuname = rs.getString("name");
                               
                               System.out.println(email);
                               
                               String to=email;
                               
                               String subject=" Announcement !";
                               
                               String msg = String.format("Hi %s , %s posted a new announcement in %s . %n%nAnnouncement: %s  %n%n'%s' file has been uploaded.......visit classroom to see more",stuname,tecname,course_name,body,name);
                               
                               Mailer.send(user,pass,to,subject,msg);
                               
                               
                               
                           }
                             
                           // getServletContext().setAttribute("code",code);
               //getServletContext().setAttribute("email",semail);
               //getServletContext().setAttribute("spass",spass);
                String sspu = "<div class=\"alert alert-warning\" style=\"display:inline-table; background:green; color:white\">\n" +
"                <span  class=\"closebtn\" Style=\"float:right; cursor: pointer; color:white;animation: bymove 4s infinite;\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +
"                <strong>Successfully !</strong> Post Upload and sent to all people...  \n" +
"            </div>";
                request.setAttribute("sspu", sspu);
               request.setAttribute("code", code);
               request.setAttribute("name", sname);
               request.setAttribute("email", semail);
               request.setAttribute("filename", sfilename);
               RequestDispatcher rd=request.getRequestDispatcher("student_post_share.jsp");
               rd.forward(request,response);
                 
                            /*getServletContext().setAttribute("code",code);
               getServletContext().setAttribute("pemail",atecemail);
               getServletContext().setAttribute("pname", atecname);
                getServletContext().setAttribute("pfilename", afilename);
               RequestDispatcher rd=getServletContext().getRequestDispatcher("/select_course_controller");
               rd.forward(request,response);*/
                       }
                       else{
                           
                           //getServletContext().setAttribute("code",code);
               //getServletContext().setAttribute("email",semail);
               //getServletContext().setAttribute("spass",spass);
                request.setAttribute("code", code);
               request.setAttribute("name", sname);
               request.setAttribute("email", semail);
               request.setAttribute("filename", sfilename);
               RequestDispatcher rd=request.getRequestDispatcher("student_post_share.jsp");
               rd.forward(request,response);
                           
                       }
                   }catch(Exception e) {System.out.println(e);}
               }
               
               else{
                   
               }
	}


}
