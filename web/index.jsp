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
        <br><br><br><h1 class="welcome-title">Welcome To Nasim's Classroom</h1><br><br><br><br><br><br><br>
       
        <h2 style="text-align: center;color: #ffffff"><u>Student Register</u></h2><br>
        <div class="container" style="width: 400px;
    height: 492px;  margin: -35px auto;">
            
            <form action="student_list_controller" method="Post" style="position: relative;
    top: 5%;
    transform: translateY(5%);">
                           <div class="username">
                               
                               <input type="text" name="name" placeholder="Your name" required="" class="name"/>
                           </div><br>
                             <div class="username">
                               
                               <input type="email" name="email" placeholder="Your email id" required="" class="name"/>
                           </div><br>
                           <div class="username">
                               
                               <input type="text" name="id" placeholder="Your class id" required="" class="name"/>
                           </div><br>
                            
                            
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
                                
                                
                                
			     <div class="pass">
                            <input type="password" name="pass" placeholder="PassWord" required="" class="password" />
                             </div><br>
                            <div class="pass">
                            <input type="password" name="repass" placeholder="Confirm PassWord" required="" class="password" />
			    </div>
                             
                            <br><div class="st">
                                <button class="button button2" type="submit" name="login">Register</button>
                                <h4>Already have account??
                                    <div class="tooltip">
                                        <a href="student_login.jsp" style="color:black; font-size: 25;">Login</a>
                                        <span class="tooltiptext"> Click for Login  </span>
                                    </div>
                                </h4>
                            </div>
                            
                        </form>
        </div>
                            <div class="teacher_container">
                                <h3>&ensp;If you want to use this site as teacher,click below.</h3>
            <div class="tooltip1">
                <h3 class="welcome-title" style="color: red;"><a href="teacher_register.jsp">Register or Login as teacher</a></h3>
                   <span class="tooltiptext1"> Click for Go to teacher's Panel </span>
            </div>
                             </div>
        
        
    </body>
</html>
