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
@WebServlet(urlPatterns = {"/email_pass_for_verify"})
public class email_pass_for_verify extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String email=request.getParameter("email");
        String name =request.getParameter("name");
        request.setAttribute("name", name);
              request.setAttribute("email", email);
               RequestDispatcher rd = request.getRequestDispatcher("email_verification.jsp");
               rd.forward(request,response);
    }

    

    
}
