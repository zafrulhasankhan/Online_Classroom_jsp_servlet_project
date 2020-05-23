<%-- 
    Document   : postlist
    Created on : May 19, 2020, 11:06:25 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.post"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/postlist.css" rel="stylesheet"/>
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = session.getAttribute("name").toString();
               session.setAttribute("name", name);
               %>
           
            
                
            
  <div class="navbar">
  <a href="#home">Home</a>
  <a href="#news">News</a>
  <div class="navbar-centered">
      <a  class="active">${name} | ${code}</a>
  </div>
  <div class="dropdown">
    <button class="dropbtn">Dropdown 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
  </div> 
</div>

           
            
            
       
             
  <div class="post">
      <h2 style="text-align: center;color: #000;"><b><u>All post</u></b></h2>
       <div class="postarea">
        <%
                ArrayList<post> postlist =(ArrayList) request.getAttribute("postlist");
                
                int i = 0;
                for(post po : postlist){
                    i++;
                
        %>
        <div class="bodypost">
           <h4><%= po.getBody()%></h4>
          <h5>Uploaded File/Image : <a href="getImage.jsp?name=<%=po.getName()%>"> <%=po.getName()%></a></h5><br>
        <h6>post creation time:  <%=po.getTime()%></h6>
           
        </div><br>
       
        
      
      <%
      }
      %>
      
    </div>
      
     
        
        </div>
      <div class="home">
          <a href="index.jsp" style="color: white; align-content: right; "><h5>Home</h5></a>
      </div>
     
    </body>
</html>
