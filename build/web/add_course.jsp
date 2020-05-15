<%-- 
    Document   : add_course
    Created on : May 15, 2020, 4:45:48 PM
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
       <div class="container">
            <form action="add_course_controller" method="POST">
                           <div class="username">
                               
                               <input type="text" name="name" placeholder="Course Name" required="" class="name"/>
                           </div><br>
                             
                            
                            <div class="pass"><br>
								
			    
                            <input type="text" name="code" placeholder="Course code" required="" class="code" />
							</div>
                            <div class="pass"><br>
								
			    
                            <input type="password" name="pass" placeholder="password" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Save</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
