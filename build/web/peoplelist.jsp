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
        <link rel="stylesheet" href="css/peoplelist.css">
        <link rel="stylesheet" href="css/course_list.css">
        <link href="css/postlist.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
      
        
       <div class="navbar1">
  <a href="select_course_controller?code=${code}">Home</a>
  <a href="individual_report_form.jsp?code=${code}"> Attendance report</a>
  <div class="active11">
      <a  class="active1"> ${name} | ${code}</a>
  </div>
  <div class="dropdown1">
    <button class="dropbtn1">Menu Bar 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content1">
        
       
      
      
      
       <a href="return_create_classwork?code=${code}&email=${email}&spass=${spass}">Classwork list for students</a>
    </div>
  </div> 
</div>
      
      
      
       
      <div class="heading1" align="center">
          &ensp;<h4><u>People's details</u></h4>
            
      </div><br>
      <h4 style="color: red">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Course Teacher Name: ${tecname}</h4><br>
      <h4 style="color:red">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Student List : </h4><br>
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
