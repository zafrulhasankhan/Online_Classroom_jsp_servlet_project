<%-- 
    Document   : classwork_submit_msg
    Created on : Jul 31, 2020, 12:19:27 AM
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
             
            
           
                  <h1 style=" text-align: center;">${csc}</h1><br>
              <p align="center">
              <a href="stu_panel_home_controiller?email=${email}&code=${code}" class="btn btn-success btn-fw">Back to Home</a>
              </p>
              
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
                <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Created by  <a href="https://web.facebook.com/zafrulhasan.nasim" target="_blank">Zafrul Hasan Nasim </a>.</span>
              <span class="text-muted float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> <a href="https://web.facebook.com/zafrulhasan.nasim" target="_blank"><i class="mdi mdi-facebook text-danger" style="font-size:30px;"></i> </a><a href="https://www.instagram.com/zafrul_hasan_nasim/" target="_blank"><i class="mdi mdi-instagram text-danger" style="font-size:30px;"></i> </a></span>
            </div>
          </footer>
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
