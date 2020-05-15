/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/admin_login_controller"})
public class admin_login_controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       String name =null;
       String pass=null;
         name = request.getParameter("name");
        pass = request.getParameter("pass");
        System.out.println(name);
        String name1="nasim";
        String pass1="123";
        if(( name1.equals(name))&&pass1.equals(pass)){
           request.getRequestDispatcher("admin_main.jsp").forward(request,response);
        }
        else{
             request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

   

}
