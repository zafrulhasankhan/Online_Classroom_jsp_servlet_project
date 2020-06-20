<%-- 
    Document   : attendence_sheet
    Created on : Jun 2, 2020, 3:36:11 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.attend"%>
<%@page import="dao.people"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/course_list.css">
<link rel="stylesheet" href="css/peoplelist.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="navbar1">
  <a href="courselist_controller?code=${code}">Home</a>
  <a href="select_course_controller?code=${code}">view course</a>
  <div class="navbar-centered1">
      <a  class="active1">${code} | ${name}</a>
  </div>
  <div class="dropdown1">
    <button class="dropbtn1">  Attendance report   
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content1">
        
       
      
      
      <a href="individual_report_form.jsp?code=${code}">Individual Attendance report</a>
     
    </div>
  </div> 
</div>
        
        
  <br><div class="heading" align="center">
     <h2><u>Attendance Form by datewise</u></h2>
  </div><br><br>
  
  &emsp;
     
      <h5 style="color: red">&emsp;&emsp;&emsp;Course Teacher Name: ${tecname}</h5><br>
      <label class="datebf"><b>Date: ${date} </b></label>
      
     
      
     
      
      
      <div class="table-responsive">
        <table class="table">
                                
             <thead class="theading">
      <tr>
        <th class="hname" style="border: 3px solid red;">Class ID</th>
      <th class="hdept" style="border: 3px solid red; "> Student Name</th>
        <th class="hname" style="border: 3px solid red;">Attendance </th>
       
      </tr>
    </thead>
    <tbody>
        <%
                ArrayList<attend> attendlist =(ArrayList) request.getAttribute("attendlist");
                
                int i = 0;
                for(attend po : attendlist){
                    i++;
                
        %>
      <tr>
          <td class="bname"><%= po.getId()%></td>
        <td class="bdept"><%= po.getName()%></td>
        <td class="bname"><%=po.getAttendance()%> </td>
        
      </tr>  
      <%
      }
      %>
      
    </tbody>
  </table>
         </div>
      
       
    </body>
</html>
