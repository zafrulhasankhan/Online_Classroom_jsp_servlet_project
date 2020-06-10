<%-- 
    Document   : attendence_sheet
    Created on : Jun 2, 2020, 3:36:11 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.people"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/courselist.css">
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
  <a href="select_course_controller?code=${code}">Home</a>
  <a href="#news">News</a>
  <div class="navbar-centered1">
      <a  class="active1">${code} | ${name}</a>
  </div>
  <div class="dropdown1">
    <button class="dropbtn1">Dropdown 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content1">
        
       
      
      
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  </div> 
</div>
        
        
  <br><div class="heading" align="center">
     <h2><u>Attendence Form</u></h2>
  </div><br><br>
  <label class="lastclass" ><b>Last class No : ${class_no}</b></label>
  &emsp;<form action="attendence_insert_controller" method="post">
     
      <h5 style="color: red">&emsp;&emsp;&emsp;Course Teacher Name: ${tecname}</h5><br>
      <label class="datebf"><b>Date: </b></label>
      <input type="date" id="birthday"  name="date" class="date" required="">
      <input type="text" value="${code}" name="code" hidden="" class="date">
      <label class="classbf"><b>Class No: </b></label>
      
      <input type="text"  name="classno" class="classno" placeholder="Enter Class NO." required="">
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
        <td class="bname"><input type="checkbox" required="" name="attend" value="present"/> </td>
        <td class="bdept"><input type="checkbox" required="" name="attend" value="Absent"/></td>
      </tr>  
      <%
      }
      %>
      
    </tbody>
  </table>
         </div>
      <div class="save">
      <input type="submit" value="Save"/>
      </div>
        </form>
    </body>
</html>
