<%-- 
    Document   : admin_all_classwork
    Created on : Jun 26, 2020, 9:23:43 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.classwork"%>
<%@page import="dao.people"%>
<%@page import="dao.post"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://emoji-css.afeld.me/emoji.css" rel="stylesheet">
        <link href="css/classworklist.css" rel="stylesheet"/>
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <title>JSP Page</title>
    </head>
    <body>
        
           
            
                
            
  <div class="navbar">
  <a href="#">Home</a>
  
  <a href="individual_report_form.jsp?code=${code}"> Attendance report</a>
  <div class="navbar-centered">
      <a  class="active">${name} | ${code}</a>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Menu Bar 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
        
       
      
      <a href="peoplelist_controller?code=${code}">People</a>
      
      <a href="classwork_mark_form.jsp?code=${code}">All Student classwork mark</a>
    </div>
  </div> 
</div>

      <h3 style="text-align: center;">${msg}</h3> 
            
            
       
             
  <h1 class="welcome-title"> Teacher panel</h1><br>
      <h2 style="text-align: center;color: #000;"><b><u>Classwork</u></b></h2>
       <div class="workarea">
        <%
                ArrayList<classwork> worklist =(ArrayList) request.getAttribute("worklist");
                
                int i = 0;
                for(classwork cw : worklist){
                    i++;
                String num= cw.getBody();
        %>
        <div class="workbody" >
             <div class="workbody2">
                 <p style=" text-align: center; color: #3300ff;"> <u><b>Classwork No:<%=cw.getClasswork_no()%></b></u></p>
                 <p style="color: #3300ff;"><b>Text message:</b></p>
                 <h4 style="text-align: center;"><%=cw.getBody()%></h4>
            
            <div class="tooltip">
                 <h4 style=" color:  #ff3333;">Uploaded File/Image : <a href="getimage_create_classwork.jsp?name=<%=cw.getFilename()%>"> <%=cw.getFilename()%><span class="tooltiptext">Click for Show file </span></a>&ensp;&ensp;&ensp;  ...........<i class="em em-soon" aria-role="presentation" aria-label="SOON WITH RIGHTWARDS ARROW ABOVE"></i> &ensp;&ensp;
            </div>
             <div class="tooltip1">
                    <a href="downloadFileServletcw?name=<%=cw.getFilename()%>">download here  <span class="tooltiptext1">Click for Download file </span></a></h4><br>
                   </div>
            <h5 style=" color: red;">Deadline:  <%=cw.getDeadline()%></h5>
        </div>
        <p style=" text-align:  center;">***********************-------------------**********************</p>
        <h4 style=" text-align:  center; color: green;"><b>Click below for Show all student ClassWork</b></h4>
        <p style="text-align:  center; color: green; animation:bymove 4s infinite;">Link: <a href="show_submitted_all_classwork_codewise?code=${code}&classworkno=<%=cw.getClasswork_no()%>">Show all Classwork </a></p>
          </div><br>
         <%
      }
      %>
      
     
      
        
      
    
        
      
     
    </body>
</html>

