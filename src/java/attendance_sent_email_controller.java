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
@WebServlet(urlPatterns = {"/attendance_sent_email_controller"})
public class attendance_sent_email_controller extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       String stuids="";
       String stuemails="";
       String stunames="";
       String marks="";
       String presents="";
       String totals="";
       String pers="";
String stuname[]=request.getParameterValues("stuname");
String stuid[]=request.getParameterValues("stuid");
String stuemail[]=request.getParameterValues("stuemail");
String present[]=request.getParameterValues("present");
String total[]=request.getParameterValues("total");
String per[]=request.getParameterValues("per");
for(int i=0;i<stuid.length;i++){
        
        stuids=stuid[i];
        stuemails=stuemail[i];
        stunames=stuname[i];
        presents=present[i];
        totals=total[i];
        pers=per[i];
        String code= request.getParameter("code");
        
        System.out.println(stuids);
    
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String to=stuemails;
         
        String subject="Attendance reports !";
        
        String msg = String.format("course code: %s,Your ID :%s, Name: %s ,presented class:%s,Total class:%s,Percentage:%s",code,stuids,stunames,presents,totals,pers );
        
        Mailer.send(to,subject,msg);

        out.print("message has been successfully...");
        out.close();

        
    }

   
    }

 

}
