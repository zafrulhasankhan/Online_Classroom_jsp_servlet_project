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
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = "John John";
 
        request.setAttribute("name", fullName);
 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("newjsp.jsp");
 
        requestDispatcher.forward(request, response);}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = "John John";
 
        request.setAttribute("name", fullName);
 
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("newjsp.jsp");
 
        requestDispatcher.forward(request, response);
    }

    

}
