<%-- 
    Document   : index
    Created on : May 15, 2020, 3:51:49 PM
    Author     : Zafrul Hasan Nasim
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/login.css">
        <title>JSP Page</title>
    </head>
    <body>
        <br><br><br><<h1 class="welcome-title">Welcome To Nasim's Classroom</h1>
        <div class="container">
        <form action="course_login_controller" method="Post">
                           <div class="username">
                               
                               <input type="text" name="code" placeholder="Course code" required="" class="name"/>
                           </div><br>
                             
                            
                            <div class="pass"><br>
								
			    
                            <input type="password" name="pass" placeholder="PassWord" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Login</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
