<%-- 
    Document   : datefind
    Created on : Jun 9, 2020, 11:56:14 AM
    Author     : Zafrul Hasan Nasim
--%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/classwork.css">
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.8.0/ckeditor.js"></script>
</head>
<body>





<form action="nyform.jsp" method="post">
    <div id="myDIV" hidden="">
This is my DIV element.
</div>
    <input type="button" value="Reset" onClick="myFunction()">
    
    <input type="date" class="post-title" name="title" value="" placeholder="Title">
    <input type="submit"/>
</form>
    <a href="date?age='c'&code='fmf'&ad='f'">click here</a>
</body>

</html>


