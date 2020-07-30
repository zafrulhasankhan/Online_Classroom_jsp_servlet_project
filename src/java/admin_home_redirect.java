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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/admin_home_redirect"})
public class admin_home_redirect extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String email = request.getParameter("email");
       String name = request.getParameter("name");
       String filename=request.getParameter("filename");
        System.out.println(name+email);
       HttpSession session = request.getSession();
                            session.setAttribute("ssp", "no");
                          session.setAttribute("nos", "no");
                          session.setAttribute("sac", "no");
                           session.setAttribute("dc", "no");
                           session.setAttribute("ae", "no");
                           session.setAttribute("cp", "no");
                            session.setAttribute("np", "no");
                            session.setAttribute("ncm", "no");
                            session.setAttribute("nwc", "no");
                            session.setAttribute("asa", "no");
                             session.setAttribute("ev", "no");
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "no");
                session.setAttribute("email", email);
                session.setAttribute("name", name);
                request.setAttribute("filename", filename);
                RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
               rd.forward(request,response);
    }

  
}
