<%-- 
    Document   : classwork_mark_form1
    Created on : Jul 21, 2020, 9:21:40 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                 String code=request.getParameter("code");
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
                  <p align="center">
                  
                      
                  </p>
                  <h3  style="text-align: center;font-size: 20px;"><u> Classwork - marks </u></h3><br>
                <form action="classwork_mark_controller" method="get">
                     <input type="text" name="filename" placeholder="Course Teacher Name" value="<%=filename%>" hidden="" class="name"/>
                    <input type="text" name="tecemail" placeholder="Course Teacher Name" value="<%=email%>" hidden="" class="name"/>
                    <input type="text" name="tecname" placeholder="Course Teacher Name" value="<%=name%>" hidden="" class="name"/>
                  <div class="form-group">
                    <label>Classwork No.</label>
                    <input type="text" name="cwno" class="form-control p_input" style="color: white;">
                  </div>
                    <div class="form-group">
                    
                    <input type="text" name="code" hidden="" class="form-control p_input" value="<%=code%>" style="color: white;">
                  </div>
                     
                          
                               
                  
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Show</button>
                     <a href="admin_home_redirect?email=<%=email%>&name=<%=name%>&filename=<%=filename%>" class="btn btn-link btn-fw">Back to Home</a>
                  </div>
                  
                  
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
    <!-- endinject -->
  </body>
</html>

