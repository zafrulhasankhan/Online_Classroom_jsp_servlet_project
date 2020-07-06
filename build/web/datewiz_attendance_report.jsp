<%-- 
    Document   : individual_report_form
    Created on : Jun 9, 2020, 8:39:34 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String code =request.getParameter("code");
            %>
        <br><div class="heading" align="center" style=" color: white">
     <h2><u>Attendance Report Form by datewise</u></h2>
  </div>
       <div class="container" style=" height: 200px; ">
            <form action="datewise_report_controller" method="get">
                
                             
                            
                            <div class="pass"><br>
								
			    
                            <input type="date" name="date" placeholder="Enter the date" required="" class="code" />
							</div>
                            <div class="pass"><br>
								
			    
                                <input type="text" name="code" placeholder="Enter the course code" value="<%=code%>"  hidden=""  class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Save</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
