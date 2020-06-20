<%-- 
    Document   : individual_report_result
    Created on : Jun 9, 2020, 9:03:54 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="css/course_list.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
		int present=Integer.parseInt(request.getAttribute("present").toString());
		int total=Integer.parseInt(request.getAttribute("totalclass").toString());
		String name =request.getAttribute("name").toString();
                  String classid =request.getAttribute("classid").toString();                             
                                                
		float per=(((float)present)/total)*100;
	%>
                                                        
                                                        
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
        
        <tr>
            <td class="bname"><%= classid%></td>
            <td class="bdept"><%=name%></td>
        <td class="bemail"><%= present%></td>
        <td class="bview"><%=total%> </td>
        <td class="bdelete"><%=per%> </td>
        
      </tr>  
      
      
    </tbody>
                            
    </table>
        </div>                                                
                                                        
    </body>
</html>
