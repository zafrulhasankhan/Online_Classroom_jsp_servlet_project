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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/post_sent_email_controller"})
public class post_sent_email_controller extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code =(String) getServletContext().getAttribute("code");
        System.out.println(code);
        try {
            PreparedStatement ps2 = DBConnection.getConnection().prepareStatement("select * from student_list  where course_code=? ");
            ps2.setString(1, code);
                ResultSet rs2=ps2.executeQuery();
                while(rs2.next()){
                 String to = rs2.getString("email");
                 
                    System.out.println(to);
                    String subject="Attendance reports !";
        
                    String msg = String.format("course code: %s",code );
        
                    //Mailer.send(to,subject,msg);

                    out.print("message has been successfully...");
                    out.close();
                }
        } catch (SQLException ex) {
            Logger.getLogger(post_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(post_sent_email_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   
}
