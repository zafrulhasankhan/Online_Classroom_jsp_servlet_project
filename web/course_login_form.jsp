<%-- 
    Document   : course_login_form1
    Created on : Jul 12, 2020, 8:53:25 PM
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
    <title>Course login</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="assets/vendors/select2/select2.min.css">
    <link rel="stylesheet" href="assets/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
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
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                  <h3  style="text-align: center"><u>Course - Login</u></h3><br>
                  <h4 style="text-align: center;">${ncerror}</h4>
                <form action="course_login_controller" method="get">
                 
                     
                           <input type="text" name="email" placeholder="Course code" hidden=""  value="${email}" class="name"/>
                           <input type="text" name="spass" placeholder="Course code" hidden=""  value="${pass}"  class="name"/>
                            
                     
                    
                  
                  <div class="form-group">
                    <label>Course pin </label>
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
    <script src="assets/vendors/select2/select2.min.js"></script>
     <script src="assets/js/select2.js"></script>
    <% String npu = session.getAttribute("npu").toString();  
            String npu1="npu"; 
            
               if(npu1==npu){
            %>
            <script type="text/javascript">
            alert('So far no post upload in this course');
            </script>
                  <% } %>
    <!-- endinject -->
  </body>
</html>
