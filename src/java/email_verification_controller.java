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
@WebServlet(urlPatterns = {"/email_verification_controller"})
public class email_verification_controller extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");
        String filename=request.getParameter("filename");
        String user=email;
        String to=email;
        System.out.println(user+pass);
        String subject="Email verification from Nasim Classroom!";
        
        String msg = String.format("Your email is successfully verified");
        Mailer.send(user,pass,to,subject,msg);
        
         String secret = email;
        String strToEncrypt = pass;
        AESEncryptionDecryption ae = new AESEncryptionDecryption();
        String encryp_pass = ae.encrypt(strToEncrypt, secret);
        
        try {
            PreparedStatement ps3=DBConnection.getConnection().prepareStatement("delete from email where email=?");
            ps3.setString(1, email);
            ps3.executeUpdate();
            
             PreparedStatement ps0 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(email) FROM email WHERE email=? ),\"post not yet\") as email");
             ps0.setString(1, email);
           
            ResultSet rs0 =   ps0.executeQuery();
           
            if(rs0.next()){
                int stuno = Integer.parseInt(rs0.getString(1));
                if(stuno==0){
            
            
            PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into email values(?,?,?) ");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, encryp_pass);
            int n=ps.executeUpdate();
                if(n>0) {
			//response.getWriter().println("Successfully uploaded");
                       
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
                            session.setAttribute("ev", "ev");
                            session.setAttribute("ns", "no");
                            session.setAttribute("se", "no");
                            
                        session.setAttribute("email", email);
                       session.setAttribute("name", name);
                        
                        request.setAttribute("filename",filename);
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
                        request.setAttribute("name", name);
			request.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("email_verification.jsp");
			rd.forward(request, response);
                }
                }
                else{
                     out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal (  'oo!' ,'Already email exists or verified, now check again your gmail box',  'error' );");
			out.println("});");
			out.println("</script>");
			request.setAttribute("name", name);
                        request.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.include(request, response);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(email_verification_controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(email_verification_controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
