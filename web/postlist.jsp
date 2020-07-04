<%-- 
    Document   : postlist
    Created on : May 19, 2020, 11:06:25 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.people"%>
<%@page import="dao.post"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/postlist.css" rel="stylesheet"/>
        <link rel="stylesheet" href="../css/bootstrap.css">
         <link href="https://emoji-css.afeld.me/emoji.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = session.getAttribute("name").toString();
               session.setAttribute("name", name);
               
String tecname = session.getAttribute("tecname").toString();
               session.setAttribute("tecname", tecname);
               %>
           
            
                
            
  <div class="navbar">
  <a href="#home">Home</a>
  
  <a href="individual_report_form.jsp?code=${code}">Your attendance report</a>
  <div class="navbar-centered">
      <a  class="active">${name} | ${code}</a>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Menu 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
        
       
      
      <a href="peoplelist_controller?code=${code} ">People</a>
      <a href="return_create_classwork?code=${code}&email=${email}&spass=${spass}">Classwork</a>
      <a href="#">Link 3</a>
    </div>
  </div> 
</div>

      <h3 style="text-align: center;">${msg}</h3> 
            
            
       
             
  
      <h2 style="text-align: center;color: #000;"><b><u>All post</u></b></h2>
       <div class="postarea">
        <%
                ArrayList<post> postlist =(ArrayList) request.getAttribute("postlist");
                
                int i = 0;
                for(post po : postlist){
                    i++;
                
        %>
        <div class="bodypost">
            <h4>Text Message:</h4>
            <h3><%= po.getBody()%></h3><p>***********************------------------------------***********************</p>
            <div class="tooltip">
                <h4>Uploaded File/Image : <a href="getImage.jsp?name=<%=po.getName()%>"><%=po.getName()%> <span class="tooltiptext">Click for Show file </span></a> &ensp;&ensp;&ensp;  ...........<i class="em em-soon" aria-role="presentation" aria-label="SOON WITH RIGHTWARDS ARROW ABOVE"></i> &ensp;&ensp;
            </div>
                    <div class="tooltip1">
                    <a href="downloadFileServlet?name=<%=po.getName()%>">download here  <span class="tooltiptext1">Click for Download file </span></a></h4><br>
            </div>
          <h5>post creation time:  <%=po.getTime()%></h5>
           
        </div><br>
       
        
      
      <%
      }
      %>
      
    </div>
      
     
        
     
     
    </body>
</html>
