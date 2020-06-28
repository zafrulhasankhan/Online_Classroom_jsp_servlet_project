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
        <br><br><br><<h1 class="welcome-title">Login for Enter the course</h1>
        <h1 style="text-align: center; color: wheat;">${errorMsg}</h1>
        <div class="container" style="height: 250px;">
        <form action="course_login_controller" method="get">
                           <div class="username">
                               
                               <input type="text" name="code" placeholder="Course code" required="" class="name"/>
                           </div><br>
                           <input type="text" name="email" placeholder="Course code" hidden=""  value="${email}" class="name"/>
                           <input type="text" name="spass" placeholder="Course code" hidden=""  value="${pass}"  class="name"/>
                            <div class="pass"><br>
								
			    
                            <input type="password" name="pass" placeholder="course pin number" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Login</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
