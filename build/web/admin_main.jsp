<%-- 
    Document   : admin_main1
    Created on : Jul 15, 2020, 7:59:15 PM
    Author     : Zafrul Hasan Nasim
--%>

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
       <%
            String tecemail = session.getAttribute("email").toString();
            String tecname = session.getAttribute("name").toString();
              
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
            ps.setString(1, tecname);
            ps.setString(2, tecemail);
            ResultSet rs = ps.executeQuery();%>
            
            
            
                  
                  
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
                    <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=${filename}" alt="" style="width: 80px; height: 80px">
                  
                </div>
                <div class="profile-name">
                    <h5 class="mb-0 font-weight-normal"><%=tecname%></h5>
                  <span>Course Teacher</span>
                </div>
              </div>
              <a href="#" id="profile-dropdown" data-toggle="dropdown"></a>
             
            </div>
          </li>
          <li class="nav-item nav-category">
            <span class="nav-link">Navigation</span>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="admin_home_redirect?email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} ">
              <span class="menu-icon">
                <i class="mdi mdi-speedometer"></i>
              </span>
              <span class="menu-title">Home </span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="add_course.jsp?email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} ">
              <span class="menu-icon">
                <i class="mdi mdi-speedometer"></i>
              </span>
              <span class="menu-title">Add Course </span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ed" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <i class="mdi mdi-laptop"></i>
              </span>
              <span class="menu-title">Edit Course and pin</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ed">
              <ul class="nav flex-column sub-menu">
                 <% 
                      PreparedStatement  psed = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psed.setString(1, tecname);
                      psed.setString(2, tecemail);
                      ResultSet rsed = psed.executeQuery();
                      while(rsed.next()){
                    String code = rsed.getString("course_code");%>
            
                    <li class="nav-item"> <a class="nav-link" href="edit_course.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"><%=code%></a></li>
                <% }%>
              </ul>
            </div>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <span class="menu-icon">
                <i class="mdi mdi-laptop"></i>
              </span>
              <span class="menu-title">View Course</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                 <% while(rs.next()){
                    String code = rs.getString("course_code");%>
            
                    <li class="nav-item"> <a class="nav-link" href="select_course_controller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"><%=code%></a></li>
                <% }%>
              </ul>
            </div>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#auth1" aria-expanded="false" aria-controls="auth">
              <span class="menu-icon">
                <i class="mdi mdi-security"></i>
              </span>
              <span class="menu-title">Add post in course</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="auth1">
              <ul class="nav flex-column sub-menu">
                  <% 
                      PreparedStatement  ps1 = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      ps1.setString(1, tecname);
                      ps1.setString(2, tecemail);
                      ResultSet rs1 = ps1.executeQuery();
                      while(rs1.next()){
                    String code = rs1.getString("course_code");%>
                   <li class="nav-item"> <a class="nav-link" href="post_form.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} "> <%=code%> </a>
                       </li>
                   </li>
                <%}%>
              </ul>
            </div>
          </li>
          
          
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#authcw" aria-expanded="false" aria-controls="auth">
              <span class="menu-icon">
                <i class="mdi mdi-security"></i>
              </span>
              <span class="menu-title">Create Classwork </span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="authcw">
              <ul class="nav flex-column sub-menu">
                  <% 
                      PreparedStatement  pscw = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      pscw.setString(1, tecname);
                      pscw.setString(2, tecemail);
                      ResultSet rscw = pscw.executeQuery();
                      while(rscw.next()){
                    String code = rscw.getString("course_code");%>
                   <li class="nav-item"> <a class="nav-link" href="last_classwork_no?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} "> <%=code%> </a></li>
                <%}%>
              </ul>
            </div>
          </li>
          
         
                  
           <li class="nav-item menu-items"> 
           
           <a class="nav-link" data-toggle="collapse" href="#authta" aria-expanded="false" aria-controls="auth">
              <span class="menu-icon">
                <i class="mdi mdi-security"></i>
              </span>
              <span class="menu-title">Take Attendance</span>
              <i class="menu-arrow"></i>
            </a>
               <div class="collapse" id="authta">
                   <ul class="nav flex-column sub-menu">
                     <% 
                      PreparedStatement  psta = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psta.setString(1, tecname);
                      psta.setString(2, tecemail);
                      ResultSet rsta = psta.executeQuery();
                      while(rsta.next()){
                    String code = rsta.getString("course_code");%>
                   <li class="nav-item"> <a class="nav-link" href="attendance_sheet_controller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}" > <%=code%> </a></li>
                <%}%>  
                   </ul>
               </div>
           </li>
             <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#authsl" aria-expanded="false" aria-controls="auth">
              <span class="menu-icon">
                <i class="mdi mdi-security"></i>
              </span>
              <span class="menu-title">Student List</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="authsl">
              <ul class="nav flex-column sub-menu">
                  <% 
                      PreparedStatement  pssl= DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      pssl.setString(1, tecname);
                      pssl.setString(2, tecemail);
                      ResultSet rssl = pssl.executeQuery();
                      while(rssl.next()){
                    String code = rssl.getString("course_code");%>
                   <li class="nav-item"> <a class="nav-link" href="peoplelist_controller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} "> <%=code%> </a></li>
                <%}%>
              </ul>
            </div>
          </li>   
              
          
          <li class="nav-item menu-items">
            <a class="nav-link" data-toggle="collapse" href="#auth" aria-expanded="false" aria-controls="auth">
              <span class="menu-icon">
                <i class="mdi mdi-security"></i>
              </span>
              <span class="menu-title">Delete course</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="auth">
              <ul class="nav flex-column sub-menu">
                  <% 
                      PreparedStatement  ps3 = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      ps3.setString(1, tecname);
                      ps3.setString(2, tecemail);
                      ResultSet rs3 = ps3.executeQuery();
                      while(rs3.next()){
                    String code = rs3.getString("course_code");%>
                   <li class="nav-item"> <a class="nav-link" href="delete_alert.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} "> <%=code%> </a></li>
                <%}%>
              </ul>
            </div>
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
              <h2 style="margin: 0 auto; color: red;" > </h2>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
              <li class="nav-item dropdown border-left">
                <a class="nav-link btn btn-inverse-secondary create-new-button "  href="edit_teacher.jsp?email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}" >
                <i class="mdi mdi-lead-pencil"></i> Edit Profile
                  
                </a>
              </li>
              <li class="nav-item dropdown border-left">
                <a class="nav-link btn btn-inverse-secondary create-new-button" href="teacher_login_form.jsp" >
                    <i class="mdi mdi-logout text-danger"></i> Log out
                  
                </a>
              </li>
             
              
              
              <li class="nav-item dropdown">
                <a class="nav-link" id="profileDropdown" href="#" data-toggle="dropdown">
                  <div class="navbar-profile">
                    <img class="img-xs rounded-circle" src="getimage_teacher.jsp?filename=${filename}" alt="" style=" width:50px; height:50px;">
                    <p class="mb-0 d-none d-sm-block navbar-profile-name"><%=tecname%></p>
                    
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
           
             
              <h3 style="text-align: center">Welcome to Teacher panel</h3><br><br><br>
              <h4 style="text-align: center;">${ncd}</h4>
              <h4 style="text-align: center;">${ssa}</h4>
            <div class="row">
              <div class="col-sm-4 grid-margin">
                <div class="card">
                  <div class="card-body">
                      <h4>Attendance report</h4><br>
                    <div class="row">
                      <div class="col-8 col-sm-12 col-xl-8 my-auto">
                        <div class="d-flex d-sm-block d-md-flex align-items-center">
                            
                       <div class="dropdown">
                        <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuOutlineButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Individual report </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOutlineButton1">
                           <h6 class="dropdown-header">Course code</h6>
                            <% 
                      PreparedStatement  psi = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psi.setString(1, tecname);
                      psi.setString(2, tecemail);
                      ResultSet rsi = psi.executeQuery();
                      while(rsi.next()){
                    String code = rsi.getString("course_code");%>
                          <a class="dropdown-item" href="individual_report_form.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}" ><%=code%></a>
                          <%}%>
                        </div>
                        </div>
                       </div><br>
                        
                        <div class="dropdown">
                        <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuOutlineButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Date Wise report </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOutlineButton1">
                           <h6 class="dropdown-header">Course code</h6>
                            <% 
                      PreparedStatement  psd = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psd.setString(1, tecname);
                      psd.setString(2, tecemail);
                      ResultSet rsd = psd.executeQuery();
                      while(rsd.next()){
                    String code = rsd.getString("course_code");%>
                          <a class="dropdown-item" href="datewise_attendance_report.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"><%=code%></a>
                          <%}%>
                        </div>
                        </div><br>
                        
                        
                        <div class="dropdown">
                        <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuOutlineButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> All Student report </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOutlineButton1">
                           <h6 class="dropdown-header">Course code</h6>
                            <% 
                      PreparedStatement  psa = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psa.setString(1, tecname);
                      psa.setString(2, tecemail);
                      ResultSet rsa = psa.executeQuery();
                      while(rsa.next()){
                    String code = rsa.getString("course_code");%>
                          <a class="dropdown-item" href="all_student_attendance_report_controller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}" ><%=code%></a>
                          <%}%>
                        </div>
                      </div>
                      </div>
                      <div class="col-4 col-sm-12 col-xl-4 text-center text-xl-right">
                          <img src="assets/images/attendent_shift.png" height="90px" width="75px">
                      </div>
                    </div>
                  </div>
                </div>
              </div>
             
              <div class="col-sm-4 grid-margin">
                <div class="card">
                  <div class="card-body">
                      <h4>Classwork report and details</h4><br><br>
                    <div class="row">
                      <div class="col-8 col-sm-12 col-xl-8 my-auto">
                        <div class="d-flex d-sm-block d-md-flex align-items-center">
                          
                       
                          <div class="dropdown">
                        <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuOutlineButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Show classwork </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOutlineButton1">
                           <h6 class="dropdown-header">Course code</h6>
                            <% 
                      PreparedStatement  pscr = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      pscr.setString(1, tecname);
                      pscr.setString(2, tecemail);
                      ResultSet rscr = pscr.executeQuery();
                      while(rscr.next()){
                    String code = rscr.getString("course_code");%>
                          <a class="dropdown-item" href="all_classwork_codewise?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"><%=code%></a>
                          <%}%>
                        </div>
                        </div>
                        </div><br><br>
                          
                         <div class="dropdown">
                        <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuOutlineButton1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Classwork marks </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuOutlineButton1">
                           <h6 class="dropdown-header">Course code</h6>
                            <% 
                      PreparedStatement  pscs = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      pscs.setString(1, tecname);
                      pscs.setString(2, tecemail);
                      ResultSet rscs = pscs.executeQuery();
                      while(rscs.next()){
                    String code = rscs.getString("course_code");%>
                          <a class="dropdown-item" href="classwork_mark_form.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"><%=code%></a>
                          <%}%>
                        </div>
                        </div>
                        
                      </div>
                      <div class="col-4 col-sm-12 col-xl-4 text-center text-xl-right">
                        <i class="icon-lg mdi mdi-monitor text-success ml-auto"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
                <div class="col-sm-4 grid-margin">
                <div class="card">
                  <div class="card-body">
                      <h6>Without Gmail verification , all the students will not get the latest updates of the class.If you already get the Gmail verification message,then there is no need for more Gmail verification.<code>Otherwise verify Gmail by cliclking below</code></h6>
                    <div class="row">
                      <div class="col-8 col-sm-12 col-xl-8 my-auto">
                        <div class="d-flex d-sm-block d-md-flex align-items-center">
                         
                            <a href="email_verification.jsp?email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}">Gmail Verification</a>
                              
                         
                        </div>
                            
                      </div>
                      <div class="col-4 col-sm-12 col-xl-4 text-center text-xl-right">
                        
                        <i class="mdi mdi-gmail" style="font-size: 50px;"></i>  
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          
           
            </div>
          
          <!-- content-wrapper ends -->
          <!-- partial:partials/_footer.html -->
          
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
 
    <!-- End custom js for this page -->
    
    <%
            String ssp = session.getAttribute("ssp").toString();  
            String ssp1="ssp"; 
            
            String nos = session.getAttribute("nos").toString();  
            String nos1="nos"; 
            
            String sac = session.getAttribute("sac").toString();  
            String sac1="sac";
            
            String dc = session.getAttribute("dc").toString();  
            String dc1="dc";
            
            String ae = session.getAttribute("ae").toString();  
            String ae1="ae"; 
            
            String cp = session.getAttribute("cp").toString();  
            String cp1="cp";
            
            String np = session.getAttribute("np").toString();  
            String np1="np"; 
            
            String nwc = session.getAttribute("nwc").toString();  
            String nwc1="nwc"; 
            
            String ncm = session.getAttribute("ncm").toString();  
            String ncm1="ncm"; 
            
            String asa = session.getAttribute("asa").toString();  
            String asa1="asa"; 
            
            String ev = session.getAttribute("ev").toString();  
            String ev1="ev"; 
            
            String ns = session.getAttribute("ns").toString();  
            String ns1="ns"; 
            String se = session.getAttribute("se").toString();  
            String se1="se"; 
            
               if(ssp1==ssp){
            %>
            <script type="text/javascript">
            alert('Successfully save and sent post');
            </script>
                  <% } 
                  
                  
                  
            
            else if (nos1==nos){
            %>
            <script type="text/javascript">
            alert('No one Submit this work yet');
            </script>
                  <% } 
                  
                  
                  
             
           else  if(sac1==sac){
            %>
            <script type="text/javascript">
            alert('Course successfully added');
            </script>
                  <% }
                       
                  
                  
                 
            
           else  if(dc1==dc){
            %>
            <script type="text/javascript">
            alert('Course successfully deleted');
            </script>
                  <% }  
                  else  if(ae1==ae){
            %>
            <script type="text/javascript">
            alert('Already exists, change course pin or course code because course pin and course code should be unique');
            </script>
                  <% }  
                  else  if(np1==np){
            %>
            <script type="text/javascript">
            alert('No post uploaded Yet');
            </script>
                  <% }  
                  else  if(nwc1==nwc){
            %>
            <script type="text/javascript">
            alert('No classwork created Yet');
            </script>
                  <% }
                  else  if(ncm1==ncm){
            %>
            <script type="text/javascript">
            alert('No classwork mark set Yet');
            </script>
                  <% }
                  else  if(asa1==asa){
            %>
            <script type="text/javascript">
            alert('No Attendance taken  Yet');
            </script>
                  <% }
                  else  if(ev1==ev){
            %>
            <script type="text/javascript">
            alert('Email verified! Check your gmail inbox either get email yes verfied or try again...click.. Email verification');
            </script>
                  <% }
                  else  if(ns1==ns){
            %>
            <script type="text/javascript">
            alert('No Student Found in this course ');
            </script>
                  <% }
                  else  if(se1==se){
            %>
            <script type="text/javascript">
            alert('Successfully course edited ');
            </script>
                  <% }%>
          
  </body>
</html>
