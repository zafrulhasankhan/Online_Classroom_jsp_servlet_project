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
        <br><br><br><<h1 class="welcome-title">Login for Teacher panel</h1><br>
        <h2 style="text-align: center;color: #ffffff"><u>Teacher Login</u></h2>
        <div class="container" style="width: 400px;
    height: 310px;  margin: 25px auto;">
            <form action="teacher_login_controller" method="get">
                           <div class="username">
                               
                               <input type="email" name="email" placeholder="email id" required="" class="name"/>
                           </div><br>
                             
                            
                            <div class="pass"><br>
								
			    
                            <input type="password" name="pass" placeholder="PassWord" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Login</button>
                                <h4>Not yet register??
                                    <div class="tooltip">
                                        <a href="teacher_register.jsp" style="color:black; font-size: 25;">Register</a>
                                        <span class="tooltiptext"> Click for Register of teacher's Panel </span>
                                    </div>
                                </h4>
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
