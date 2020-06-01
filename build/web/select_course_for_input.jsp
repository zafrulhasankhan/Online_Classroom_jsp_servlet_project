<%-- 
    Document   : select_file_for_input
    Created on : May 19, 2020, 10:50:24 PM
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
        <br><br><br><<h1 class="welcome-title">Welcome To Nasim's Classroom</h1>
        <div class="container-select-file">
            <br><h3 class="welcome-title">Enter your course code Again</h3>
        <form action="select_course_controller" method="Get">
            <input type="text" name="code" value="${code}" placeholder="Confirm course code" class="name"/><br><br>
            <input type="submit" class="button" value="Join Class"/>
        </form>
        </div>
    </body>
</html>
