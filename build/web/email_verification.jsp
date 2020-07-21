<%-- 
    Document   : email_verificaton
    Created on : Jul 13, 2020, 8:53:14 PM
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
          String email=request.getParameter("email");
          session.setAttribute("email", email);
          String name=request.getParameter("name");
          session.setAttribute("name", name);
          String filename=request.getParameter("filename");
          session.setAttribute("filename", filename);
   %>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                  <h3  style="text-align: center"><u>Email - Verification</u></h3><br>
                <form action="email_verification_controller" method="post">
                 
                    <div class="username">
                               
                               <input type="email" name="email" value="${email}" hidden="" required=""  placeholder="email id"  class="name"/>
                           </div><br>
                            <div class="username">
                               
                                <input type="text" name="name" value="${name}" hidden=""   placeholder="email id"  class="password"/>
                           </div>
                     <input type="text" name="filename" value="${filename}" hidden="" required=""  placeholder="filename"  class="name"/>
                    <h4 style="text-align: center"> Don't worry,Your email password will be encrpyted always,don't know anybody</h4><br>
                  
                  <div class="form-group">
                    <label>Your email password </label>
                    <input type="password"  name="pass" class="form-control p_input" onmouseover="this.type='text'"
       onmouseout="this.type='password'" style="color: white;">
                  </div>
                             
                               
                  
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Login</button>
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
    <!-- endinject -->
  </body>
</html>
