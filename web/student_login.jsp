<%-- 
    Document   : index
    Created on : May 15, 2020, 3:51:49 PM
    Author     : Zafrul Hasan Nasim
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="db.DBConnection"%>
<%@page import="java.sql.PreparedStatement"%>
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
        <h2 style="text-align: center;color: #ffffff"><u>Student Login</u></h2>
        <div class="container" style="width: 400px;
    height: 375px;  margin: 25px auto;">
            
            <form action="student_login_controller" method="Post" style="position: relative;
    top: 12%;
    transform: translateY(5%);">
                          
                <label class="" style="color: black">Course code:</label>
				<div class="username">
                                    
                               <select id="cars" name="code" class="code1">   
                                <%
                              PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from add_course");
                               ResultSet rs = ps.executeQuery();
                                 while(rs.next()){
                                String code = rs.getString("course_code");%>
                                <option  value="<%=code%>"><%=code%></option>
                                 <% }%>
                               </select>                          
                               </div><br>
                               
                             <div class="username">
                               
                               <input type="email" name="email" placeholder="Your email id" required="" class="name"/>
                           </div><br>
                           
                            				
			     <div class="pass">
                                 
                             <input type="password" name="pass" placeholder="PassWord" required="" class="password" /><br><br>
                             <div class="tooltip">
                                 <a href="forget_pass.jsp" style="color: black;"><b>Forget password?</b></a>
                            <span class="tooltiptext"> Click for find password </span>
                             </div>
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
