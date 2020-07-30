<%-- 
    Document   : delete_alert1
    Created on : Jul 30, 2020, 12:47:16 AM
    Author     : Zafrul Hasan Nasim
--%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End Plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="assets/images/favicon.png" />
  </head>
  <body>
       <%
        String code = request.getParameter("code");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String filename = request.getParameter("filename");
        %>
    <div class="container-scroller">
      <!-- partial:../../partials/_sidebar.html -->
      
        <!-- partial -->
        <div class="main-panel">
          <div class="content-wrapper">
              <form action="delete_course_cotroller" method="get">
            
            <input type="text"  hidden="" value="<%=code%>" name="code">
                  <input type="text"  hidden="" value="<%=name%>" name="name">
                  <input type="text"  hidden="" value="<%=email%>" name="email">
                  <input type="text"  hidden="" value="<%=filename%>" name="filename">
                  <h1 style=" text-align: center;">Are you sure want to delete all data of ' <%=code%> ' course's ?</h1><br>
              <p align="center">
              <a href="admin_home_redirect?email=<%=email%>&name=<%=name%>&filename=<%=filename%>" class="btn btn-success btn-fw">Back to Home</a>  &ensp;&ensp;&ensp;<input type="submit" class="btn btn-danger" value="Yes ,Delete">
              </p>
              </form>
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
      <!-- page-body-wrapper ends -->
   
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
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>
