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
@WebServlet(urlPatterns = {"/email_verification_controller"})
public class email_verification_controller extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");
        System.out.println(pass);
        String user=email;
        String to=email;
         
        String subject="Email verification !";
        
        String msg = "Your email is successfully verified";
        Mailer.send(user,pass,to,subject,msg);
        
         String secret = email;
        String strToEncrypt = pass;
        AESEncryptionDecryption ae = new AESEncryptionDecryption();
        String encryp_pass = ae.encrypt(strToEncrypt, secret);
        
        try {
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into email values(?,?,?) ");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, encryp_pass);
            int n=ps.executeUpdate();
                if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                        out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  'successfully Email verified!' ,'Check your gmail inbox',  'success' );");
			out.println("});");
			out.println("</script>");
			request.setAttribute("name", name);
                        request.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
                        
                        
		}
                else{
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  'sorry!' ,'try again',  'error' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("email_verification.jsp");
			rd.include(request, response);
                }
        } catch (SQLException ex) {
            Logger.getLogger(email_verification_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(email_verification_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
