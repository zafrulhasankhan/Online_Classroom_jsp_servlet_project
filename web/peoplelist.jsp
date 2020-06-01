<%-- 
    Document   : peoplelist
    Created on : May 31, 2020, 11:34:49 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.people"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/courselist.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div class="heading" align="center">
            <h4>People's details</h4>
            
      </div><br>
      <h4 style="color: red">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Course Teacher Name: ${tecname}</h4><br>
    <div class="table-responsive">
                            <table class="table">
                                <thead class="theading">
      <tr>
        <th class="hname" style="border: 3px solid red;">Class ID</th>
      <th class="hdept" style="border: 3px solid red; "> Student Name</th>
        <th class="hemail" style="border: 3px solid red;">Email</th>
      </tr>
    </thead>
    <tbody>
        <%
                ArrayList<people> peoplelist =(ArrayList) request.getAttribute("peoplelist");
                
                int i = 0;
                for(people po : peoplelist){
                    i++;
                
        %>
      <tr>
        <td class="bname"><%= po.getClass_id()%></td>
        <td class="bdept"><%= po.getStudentlist()%></td>
        <td class="bemail"><%= po.getEmail()%></td>
      </tr>  
      <%
      }
      %>
      
    </tbody>
  </table>
       </div>
    </body>
</html>
