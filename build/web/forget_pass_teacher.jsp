<%-- 
    Document   : forget_pass_teacher
    Created on : Jul 7, 2020, 8:35:58 PM
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
        <script langauge="JavaScript">
    function myFunction() {
  var x = document.getElementById("myDIV");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
    </script>
        <title>JSP Page</title>
    </head>
    <body>
        <br><br><br><h1 class="welcome-title">Forget password</h1>
        
        <div class="container" style="height: 210px;">
        <form action="teacher_forget_pass_controller" method="post">
                           
                        
                           
                           
                           <div class="username">
                               
                               <input type="email" name="email" placeholder="Enter Your email id" required="" class="name"/>
                           </div><br>
                           
                           <div class="tooltip1">
                           <input type="button" value="Reset password" onClick="myFunction()"><br>
                           <span class="tooltiptext1"> Double Click for reset password  </span>
                           </div> 
                           <div id="myDIV" hidden="" class="container" style="height: 170px;">
                           <div class="pass"><br>
				 <input type="password" name="pass" placeholder="set password"  class="password" />
			   </div>
                                <div class="pass"><br>
				 <input type="password" name="repass" placeholder="confirm set password"  class="password" />
			   </div>
                          </div>
                           
                           
                           <div class="tooltip1">
                               <br><div class="st">
                                   <button class="button button2"  type="submit" name="login">Sent</button>
                                
                            </div>
                             <span class="tooltiptext1"> Click for find password by email </span>
                            </div>
                            
                        </form>
        </div>
    </body>
</html>
