<%-- 
    Document   : classworklist
    Created on : Jun 22, 2020, 12:22:22 AM
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
        <link href="css/classworklist.css" rel="stylesheet"/>
        <link rel="stylesheet" href="../css/bootstrap.css">
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
      <a href="return_create_classwork?code=${code}">Classwork</a>
      <a href="#">Link 3</a>
    </div>
  </div> 
</div>

      <h3 style="text-align: center;">${msg}</h3> 
            
            
       
             
  
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
            
            
                 <h4 style=" color:  #ff3333;">Uploaded File/Image : <a href="getimage_create_classwork.jsp?name=<%=cw.getFilename()%>"> <%=cw.getFilename()%></a></h4>
            <h5 style=" color: red;">Deadline:  <%=cw.getDeadline()%></h5>
        </div>
        <p style=" text-align:  center;">***********************-------------------**********************</p>
        <h4 style=" text-align:  center;"><u><b>Submit Your Work</b></u></h4>
          <div class="submitwork">
              
      
          <form action="classwork_submit_controller" method="post" enctype="multipart/form-data">
              
              <input type="text" class="image" name="cw_no" value="<%=cw.getClasswork_no()%>" hidden=""    placeholder="enter cw no"/>
             <input type="text" class="image" name="code" value="${code}"  hidden=""  placeholder="enter course code"/><br>
             <input type="text" class="image" name="sname" value="${sname}" hidden=""    placeholder="enter student name"/>
             <input type="text" class="image" name="sid" value="${sid}" hidden=""    placeholder="enter student id"/>
             <input type="text" class="image" name="email" value="${email}" hidden=""    placeholder="enter student id"/>
             <div id="myDIV">
                 <input type="file" class="image" name="file"  style="background: #00cc99; color:red;"  placeholder="enter file"/><br>
               </div><br>
             <div >
             <input type="submit" class="btnn" value="upload"/><br>
             </div>
          </form>
          </div><br>
        </div><br>
       
         <%
      }
      %>
      
     
      
    </div>
      
    
        
      
     
    </body>
</html>
