<%-- 
    Document   : All_student_attendance_report
    Created on : Jun 30, 2020, 8:36:00 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.allstu_report"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="css/course_list.css">
      <link rel="stylesheet" href="css/peoplelist.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="navbar1">
  <a href="select_course_controller?code=${code}">Home</a>
  <a href="#news">News</a>
  <div class="navbar-centered1">
      <a  class="active1">${code} | ${name}</a>
  </div>
  <div class="dropdown1">
    <button class="dropbtn1">Menu 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content1">
        
       
      
      
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  </div> 
</div>
           <form action="attendance_sent_email_controller" method="get"> 
               <input type="text" name="code" value="${code}"  hidden="" placeholder="out of 10">
        <div class="heading" align="center">
            <h2><u>Student Attendance Report</u></h2>
        </div>
          
             
        
        <div class="table-responsive">
                            <table class="table">
                                <thead class="theading">
                                    <tr >
                                        <th class="hname" style="border: 3px solid red;"><h5>Student ID</h5></th>
                                        <th class="hdept" style="border: 3px solid red; "><h5>Student Name</h5></th>
                                        <th class="hemail" style="border: 3px solid red;"><h5>No. of presented class</h5></th>
                                        <th class="hview" style="border: 3px solid red;"><h5>No. of total class</h5></th>
                                        <th class="hdelete" style="border: 3px solid red;"><h5>Percentage</h5></th>
                                         
                                    </tr>
                                </thead><br>
                                <tbody>
        <%
                ArrayList<allstu_report> allreportlist =(ArrayList) request.getAttribute("allreportlist");
                
                int i = 0;
                for(allstu_report u : allreportlist){
                    i++;
               int present = u.getPresentno(); 
               int total = u.getTotalday();
               float per=(((float)present)/total)*100;
        %>
        
        <tr>
            <td class="bname"><%= u.getClassid()%></td>
            <td class="bdept"><%=u.getStudent_name()%></td>
        <td class="bemail"><%= present%></td>
        <td class="bview"><%=total%> </td>
        <td class="bdelete"><%=per%> </td>
        
      </tr>  
      
            <input type="text" name="stuemail" value="<%= u.getEmail()%>" hidden="" >
            <input type="text" name="stuid" value="<%= u.getClassid()%>" hidden="" > 
            <input type="text" name="stuname" value="<%= u.getStudent_name()%>" hidden="" >
            <input type="text" name="present" value="<%= present%>" hidden="" >
            <input type="text" name="total" value="<%=total%>" hidden="" >
            <input type="text" name="per" value="<%=per%>" hidden="" >
        <%
            
      }
      %>
      </tbody>
                            
    </table>
        </div> 
      <div class="save">
          <input type="submit" value="click for email to sent Attendance report" class="saveatr" />
      </div>
           </form>
    </body>
</html>
