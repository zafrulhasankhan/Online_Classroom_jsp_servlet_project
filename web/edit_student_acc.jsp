<%-- 
    Document   : edit_student_acc
    Created on : Jul 29, 2020, 11:16:37 AM
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
      <%
         String sname = request.getParameter("name");
         session.setAttribute("sname", sname);
         String semail = request.getParameter("email");
          session.setAttribute("semail", semail);
          String sfilename = request.getParameter("filename");
           session.setAttribute("sfilename", sfilename);
          String code = request.getParameter("code");
           session.setAttribute("code", code);
          %>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
          <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
            <div class="card col-lg-4 mx-auto">
              <div class="card-body px-5 py-5">
                  <h3 style="text-align: center;font-size: 20px;"><u>Edit - Student - Info</u></h3><br>
                  <p align="center">
                   <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=${sfilename}" alt="image" style="width: 80px; height: 80px">
                  </p><br>
                <form action="edit_student_controller" method="post" enctype="multipart/form-data">
                    <input type="email" name="emailp" value="${semail}" hidden=""  >
                    <input type="text" name="namep" value="${sname}" hidden="" >
                     
                  <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="name" class="form-control p_input" value="${sname}" style="color: white;" required="">
                  </div>
                    <div class="form-group">
                        <label>If Change your photo , Click 'select' button.</label>
                        <input type="file" name="image" class="file-upload-default">
                        <div class="input-group col-xs-12">
                            <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image" required="">
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-primary" type="button">Select</button>
                          </span>
                        </div>
                      </div>
                    <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control p_input" value="${semail}" style="color: white;" required="">
                  </div>
                     <div class="form-group">
                    <label>Student ID</label>
                    <%PreparedStatement ps3=DBConnection.getConnection().prepareStatement("select * from student_account where email=?");
            ps3.setString(1, semail);
            ResultSet rs3 = ps3.executeQuery();
           if(rs3.next()){
          String stu_id= rs3.getString("id");
           session.setAttribute("sid", stu_id);
          %>
                    <input type="text" name="idp" value="${sid}" hidden="">
                    <input type="text" name="id" class="form-control p_input" value="${sid}" style="color: white;" required="">
                  <%}%>
                     </div>
                    
                 
                               
                
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-block enter-btn">Update Profile</button>
                   <a href="stu_panel_home_controiller?email=${email}&code=${code}" class="btn btn-link btn-fw">Back to Home</a>
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
     <script src="assets/js/file-upload.js"></script>
    <!-- endinject -->
  </body>
</html>