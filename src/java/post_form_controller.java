/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.DBConnection;
import java.io.InputStream;
import static java.lang.ProcessBuilder.Redirect.to;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(name = "post_form_controller", urlPatterns = {"/post_form_controller"})
@MultipartConfig(maxFileSize =32354432)
public class post_form_controller extends HttpServlet {
//private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
            String code=request.getParameter("code");
                //String code="ict-3109";
                String tecname="";
                String course_name="";
		String user="";
                String pass="";
                String atecname=request.getParameter("name");
                String atecemail=request.getParameter("email");
                String afilename=request.getParameter("filename");
                String semail=request.getParameter("semail");
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
                       ps.setString(6, afilename);
                       ps.setString(7, atecname);
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
                             session.setAttribute("ssp", "ssp");
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
                            session.setAttribute("name", atecname);
                            session.setAttribute("email", atecemail);
                            request.setAttribute("filename", afilename);        
                            request.getRequestDispatcher("admin_main.jsp").forward(request,response);
                            /*getServletContext().setAttribute("code",code);
               getServletContext().setAttribute("pemail",atecemail);
               getServletContext().setAttribute("pname", atecname);
                getServletContext().setAttribute("pfilename", afilename);
               RequestDispatcher rd=getServletContext().getRequestDispatcher("/select_course_controller");
               rd.forward(request,response);*/
                       }
                       else{
                           
                           session.setAttribute("email", atecemail);
                           session.setAttribute("name", atecname);
                           request.setAttribute("filename", afilename);
                           RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
                           rd.forward(request,response);
                           
                       }
                   }catch(Exception e) {System.out.println(e);}
               }
               
               else{
                   
               }
	}

}

