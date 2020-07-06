<%-- 
    Document   : course_list_2
    Created on : Jun 25, 2020, 7:27:31 PM
    Author     : Zafrul Hasan Nasim
--%>

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
        
        <div class="heading" align="center">
            <h2>All course's</h2>
        </div>
             
             
        
        <div class="table-responsive">
                            <table class="table">
                                <thead class="theading">
                                    <tr >
                                        
                                        <th class="hdept" style="border: 3px solid red; "><h5>Course Name</h5></th>
                                        <th class="hemail" style="border: 3px solid red;"><h5>Course code</h5></th>
                                        
                                         <th class="hview" style="border: 3px solid red;"><h5>Attendance</h5></th>
                                        <th class="hemail" style="border: 3px solid red;"><h5> Classwork</h5></th>
                                        <th class="hview" style="border: 3px solid red;"><h5>Show Classwork </h5></th>
                                        
                                    </tr>
                                </thead><br>
                                <tbody>
        <%
                ArrayList<course> course_list =(ArrayList) request.getAttribute("course_list");
                
                int i = 0;
                for(course u : course_list){
                    i++;
                
        %>
        <tr>
            
            <td class="bdept"><%= u.getName()%></td>
        <td class="bemail"><%= u.getCode()%></td>
        <td class="bview"><%out.print("<a href='attendance_sheet_controller?code="+u.getCode()+"'</a>");%>Take Attendance & show attendance report</td>
        <td class="bemail"><%out.print("<a href='last_classwork_no?code="+u.getCode()+"'</a>");%>Create Classwork</td>
        <td class="bview"><%out.print("<a href='all_classwork_codewise?code="+u.getCode()+"'</a>");%> show classwork and marks</td>
        
      </tr>  
      <%
      }
      %>
      
    </tbody>
                            
    </table>
        </div>
      <div class="home">
          <a href="index.jsp" style="color: white; align-content: right; "><h5>Home</h5></a>
      </div>
        
    </body>
</html>

