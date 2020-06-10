/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.people;
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
@WebServlet(urlPatterns = {"/attendence_sheet_controller"})
public class attendence_sheet_controller extends HttpServlet {

   
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String code = request.getParameter("code");
        //System.out.println(code);
       
        //String cod="ict-2207";
        ArrayList<people> attendlist = new ArrayList<people>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from student_list  where course_code=?  ");
            ps.setString(1, code);
            ResultSet rs=ps.executeQuery();
             while(rs.next()){
                
                people po =new people();
                
                po.setStudentlist(rs.getString("name"));
               po.setClass_id(rs.getString("id"));
               
                 
                
                //po.setCourse_name(rs.getString("course_name"));
                //System.out.println(po);
                attendlist.add(po);
                
                request.setAttribute("attendlist",attendlist);
                request.setAttribute("code",code);
                
            }
             PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from add_course where course_code=? ");
             ps1.setString(1, code);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 String name = rs1.getString("course_name");
                 HttpSession session = request.getSession();
                session.setAttribute("name", name);
                 String tecname = rs1.getString("teacher_name");
                session.setAttribute("tecname", tecname);
                
             }
             PreparedStatement ps2= DBConnection.getConnection().prepareStatement("SELECT IFNULL((SELECT class_no FROM attendence_list WHERE course_code=? ORDER by class_no desc LIMIT 1), \"No Classes Yet\") as class_id");
             ps2.setString(1, code);
             ResultSet rs2=ps2.executeQuery();
             HttpSession session = request.getSession();
             if(rs2.next()){
                 //int class_no=0;
                 //session.setAttribute("class_no", class_no);
                String  class_no =rs2.getString(1);
              //if(class_no==null){
                  //rs.close();
                  //int clasno=0;
                  //session.setAttribute("class_no", clasno);
                  //if(rs2.getString("class_no")!=null){
                 // int classno=class_no+0;
                      session.setAttribute("class_no", class_no);
                  /*}
                  else if(rs.getString("class_no")==null){
                      String class_no1="no class held";
                      session.setAttribute("class_no", class_no1);
                  }*/
              //}
                System.out.println(class_no);
                 //else{
                
                         //}
                 
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(attendence_sheet_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(attendence_sheet_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
         request.getRequestDispatcher("attendence_sheet.jsp").forward(request,response);
    }

}