<%-- 
    Document   : course_list
    Created on : May 15, 2020, 10:30:24 PM
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
                                        <th class="hemail" style="border: 3px solid red; "><h5>Serial No.</h5></th>
                                        <th class="hdept" style="border: 3px solid red; "><h5>Course Name</h5></th>
                                        <th class="hemail" style="border: 3px solid red;"><h5>Course code</h5></th>
                                        <th class="hview" style="border: 3px solid red;"><h5>view course</h5></th>
                                        <th class="hdelete" style="border: 3px solid red;"><h5>Add Feature</h5></th>
                                        
                                        <th class="hview" style="border: 3px solid red;"><h5>Delete</h5></th>
                                      
                                        
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
           <td class="bemail"><%= i%></td>
            <td class="bdept"><%= u.getName()%></td>
        <td class="bemail"><%= u.getCode()%></td>
        <td class="bview"><%out.print("<a href='select_course_controller?code="+u.getCode()+"'</a>");%><%=u.getCode()%></td>
        <td class="bdelete"><%out.print("<a href='post_form.jsp?code="+u.getCode()+"'</a>");%> Add post</td>
         
        <td class="bview"> <a href="delete_course_cotroller?code=<%=u.getCode()%>&tecname=${tecname}&tecemail=${tecemail} "><%out.print("Delete course");%></a></td>
                                           
      </tr>  
      <%
      }
      %>
      
    </tbody>
                            
    </table>
       
        
    </body>
</html>

