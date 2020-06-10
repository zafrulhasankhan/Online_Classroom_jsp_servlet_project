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
@WebServlet(urlPatterns = {"/date"})
public class date extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String date=request.getParameter("date");
        try {
            PreparedStatement ps1 = DBConnection.getConnection().prepareStatement("select * from attendence_list where date=? ");
            ps1.setString(1, date);
             ResultSet rs1=ps1.executeQuery();
             if(rs1.next()){
                 String name = rs1.getString("class_id");
                 HttpSession session = request.getSession();
                session.setAttribute("name", name);}
        } catch (SQLException ex) {
            Logger.getLogger(date.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(date.class.getName()).log(Level.SEVERE, null, ex);
        }
request.getRequestDispatcher("datefind.jsp").forward(request,response);
    }

}