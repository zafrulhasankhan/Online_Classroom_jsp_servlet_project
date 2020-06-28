/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.to;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(urlPatterns = {"/marks_sent_email_controller"})
public class marks_sent_email_controller extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String marks="";
       String stuids="";
       String stuemails="";
String mark[]=request.getParameterValues("mark");
String stuid[]=request.getParameterValues("stuid");
String stuemail[]=request.getParameterValues("stuemail");
for(int i=0;i<stuid.length;i++){
        marks=mark[i];
        stuids=stuid[i];
        stuemails=stuemail[i];
        String code= request.getParameter("code");
        String classworkno = request.getParameter("workno");
        System.out.println(stuids);
    
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String to=stuemails;
         
        String subject="Classwork marks !";
        
        String msg = String.format("course code: %s,classwork no. :%s,Your ID :%s,Your marks:%s",code,classworkno,stuids,marks );
        
        Mailer.send(to,subject,msg);

        out.print("message has been successfully...");
        out.close();

        
    }

   
}
