/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.post;
import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/student_post_list_controller"})
public class student_post_list_controller extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
       String code =(String) getServletContext().getAttribute("code");
     //String code1 = request.getParameter("code");
      // String email1 = request.getParameter("email");
       //String cwmsg =(String) getServletContext().getAttribute("msg");
       String semail =(String) getServletContext().getAttribute("email");
      String spass =(String) getServletContext().getAttribute("spass");
       System.out.println(code+semail+spass);
        //String code1="ict-3109";
       // String email1 ="nasimzafrulhasan@gmail.com";
       // String spass="123";
       // System.out.println(email);
       //String pemail =(String) getServletContext().getAttribute("pemail");
       //String pname =(String) getServletContext().getAttribute("pname");
       //String pfilename =(String) getServletContext().getAttribute("pfilename");
        //System.out.println(pfilename);
           PrintWriter out = response.getWriter();
        //request.setAttribute("cwmsg", cwmsg);
       
         ArrayList<post> postlist = new ArrayList<post>();
        try {
           PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(course_code) FROM post WHERE course_code=?),\"post not yet\") as course_code  ");
             ps0.setString(1, code);
              // ps0.setString(2, code1);
             //ps0.setString(2, code1);
            ResultSet rs0 =   ps0.executeQuery();
            if(rs0.next()){
                int present = Integer.parseInt(rs0.getString(1));
                if(present==0){
                          
                          
                           String npms=String.format("No post uploaded yet in '%s'.", code);
                           //request.setAttribute("npmsg",npmsg);
                            //session.setAttribute("npu", "npu");
                            //session.setAttribute("email", atecemail);
                           // request.setAttribute("filename", afilename); 
                           //request.setAttribute("email", semail);
                           //request.setAttribute("pass", spass);
                            //request.getRequestDispatcher("course_login_form.jsp").forward(request,response);
               // }
                //else{
                
                
                
               /* PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from post where course_code=? ");
            ps.setString(1, code);
            // ps.setString(2, code1);
            ResultSet rs =   ps.executeQuery();
                    System.out.println(rs);
                    System.out.println("");
            while(rs.next()){*/
                
                post po =new post();
               /* //po.setCode(rs.getString("course_code"));
                po.setName(rs.getString("filename"));
                po.setBody(rs.getString("body"));
                 po.setTime(rs.getString("date"));
                 System.out.println(rs.getString("date"));
                po.setPoster_filename(rs.getString("poster_filename"));
                po.setPoster_name(rs.getString("poster_name"));*/
                
                po.setName("");
                po.setBody("");
                 po.setTime("");
                 System.out.println("");
                po.setPoster_filename("");
                po.setPoster_name("Welcome to nasim classroom. Your teacher doesn't share anything yet . Thank you and stay this site ");
                //po.setCourse_name(rs.getString("course_name"));
                //System.out.println(po+"postlist form");
               // System.out.println("POSTBNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
                postlist.add(po);
                
                request.setAttribute("postlist",postlist);
                //session.setAttribute("code", code);
                //request.setAttribute("code", code1);
                request.setAttribute("email", semail);
                request.setAttribute("spass", spass);
           // }
                
            
             PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=? ");
             ps1.setString(1, code);
             // ps1.setString(2, code1);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 String course_name = rs1.getString("course_name");
                 //System.out.println(course_name);
                 session.setAttribute("course_name", course_name);
                 String tecname = rs1.getString("teacher_name");
                session.setAttribute("tecname", tecname);
                 //System.out.println(tecname);
                 String tecemail=rs1.getString("teacher_email");
                 session.setAttribute("tecemail",tecemail);
                 System.out.println(course_name+tecname+tecemail);
                 PreparedStatement ps7 = DBConnection.getConnection().prepareStatement("select * from teacher_list where email=?");
                 ps7.setString(1, tecemail);
                 ResultSet rs7=ps7.executeQuery();
             if(rs7.next()){
               String tecfilename = rs7.getString("filename");
               session.setAttribute("tecfilename", tecfilename);
                 System.out.println(tecfilename);
             }
             }
             PreparedStatement ps3 = DBConnection.getConnection().prepareStatement("select * from student_account where email=?");
             ps3.setString(1, semail);
             //ps3.setString(2, email1);
              
             ResultSet rs3=ps3.executeQuery();
             if(rs3.next()){
                 session.setAttribute("semail", semail);
                 System.out.println("dhdhsd");
                 String sname = rs3.getString("name");
                 session.setAttribute("sname", sname);
                 //String tecname = rs1.getString("teacher_name");
               
                String classid = rs3.getString("id");
                session.setAttribute("sid", classid);
                String filename=rs3.getString("filename");
                request.setAttribute("sfilename", filename);
                session.setAttribute("sfilename", filename);
                 //System.out.println(tecname);
                 System.out.println(filename+semail+classid+sname);
                 System.out.println("filename paisi");
             
             PreparedStatement ps6 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(id) FROM student_list WHERE (course_code=? and id=?) or ( course_code=? and  email=?)),\"post not yet\") as id ");
             ps6.setString(1, code);
             //ps6.setString(2, code1);
             ps6.setString(2, classid);
             ps6.setString(3, code);
              //ps6.setString(5, code1);
             ps6.setString(4, semail);
               //ps6.setString(7, email1);
             ResultSet rs6=ps6.executeQuery();
             if(rs6.next()){
                 int count = Integer.parseInt(rs6.getString(1));
                 if(count==0){
             
              PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("insert into student_list values(?,?,?,?,?)");
             ps5.setString(1, sname);
              ps5.setString(2, semail);
               //ps5.setString(3, email1);
              ps5.setString(3, classid);
              ps5.setString(4, code);
             // ps5.setString(6, code1);
              
                ps5.setString(5, filename); 
                
              int n=ps5.executeUpdate();
                 }
             }
             } 
                    System.out.println(code);
             session.setAttribute("ncw", "no");
             //String npms="dhfdhfhdb";
             session.setAttribute("code", code);
             request.setAttribute("npmsg", npms);
             request.getRequestDispatcher("student_post_list.jsp").forward(request,response);
                
                }
                
                //else part
                
            
            else{
                  
                    PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from post where course_code=? ");
            ps.setString(1, code);
            // ps.setString(2, code1);
            ResultSet rs =   ps.executeQuery();
            while(rs.next()){
                
                post po =new post();
                //po.setCode(rs.getString("course_code"));
                po.setName(rs.getString("filename"));
                po.setBody(rs.getString("body"));
                 po.setTime(rs.getString("date"));
                 System.out.println(rs.getString("date"));
                po.setPoster_filename(rs.getString("poster_filename"));
                po.setPoster_name(rs.getString("poster_name"));
                //po.setCourse_name(rs.getString("course_name"));
                System.out.println(po);
                postlist.add(po);
                
                request.setAttribute("postlist",postlist);
                //session.setAttribute("code", code);
                //request.setAttribute("code", code1);
                request.setAttribute("email", semail);
                request.setAttribute("spass", spass);
            }
                
            
             PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=? ");
             ps1.setString(1, code);
             // ps1.setString(2, code1);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 String course_name = rs1.getString("course_name");
                 System.out.println(course_name);
                 session.setAttribute("course_name", course_name);
                 String tecname = rs1.getString("teacher_name");
                session.setAttribute("tecname", tecname);
                 System.out.println(tecname);
                 String tecemail=rs1.getString("teacher_email");
                 session.setAttribute("tecemail",tecemail);
                 PreparedStatement ps7 = DBConnection.getConnection().prepareStatement("select * from teacher_list where email=?");
                 ps7.setString(1, tecemail);
                 ResultSet rs7=ps7.executeQuery();
             if(rs7.next()){
               String tecfilename = rs7.getString("filename");
               session.setAttribute("tecfilename", tecfilename);
             }
             }
             PreparedStatement ps3 = DBConnection.getConnection().prepareStatement("select * from student_account where email=?");
             ps3.setString(1, semail);
             //ps3.setString(2, email1);
              
             ResultSet rs3=ps3.executeQuery();
             if(rs3.next()){
                 session.setAttribute("semail", semail);
                 System.out.println("dhdhsd");
                 String sname = rs3.getString("name");
                 session.setAttribute("sname", sname);
                 //String tecname = rs1.getString("teacher_name");
               
                String classid = rs3.getString("id");
                session.setAttribute("sid", classid);
                String filename=rs3.getString("filename");
                request.setAttribute("sfilename", filename);
                session.setAttribute("sfilename", filename);
                 //System.out.println(tecname);
                 System.out.println(filename);
                 System.out.println("dkfjfjf");
             
             PreparedStatement ps6 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(id) FROM student_list WHERE (course_code=? and id=?) or ( course_code=? and  email=?)),\"post not yet\") as id ");
             ps6.setString(1, code);
             //ps6.setString(2, code1);
             ps6.setString(2, classid);
             ps6.setString(3, code);
              //ps6.setString(5, code1);
             ps6.setString(4, semail);
               //ps6.setString(7, email1);
             ResultSet rs6=ps6.executeQuery();
             if(rs6.next()){
                 int count = Integer.parseInt(rs6.getString(1));
                 if(count==0){
             
              PreparedStatement ps5 = DBConnection.getConnection().prepareStatement("insert into student_list values(?,?,?,?,?)");
             ps5.setString(1, sname);
              ps5.setString(2, semail);
               //ps5.setString(3, email1);
              ps5.setString(3, classid);
              ps5.setString(4, code);
             // ps5.setString(6, code1);
              
                ps5.setString(5, filename); 
                
              int n=ps5.executeUpdate();
                 }
             }
                }
             session.setAttribute("code", code);
                     session.setAttribute("ncw", "no");
                    request.getRequestDispatcher("student_post_list.jsp").forward(request,response);
                    }
                
                
                //else part
            
            }
            //}
        } catch (SQLException ex) {
            Logger.getLogger(select_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(select_course_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        //session.setAttribute("name", atecname);
        //session.setAttribute("email", atecemail);
          //request.setAttribute("filename", afilename);  
           
          
    }
}
    

