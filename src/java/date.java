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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hidden = request.getParameter("tot"); 
        String names="";
        int j=Integer.parseInt(hidden);
        String s[] = new String[j];
        int k=0;
        String name[]=request.getParameterValues("name");
        for (int i=0; i<j; i++){
        k++;
        names=name[i];
        System.out.println(names);
    s[i] = request.getParameter(Integer.toString(k)); 
    System.out.println(s[i]);
    }
        
        
        
       /*String date=request.getParameter("date");
       String co =(String) getServletContext().getAttribute("var");
       String code = request.getParameter("code");
       String age = request.getParameter("age");
       String ad = request.getParameter("ad");
        System.out.println(code);
        System.out.println(age);
        System.out.println(ad);
       //String co = (String) request.getAttribute("var");
        System.out.println(co);
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
request.getRequestDispatcher("datefind.jsp").forward(request,response);*/
      /* String emails="";
      String email[] =request.getParameterValues("stuemail");
        System.out.println(email);
   for(int i=0;i<email.length;i++){
       emails=email[i];
       System.out.println(emails);*/
   }
       
    }


