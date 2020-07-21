<%-- 
    Document   : edit_teacher
    Created on : Jul 19, 2020, 1:54:28 PM
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
      <%
                 String email = request.getParameter("email");
                  String name = request.getParameter("name");
                  String filename = request.getParameter("filename");
                  
                   
                                
                                 %>
                  
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                  <h3  style="text-align: center;font-size: 20px;"><u>Edit - teacher - profile</u></h3><br>
                  <p align="center">
                   <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=<%=filename%>" alt="" style="width: 80px; height: 80px">
                  </p><br>
                  <form action="edit_teacher_controller" method="POST" enctype="multipart/form-data">
                    
                   
                    <input type="email" name="emailp" value="<%=email%>" hidden="" >
                     <input type="text" name="namep" value="<%=name%>" hidden="">
                    <div class="form-group">
                    <label>Change Username</label>
                    <input type="text" name="name" value="<%=name%>" class="form-control p_input" style="color: white;" required="">
                  </div>
                    <div class="form-group">
                        <label>Change Your Photo </label>
                        <input type="file" name="image" class="file-upload-default">
                        <div class="input-group col-xs-12">
                            <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image" required="">
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-primary" type="button">Select</button>
                          </span>
                        </div>
                      </div>
                    <div class="form-group">
                    <label>Change Email</label>
                    <input type="email" name="email" value="<%=email%>" class="form-control p_input" style="color: white;" required="">
                  </div>
                     
                  <div class="form-group">
                    <label>Change Password</label>
                    <input type="password"  name="pass" class="form-control p_input"  style="color: white;" >
                  </div>
                    <div class="form-group">
                    <label>Change Confirm Password</label>
                    <input type="password" name="repass" class="form-control p_input" style="color: white;" >
                  </div>           
                               
                  
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Sign up</button>
                  </div>
                  
                  <p class="sign-up text-center">Already have an Account?<a href="teacher_login_form.jsp"> Sign In</a></p>
                  <p class="terms">By creating an account you are accepting our<a href="#"> Terms & Conditions</a></p>
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
    <script src="assets/js/file-upload.js"></script>
    <!-- endinject -->
  </body>
</html>

