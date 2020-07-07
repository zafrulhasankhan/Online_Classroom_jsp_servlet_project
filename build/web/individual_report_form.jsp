<%-- 
    Document   : individual_report_form
    Created on : Jun 9, 2020, 8:39:34 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
closebtn:hover {
  background-color: yellow;
}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <br><div class="heading" align="center" style=" color: white">
     <h2><u>Attendance Report Form</u></h2>
  </div>
        <h1 style="text-align: center;color:black; animation: bymove 3s infinite">${msg}</h1>
     <%
         String code = request.getParameter("code");
         %>
         
       <div class="container" style=" height: 170px; ">
           
            <form action="individual_report_controller" method="get">
                
                             
                            
                            <div class="pass"><br>
								
			    
                            <input type="text" name="classid" placeholder="Enter your Class id" required="" class="code" />
							</div>
                            <div class="pass"><br>
								
			    
                                <input type="text" name="code" hidden="" placeholder="Enter the course code" value=<%=code%> required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Show</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
