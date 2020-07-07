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
        <br><br><br><<h1 class="welcome-title">Login for Enter the course</h1>
        <h1 style="text-align: center; color: wheat;">${errorMsg}</h1>
        <div class="container" style="height: 250px;">
        <form action="course_login_controller" method="get">
                           
                        
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
