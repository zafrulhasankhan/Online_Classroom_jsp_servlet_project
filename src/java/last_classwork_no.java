/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/last_classwork_no"})
public class last_classwork_no extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     String code = request.getParameter("code");
        System.out.println(code);
        try {
            PreparedStatement ps2= DBConnection.getConnection().prepareStatement("SELECT IFNULL((SELECT classworkno FROM classwork WHERE course_code= ?  ORDER by classworkno desc LIMIT 1), \"No classwork create Yet\") as body");
             ps2.setString(1, code);
             ResultSet rs2=ps2.executeQuery();
             HttpSession session = request.getSession();
             if(rs2.next()){
                 
                String  cw_no =rs2.getString(1);
              
                      session.setAttribute("cw_no", cw_no);
                      session.setAttribute("code", code);
                System.out.println(cw_no);
             }
                 //else{
        } catch (SQLException ex) {
            Logger.getLogger(last_classwork_no.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(last_classwork_no.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("create_classwork_form.jsp").forward(request,response);
    }

    }
    