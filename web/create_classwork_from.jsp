<%-- 
    Document   : newjsp1
    Created on : Jun 20, 2020, 8:32:45 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/classwork.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.8.0/ckeditor.js"></script>

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
        <%
         String code = request.getParameter("code");
         %>
         
         <div class="topnav">

  <!-- Centered link -->
  <div class="topnav-centered">
    <a href="#home" class="active">Home</a>
  </div>
  
  <!-- Left-aligned links (default) -->
  <a href="#news">News</a>
  <a href="#contact">Contact</a>
  
  <!-- Right-aligned links -->
  <div class="topnav-right">
  </div>
  </div><br>

  <div class="cre_po_title">
            <h3 style="color: black;"> <u>Create Classwork</u> </h3>            
  </div>
  
         <div class="container">
        <form action="create_classwork_controller" method="post" enctype="multipart/form-data">
            <input type="text" name="code"  hidden=""  placeholder="Course code" value="<%=code%>" class="code" />
            
             <label>Classwork details :</label><br>
            <textarea class="text_box" name="body" id="body" cols="30" rows="10"></textarea><br>
            
             <label>Deadline of classwork :</label><br>
             <input type="date" class="post-title" name="date"/><br><br>
             
             <input type="button" class="btn" value="Double Click here for Add File" class="btn" onClick="myFunction()"><br><br>
             <div id="myDIV" hidden="">
            <input type="text" class="post-title"  name="filename"  placeholder="Enter Filename"/><br><br>
            <input type="file" class="image" name="image"   placeholder="enter file"/><br>
             </div><br>
             <input type="submit" class="btnn" value="upload"/>
</form>
         </div>
        
    </form>
    </body>
</html>
<script>
	CKEDITOR.replace('body');
        
        
</script>