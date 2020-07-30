/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/stu_panel_home_controiller"})
public class stu_panel_home_controiller extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
       String spass = request.getParameter("spass");
        String code = request.getParameter("code");
        //String semail1 =(String) getServletContext().getAttribute("email");
      //String code1 =(String) getServletContext().getAttribute("code");
       
      
     // getServletContext().setAttribute("code",code1);
               //getServletContext().setAttribute("email",semail1);
           getServletContext().setAttribute("code",code);
               getServletContext().setAttribute("email",email);
               getServletContext().setAttribute("spass",spass);
               RequestDispatcher rd=getServletContext().getRequestDispatcher("/student_post_list_controller");
               rd.forward(request,response);
        
    }
}