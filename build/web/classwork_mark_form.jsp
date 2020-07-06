<%-- 
    Document   : classwork_mark_form
    Created on : Jul 6, 2020, 4:55:42 PM
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
        <% String code=request.getParameter("code");%>
        <h2 style="text-align: center;color: #ffffff"><u>Classwork mark</u></h2>
        <div class="container" style="width: 400px;
    height: 250px;  margin: 25px auto;">
            
            <form action="classwork_mark_controller" method="get" style="position: relative;
    top: 12%;
    transform: translateY(5%);">
                          
                             <div class="username">
                               
                                 <input type="text" name="code" placeholder="Your email id" hidden="" value="<%=code%>" required="" class="name"/>
                           </div><br>
                           
                            				
			     <div class="pass">
                            <input type="text" name="cwno" placeholder="Enter classwork no. " required="" class="password" />
							</div>
                            
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Login</button>
                                <h4>Not yet register??
                                    <div class="tooltip">
                                        <a href="index.jsp" style="color:black; font-size: 25;">Register</a>
                                        <span class="tooltiptext"> Click for Register </span>
                                    </div>
                                </h4>
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
