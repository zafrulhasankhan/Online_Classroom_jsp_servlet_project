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
        <br><br><br><<h1 class="welcome-title">Welcome To Nasim's Classroom</h1><br>
        <h2 style="text-align: center;color: #ffffff"><u>Register</u></h2>
        <div class="container" style="width: 400px;
    height: 410px;  margin: 25px auto;">
            
            <form action="student_list_controller" method="Post" style="position: relative;
    top: 5%;
    transform: translateY(5%);">
                           <div class="username">
                               
                               <input type="text" name="name" placeholder="Your name" required="" class="name"/>
                           </div><br>
                             <div class="username">
                               
                               <input type="text" name="email" placeholder="Your email id" required="" class="name"/>
                           </div><br>
                           <div class="username">
                               
                               <input type="text" name="id" placeholder="Your class id" required="" class="name"/>
                           </div><br>
                            
                            <div class="pass">
				<div class="username">
                               
                               <input type="text" name="code" placeholder="course code" required="" class="name"/>
                                </div><br>				
			     <div class="pass">
                            <input type="password" name="pass" placeholder="PassWord" required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login"> Register </button>
                                <h5>Already hava account?? <a href="course_login_form.jsp">Enter the Course</a></h5>
                            </div>
                            
                        </form>
        </div>
    </body>
</html>