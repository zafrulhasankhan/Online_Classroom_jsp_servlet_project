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
            <div style=" text-align: center">
                Classwork No. :
            <input type="text" name="cw_no"  placeholder="Enter classwork no."   required=""  class="code" />
            </div>
            <div class="cre_po_title">
            <h5 style="color: black;"> Last classwork No. : ${cw_no} </h5>            
            </div>
  
            <input type="text" name="code"  placeholder="Course code"  hidden="" value="${code}"  class="code" />
            
             <label>Classwork details :</label><br>
            <textarea class="text_box" name="body" id="body" cols="30" rows="10"></textarea><br>
            <label>If you want to add file, click below :</label><br>
            <input type="file" class="image" name="image"   placeholder="enter file"/><br><br>
             <label>Deadline of classwork :</label><br>
             <input type="date" class="post-title" name="date"/><br><br>
             
            
             <input type="submit" class="btnn" value="upload"/><br>
</form>
         </div><br>
        
    </form>
    </body>
</html>
<script>
	CKEDITOR.replace('body');
        
        
</script>