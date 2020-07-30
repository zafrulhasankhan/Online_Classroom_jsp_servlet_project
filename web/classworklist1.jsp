<%-- 
    Document   : classworklist1
    Created on : Jul 27, 2020, 9:09:52 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.classwork"%>
<%@page import="dao.post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.DBConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.PreparedStatement"%>
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
    <link rel="stylesheet" href="assets/vendors/jvectormap/jquery-jvectormap.css">
    <link rel="stylesheet" href="assets/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/vendors/owl-carousel-2/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/vendors/owl-carousel-2/owl.theme.default.min.css">
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
      <!-- partial:partials/_sidebar.html -->
       <nav class="sidebar sidebar-offcanvas" id="sidebar">
     <div class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top">
            <a class="sidebar-brand brand-logo" href="index.html" style="color: white">Online Classroom</a>
            <a class="sidebar-brand brand-logo-mini" href="index.html" style="color: white;">OC</a>
     
     </div>
     
           
           <ul class="nav">
               <li class="nav-item profile">
            <div class="profile-desc">
              <div class="profile-pic">
                <div class="count-indicator">
                    <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=${tecfilename}" alt="image" style="width: 80px; height: 80px">
                  
                </div>
                <div class="profile-name">
                    <h5 class="mb-0 font-weight-normal">${tecname}</h5>
                  <span>Course Teacher</span>
                </div>
              </div>
            </div>
               </li><br><br>
               
               
         <li class="nav-item menu-items">
            <a class="nav-link" href="stu_panel_home_controiller?code=${code}&email=${email}">
              <span class="menu-icon">
               <i class="mdi mdi-home"></i>
              </span>
              <span class="menu-title">Home </span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="return_create_classwork?code=${code}&email=${email}&cname=${cname}">
              <span class="menu-icon">
               <i class="mdi mdi-newspaper"></i>
              </span>
              <span class="menu-title">Classwork </span>
            </a>
          </li>
           <li class="nav-item menu-items">
            <a class="nav-link" href="stu_people_list_controller?code=${code}&email=${email}&cname=${cname}">
              <span class="menu-icon">
              <i class="mdi mdi-account-multiple"></i>
              </span>
              <span class="menu-title">People</span>
            </a>
          </li>
           </ul>
                  
       </nav>
      <!-- partial -->
      <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <nav class="navbar p-0 fixed-top d-flex flex-row">
          <div class="navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center">
            <a class="navbar-brand brand-logo-mini" href="index.html"><img src="assets/images/logo-mini.svg" alt="logo" /></a>
          </div>
          <div class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
            <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
              <span class="mdi mdi-menu"></span>
            </button>
            <ul class="navbar-nav w-100">
              <li class="nav-item w-100">
                <form class="nav-link mt-2 mt-md-0 d-none d-lg-flex search">
                    <h5>${cname}--${code}</h5>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
              <li class="nav-item dropdown d-none d-lg-block">
                <a class="nav-link btn btn-success create-new-button"   aria-expanded="false" href="student_post_share.jsp?code=${code}&email=${email}&name=${sname}&filename=${sfilename}">Share Something in ${code}</a>
              
              </li>
              <li class="nav-item dropdown border-left">
                <a class="nav-link btn btn-inverse-secondary"  href="edit_student_acc.jsp?email=${email}&name=${sname}&filename=${sfilename}&code=${code}" >
                <i class="mdi mdi-lead-pencil"></i> Edit Profile
                  
                </a>
              </li>
              <li class="nav-item dropdown border-left">
                <a class="nav-link btn  btn-inverse-secondary create-new-button"  href="student_login.jsp" >
                 <i class="mdi mdi-logout text-danger"></i> Log out
                  
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" id="profileDropdown" href="#" data-toggle="dropdown">
                  <div class="navbar-profile">
                    <img class="img-xs rounded-circle" src="getimage_student.jsp?filename=${sfilename}" alt="" style=" width:50px; height:50px;">
                    <p class="mb-0 d-none d-sm-block navbar-profile-name">${sname}</p>
                    
                  </div>
                </a>
               
              </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
              <span class="mdi mdi-format-line-spacing"></span>
            </button>
          </div>
        </nav>
        <!-- partial -->
         <div class="main-panel">
          <div class="content-wrapper">
            <div class="page-header">
                <h1>${cwmsg}</h1>
              <h3 class="page-title"> </h3>
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                 
                </ol>
              </nav>
            </div>
             <%
                ArrayList<classwork> worklist =(ArrayList) request.getAttribute("worklist");
                
                int i = 0;
                for(classwork cw : worklist){
                    i++;
                String num= cw.getBody();
        %>
              <div class="row">
                 
                 <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title" style=" text-align: center;"> <u><b>Classwork No : <%=cw.getClasswork_no()%></b></u></h5>
                    <p><%=cw.getBody()%></p>
                    <a href="getimage_create_classwork.jsp?name=<%=cw.getFilename()%>"> <%=cw.getFilename()%></a><br><br>
                    <p>Deadline:  <%=cw.getDeadline()%> 11:59 PM</p>
                    <p style="text-align: right; font-size: 35px">
                    <a href="downloadFileServletcw?name=<%=cw.getFilename()%>"><i class="mdi mdi-download"></i></a> 
                    </p>
                  </div>
                </div>
              </div>
                   
              <div class="col-md-6 grid-margin stretch-card">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title" style=" text-align:  center;"><u><b>Submit to Classwork - <%=cw.getClasswork_no()%></b></u></h5>
                    <p class="card-description">  </p>
                    <form action="classwork_submit_controller" method="post" enctype="multipart/form-data">
              
              <input type="text" class="image" name="cw_no" value="<%=cw.getClasswork_no()%>" hidden=""    placeholder="enter cw no"/>
             <input type="text" class="image" name="code" value="${code}"  hidden=""  placeholder="enter course code"/><br>
             <input type="text" class="image" name="sname" value="${sname}" hidden=""    placeholder="enter student name"/>
             <input type="text" class="image" name="sid" value="${sid}" hidden=""    placeholder="enter student id"/>
             <input type="text" class="image" name="email" value="${email}" hidden=""    placeholder="enter student id"/>
              <div class="form-group">
                        <label>Click 'select' button for Add File</label>
                        <input type="file" name="file" required="" class="file-upload-default">
                        <div class="input-group col-xs-12">
                            <input type="text" class="form-control file-upload-info" disabled placeholder="Upload Image" required="">
                          <span class="input-group-append">
                            <button class="file-upload-browse btn btn-primary" type="button">Select</button>
                          </span>
                        </div>
               </div>
               <div class="form-group">
                        <label for="exampleTextarea1">Private Comment</label>
                        <textarea class="form-control" name="pcom"   id="exampleTextarea1" rows="1" style="color: white;"></textarea>
                </div>
              
              <p align="center">
                        <button type="submit"  class="btn btn-success btn-rounded btn-fw" >Submit..</button>
                        </p>
          </form>
                  </div>
                </div>
              </div>
            </div>
              <%}%>
          
                  
              
           
                  
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2019 <a href="https://www.bootstrapdash.com/" target="_blank">BootstrapDash</a>. All rights reserved.</span>
              <span class="text-muted float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="mdi mdi-heart text-danger"></i></span>
            </div>
          </footer>
          <!-- partial -->
        </div>
        <!-- main-panel ends -->
      </div>
    </div>
      <!-- page-body-wrapper ends -->
    
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="assets/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <script src="assets/vendors/chart.js/Chart.min.js"></script>
    <script src="assets/vendors/progressbar.js/progressbar.min.js"></script>
    <script src="assets/vendors/jvectormap/jquery-jvectormap.min.js"></script>
    <script src="assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="assets/vendors/owl-carousel-2/owl.carousel.min.js"></script>
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="assets/js/off-canvas.js"></script>
    <script src="assets/js/hoverable-collapse.js"></script>
    <script src="assets/js/misc.js"></script>
    <script src="assets/js/settings.js"></script>
    <script src="assets/js/todolist.js"></script>
    <!-- endinject -->
    <!-- Custom js for this page -->
    <script src="assets/js/dashboard.js"></script>
 <script src="assets/js/file-upload.js"></script>
    <!-- End custom js for this page -->
    
    
  </body>
</html>

