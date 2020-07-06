<%-- 
    Document   : email_verification
    Created on : Jul 3, 2020, 5:06:53 PM
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
        
        <br><br><br><h1 class="welcome-title">Email verification for sent classes all update to all of students by email</h1><br>
        <h2 style="text-align: center;color: #ffffff"><u>Email verify</u></h2>
        <div class="container" style="width: 400px;
    height: 310px;  margin: 25px auto;">
            <form action="email_verification_controller" method="post">
                           <div class="username">
                               
                               <input type="email" name="email" value="${email}" hidden="" required=""  placeholder="email id"  class="name"/>
                           </div><br>
                            <div class="username">
                               
                                <input type="text" name="name" value="${name}" hidden=""   placeholder="email id"  class="password"/>
                           </div>
                           <h3> Don't worry,Your email password will be encrpyted always,don't know anybody</h3>
                            <div class="pass"><br>
								
			    
                            <input type="password" name="pass" placeholder=" Your email PassWord" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Login</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
