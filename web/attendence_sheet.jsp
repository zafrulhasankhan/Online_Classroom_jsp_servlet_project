<%-- 
    Document   : attendence_sheet
    Created on : Jun 2, 2020, 3:36:11 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.people"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/courselist.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="heading" align="center">
            <h2><u>Attendence Form</u></h2>
        </div>
        <form action="attendence_insert_controller" method="post">
         <div class="table-responsive">
        <table class="table">
                                
             <thead class="theading">
      <tr>
        <th class="hname" style="border: 3px solid red;">Class ID</th>
      <th class="hdept" style="border: 3px solid red; "> Student Name</th>
        <th class="hname" style="border: 3px solid red;">Present </th>
        <th class="hdept" style="border: 3px solid red; "> Absent</th>
      </tr>
    </thead>
    <tbody>
        <%
                ArrayList<people> attendlist =(ArrayList) request.getAttribute("attendlist");
                
                int i = 0;
                for(people po : attendlist){
                    i++;
                
        %>
      <tr>
          <td class="bname"><input type="text" hidden=""   value="<%= po.getClass_id()%>" name="id"/><%= po.getClass_id()%></td>
        <td class="bdept"><input type="text" hidden="" value="<%= po.getStudentlist()%>" name="name"/><%= po.getStudentlist()%></td>
        <td class="bname"><input type="checkbox" name="attend" value="present"/> </td>
        <td class="bdept"><input type="checkbox" name="attend" value="Absent"/></td>
      </tr>  
      <%
      }
      %>
      
    </tbody>
  </table>
         </div>
      <div class="home">
      <input type="submit" value="Save"/>
      </div>
        </form>
    </body>
</html>
