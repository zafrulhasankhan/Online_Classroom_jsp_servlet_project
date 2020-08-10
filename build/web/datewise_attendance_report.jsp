<%-- 
    Document   : datewise_attendance_report
    Created on : Jul 25, 2020, 8:26:40 PM
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
    <title>Datewise attendance report form</title>
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
        String code = request.getParameter("code");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String filename = request.getParameter("filename");
        %>
       
    <div class="container-scroller">
        
      <div class="container-fluid page-body-wrapper full-page-wrapper">
          
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
              <h1> ${msg}</h1>
            <div class="card col-lg-4 mx-auto">
                
              <div class="card-body px-5 py-5">
                  <h3 style="text-align: center;font-size: 20px;"><u>Individual - Attendance - report</u></h3><br>
                <form action="datewise_report_controller" method="get">
                  <input type="text"  hidden="" value="<%=code%>" name="code">
                  <input type="text"  hidden="" value="<%=name%>" name="name">
                  <input type="text"  hidden="" value="<%=email%>" name="email">
                  <input type="text"  hidden="" value="<%=filename%>" name="filename">
                   <div class="form-group">
                    <label>Enter Date :</label>
                    <input type="date" name="date" class="form-control p_input" style="color: white;">
                  </div>
                     
                    <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Show</button>
                     <a href="admin_home_redirect?email=<%=email%>&name=<%=name%>&filename=<%=filename%>" class="btn btn-link btn-fw">Back to Home</a>
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
    <script src="assets/js/file-upload.js"></script>
    
    
    <!-- endinject -->
  </body>
</html>

