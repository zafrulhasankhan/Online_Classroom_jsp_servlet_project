<%-- 
    Document   : classwork_mark_list
    Created on : Jul 6, 2020, 4:44:45 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.classwork"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="css/course_list.css">
     <style>
           
            
            body
            {
                background-image:url("image/webback3_1.jpeg")
                    
            }
        </style>
    </head>
    <body>
        <div class="heading1" align="center">
          &ensp;<h4><u>Student's classwork Marks</u></h4>
          <h4 style="color:red; text-align: center;">Classwork no. : ${cwno} </h4><br>
            <h4 style="color:red; text-align: center;">Course code. : ${code} </h4><br>
      </div><br>
        
             
         <form action="all_student_mark_sent_email" method="get">     
        <input type="text" name="cw_no" value="${cwno}"  hidden="" placeholder="out of 10">
          <input type="text" name="code" value="${code}"  hidden="" placeholder="out of 10">
        <div class="table-responsive">
                            <table class="table">
                                <thead class="theading">
                                    <tr >
                                        <th class="hemail" style="border: 3px solid red; "><h5>Student ID.</h5></th>
                                        <th class="hdept" style="border: 3px solid red; "><h5>Email</h5></th>
                                        <th class="hemail" style="border: 3px solid red;"><h5>Marks</h5></th>
                                        
                                      
                                        
                                    </tr>
                                </thead><br>
                                <tbody>
        <%
                ArrayList<classwork> worklist =(ArrayList) request.getAttribute("worklist");
                
                int i = 0;
                for(classwork u : worklist){
                    i++;
                
        %>
        <tr>
           <td class="bemail"><%= u.getStudent_id()%></td>
            <td class="bdept"><%= u.getStudent_email()%></td>
        <td class="bemail"><%= u.getMark() %></td>
                          
      </tr>
            <input type="text" name="stuid" value="<%= u.getStudent_id()%>" hidden="" >
            <input type="text" name="stuemail" value="<%= u.getStudent_email()%>" hidden=""  > 
            <input type="text" name="stumark" value="<%= u.getMark()%>" hidden="" >
      <%
      }
      %>
      
    </tbody>
                            
    </table>
       
        </div> 
      <div class="save">
          <input type="submit" value="click for email to sent classwork marks" class="saveatr" />
      </div>
         </form>
    </body>
</html>


