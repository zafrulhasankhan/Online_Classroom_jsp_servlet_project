/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/attendence_insert_controller"})
public class attendence_insert_controller extends HttpServlet {

   
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
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(attendence_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(attendence_insert_controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
}
}