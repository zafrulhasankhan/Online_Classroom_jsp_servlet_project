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
       <div class="container" style=" height: 225px; ">
            <form action="individual_report_controller" method="get">
                
                             
                            
                            <div class="pass"><br>
								
			    
                            <input type="text" name="classid" placeholder="Enter your Class id" required="" class="code" />
							</div>
                            <div class="pass"><br>
								
			    
                            <input type="text" name="code" placeholder="Enter the course code" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Save</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
