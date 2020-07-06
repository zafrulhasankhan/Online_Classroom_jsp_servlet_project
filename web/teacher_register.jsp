<%-- 
    Document   : teacher_register
    Created on : Jul 2, 2020, 2:46:57 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <br><br><br><<h1 class="welcome-title">Register for Teacher panel</h1><br>
        <h2 style="text-align: center;color: #ffffff"><u>Teacher register</u></h2>
        <div class="container" style="width: 400px;
    height: 410px;  margin: 25px auto;">
            <form action="teacher_register_controller" method="POST">
                           <div class="username">
                               
                               <input type="text" name="name" placeholder="Your full Name" required="" class="name"/>
                           </div><br>
                             
                            <div class="username">
                               
                               <input type="email" name="email" placeholder="Your email" required="" class="name"/>
                           </div><br>
                            <div class="pass">
								
			    
                            <input type="password" name="pass" placeholder="PassWord" required="" class="password" />
                            </div><br>
                           <div class="pass">
								
			    
                            <input type="password" name="repass" placeholder=" Confirm PassWord" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Register</button>
                                <h4>Already have account??
                                    <div class="tooltip">
                                        <a href="teacher_login_form.jsp" style="color:black; font-size: 25;">Login</a>
                                        <span class="tooltiptext"> Click for Login of teacher's Panel </span>
                                    </div>
                                </h4>
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
