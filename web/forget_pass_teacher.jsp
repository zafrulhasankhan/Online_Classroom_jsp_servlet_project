<%-- 
    Document   : forget_pass_teacher1
    Created on : Jul 29, 2020, 8:50:23 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="db.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Online classroom</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
     <link rel="stylesheet" href="assets/vendors/select2/select2.min.css">
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.png" />
    
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                  <h3 style="text-align: center;font-size: 20px;"><u>Forget - password</u></h3><br>
                <form action="teacher_forget_pass_controller" method="post">
                    
                    
                    <div class="form-group">
                    <label> Enter your 'Email' id for get password to email.Otherise reset password also enter your 'Email'</label>
                    <input type="email" name="email" required="" class="form-control p_input" style="color: white;">
                  </div>
                     
                    <p align="center">
                       <input type="button" class="btn btn-success" value="Reset password" onClick="myFunction()"><br>
                    </p>    
                   
                    <div id="myDIV"  class="container" >
                 <div class="form-group">
                    <label>Set Password</label>
                    <input type="password"  name="pass" class="form-control p_input" onmouseover="this.type='text'"
                     onmouseout="this.type='password'" style="color: white;">
                  </div>
                  <div class="form-group">
                    <label>Confirm Set Password</label>
                    <input type="password"  name="repass" class="form-control p_input" onmouseover="this.type='text'"
                     onmouseout="this.type='password'" style="color: white;">
                  </div>
                              
                    </div>
                    
                    
                    
                    
                           
                  
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Save ad sent</button>
                  </div>
                  
                </form>
              </div>
            </div>
          </div>
          <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <script src="assets/vendors/select2/select2.min.js"></script>
     <script src="assets/js/select2.js"></script>
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
    <!-- endinject -->
  </body>
</html>

