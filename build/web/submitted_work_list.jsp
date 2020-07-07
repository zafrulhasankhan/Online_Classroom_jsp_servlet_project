<%-- 
    Document   : submitted_work_list
    Created on : Jun 28, 2020, 12:19:20 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.classwork"%>
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
  <a href="select_course_controller?code=${code}">All post</a>
  <a href="#news"></a>
  <a href="#news"></a>
  <a href="#news"></a>
  <a href="#news"></a>
  <a href="#news"></a>
 <div class="active11">
      <a  class="active1"> ${name} | ${code}</a>
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
      
      
      
       
      <div class="heading1" align="center">
          &ensp;<h4><u>Student's classwork details</u></h4>
          <h4 style="color:red; text-align: center;">Classwork no. : ${classworkno} </h4><br>
            
      </div><br>
      <h4 style="color: red">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Course code: ${code}</h4><br>
      <form action="marks_sent_email_controller" method="get">
          <input type="text" name="workno" value="${classworkno}"  hidden="" placeholder="out of 10">
          <input type="text" name="code" value="${code}"  hidden="" placeholder="out of 10">
    <div class="table-responsive">
                            <table class="table">
                                <thead class="theading">
      <tr>
        <th class="hname" style="border: 3px solid red;">Class ID</th>
      <th class="hdept" style="border: 3px solid red; "> Student Name</th>
        <th class="hemail" style="border: 3px solid red;">submitted file</th>
         <th class="hdept" style="border: 3px solid red; "> Set marks</th>
      </tr>
    </thead>
    <tbody>
    
       <%
                ArrayList<classwork> worklist =(ArrayList) request.getAttribute("worklist");
                
                int i = 0;
                for(classwork po : worklist){
                    i++;
                
        %>
      <tr>
        <td class="bname"><%= po.getStudent_id()%></td>
        <td class="bdept"><%= po.getStudent_name()%></td>
        <td class="bemail"><a href="getimage_submitted_classwork.jsp?name=<%=po.getFilename()%>"> <%=po.getFilename()%></a></td>
    
        <td class="bdept"><input type="text" name="mark" placeholder="out of 10"></td>
    
   <input type="text" name="stuid" value="<%= po.getStudent_id()%>"  hidden="" placeholder="out of 10">
   <input type="text" name="stuemail" value="<%= po.getStudent_email()%>"   hidden="" placeholder="out of 10">
      </tr>  
      <%
      }
      %>
      
   
    </tbody>
  </table>
        
       </div>
      <div class="save">
      <input type="submit" value="click for email to sent marks" />
      </div>
      </form>
    </body>
</html>

