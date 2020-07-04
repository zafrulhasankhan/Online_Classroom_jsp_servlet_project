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
        <br><<h1 class="welcome-title">Add Course</h1>
        <div class="container" style=" height: 375px; ">
            <form action="add_course_controller" method="POST">
                <%
                 String email = request.getParameter("email");
                  String name = request.getParameter("name");
                  %>
                <div class="username">
                               <input type="text" name="tecemail" placeholder="Course Teacher Name" value="<%=email%>" hidden="" class="name"/>
                               <input type="text" name="tecname" placeholder="Course Teacher Name" value="<%=name%>"  hidden="" class="name"/>
                           </div><br>
                           <div class="username">
                               
                               <input type="text" name="name" placeholder="Course Name" required="" class="name"/>
                           </div><br>
                             
                            
                            <div class="pass">
								
			    
                            <input type="text" name="code" placeholder="Course code" required="" class="code" />
							</div>
                            <div class="pass"><br>
								
			    
                            <input type="password" name="pass" placeholder="set pin number" required="" class="password" />
							</div>
                           <div class="pass"><br>
								
			   <input type="password" name="repass" placeholder="Confirm pin number" required="" class="password" />
			</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Save</button>
                                
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
