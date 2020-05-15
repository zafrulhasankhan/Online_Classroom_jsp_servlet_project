<%-- 
    Document   : admin_login_form
    Created on : May 15, 2020, 4:01:14 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="css/login.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="admin_login_controller" method="POST">
                           <div class="username">
                               
                               <input type="text" name="name" placeholder="UserName" required="" class="name"/>
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
