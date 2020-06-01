<%-- 
    Document   : input
    Created on : May 11, 2020, 11:47:06 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.8.0/ckeditor.js"></script>
<title>Home</title>
</head>
<body>
<center>
<h1>Image Uploading</h1>
<table>
    
 <form action="post_form_controller" method="post" enctype="multipart/form-data">
     <tr><td>Course code</td><td><input type="text" value="${code}" name="code"/></td></tr>
<tr><td>File Name</td><td><input type="text" name="name"/></td></tr>
<tr><td>Image</td><td><input type="file" name="image"/></td></tr>
<tr><td>Body</td><td><textarea class="text_box" name="body" id="body" cols="30" rows="10"></textarea><br>
</td></tr>
<tr><td colspan="2"><input type="submit" value="upload"/></td></tr>
</form>
   
</table>
</center>
</body>
</html>
<script>
	CKEDITOR.replace('body');
        
        
</script>