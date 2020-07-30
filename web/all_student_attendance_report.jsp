<%-- 
    Document   : all_student_attendance_report1
    Created on : Jul 25, 2020, 3:40:10 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.allstu_report"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.DBConnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dao.people"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href=assets/vendors/css/vendor.bundle.base.css">
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
            String tecemail = session.getAttribute("tecemail").toString();
            String tecname = session.getAttribute("tecname").toString();
               //String email="nasimkhan18003@gmail.com";
               //String name="nazrul sir";
                
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
                  <span class="count bg-success"></span>
                </div>
                <div class="profile-name">
                  <h5 class="mb-0 font-weight-normal"><%=tecname%></h5>
                  <span>Course Teacher</span>
                </div>
              </div>
              <a href="#" id="profile-dropdown" data-toggle="dropdown"><i class="mdi mdi-dots-vertical"></i></a>
              <div class="dropdown-menu dropdown-menu-right sidebar-dropdown preview-list" aria-labelledby="profile-dropdown">
                <a href="#" class="dropdown-item preview-item">
                  <div class="preview-thumbnail">
                    <div class="preview-icon bg-dark rounded-circle">
                      <i class="mdi mdi-settings text-primary"></i>
                    </div>
                  </div>
                  <div class="preview-item-content">
                    <p class="preview-subject ellipsis mb-1 text-small">Account settings</p>
                  </div>
                </a>
                <div class="dropdown-divider"></div>
                <a href="#" class="dropdown-item preview-item">
                  <div class="preview-thumbnail">
                    <div class="preview-icon bg-dark rounded-circle">
                      <i class="mdi mdi-onepassword  text-info"></i>
                    </div>
                  </div>
                  <div class="preview-item-content">
                    <p class="preview-subject ellipsis mb-1 text-small">Change Password</p>
                  </div>
                </a>
                <div class="dropdown-divider"></div>
                <a href="#" class="dropdown-item preview-item">
                  <div class="preview-thumbnail">
                    <div class="preview-icon bg-dark rounded-circle">
                      <i class="mdi mdi-calendar-today text-success"></i>
                    </div>
                  </div>
                  <div class="preview-item-content">
                    <p class="preview-subject ellipsis mb-1 text-small">To-do list</p>
                  </div>
                </a>
              </div>
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
                   <li class="nav-item"> <a class="nav-link" href="post_form.jsp?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename} "> <%=code%> </a></li>
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
                   <li class="nav-item"> <a class="nav-link" href="attendance_sheet_controller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>"> <%=code%> </a></li>
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
                   <li class="nav-item"> <a class="nav-link" href="peoplelist_controller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"> <%=code%> </a></li>
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
                   <li class="nav-item"> <a class="nav-link" href="delete_course_cotroller?code=<%=code%>&email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}"> <%=code%> </a></li>
                <%}%>
              </ul>
            </div>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="http://www.bootstrapdash.com/demo/corona-free/jquery/documentation/documentation.html">
              <span class="menu-icon">
                <i class="mdi mdi-file-document-box"></i>
              </span>
              <span class="menu-title">Documentation</span>
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
                  <input type="text" class="form-control" placeholder="Search products">
                </form>
              </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
              <li class="nav-item dropdown d-none d-lg-block">
                <a class="nav-link btn btn-success create-new-button" id="createbuttonDropdown" data-toggle="dropdown" aria-expanded="false" href="#">+ Create New Project</a>
                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="createbuttonDropdown">
                  <h6 class="p-3 mb-0">Projects</h6>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-file-outline text-primary"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject ellipsis mb-1">Software Development</p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-web text-info"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject ellipsis mb-1">UI Development</p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-layers text-danger"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject ellipsis mb-1">Software Testing</p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <p class="p-3 mb-0 text-center">See all projects</p>
                </div>
              </li>
              <li class="nav-item nav-settings d-none d-lg-block">
                <a class="nav-link" href="#">
                  <i class="mdi mdi-view-grid"></i>
                </a>
              </li>
              <li class="nav-item dropdown border-left">
                <a class="nav-link count-indicator dropdown-toggle" id="messageDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                  <i class="mdi mdi-email"></i>
                  <span class="count bg-success"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="messageDropdown">
                  <h6 class="p-3 mb-0">Messages</h6>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <img src="assets/images/faces/face4.jpg" alt="image" class="rounded-circle profile-pic">
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject ellipsis mb-1">Mark send you a message</p>
                      <p class="text-muted mb-0"> 1 Minutes ago </p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <img src="assets/images/faces/face2.jpg" alt="image" class="rounded-circle profile-pic">
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject ellipsis mb-1">Cregh send you a message</p>
                      <p class="text-muted mb-0"> 15 Minutes ago </p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <img src="assets/images/faces/face3.jpg" alt="image" class="rounded-circle profile-pic">
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject ellipsis mb-1">Profile picture updated</p>
                      <p class="text-muted mb-0"> 18 Minutes ago </p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <p class="p-3 mb-0 text-center">4 new messages</p>
                </div>
              </li>
              <li class="nav-item dropdown border-left">
                <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
                  <i class="mdi mdi-bell"></i>
                  <span class="count bg-danger"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="notificationDropdown">
                  <h6 class="p-3 mb-0">Notifications</h6>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-calendar text-success"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1">Event today</p>
                      <p class="text-muted ellipsis mb-0"> Just a reminder that you have an event today </p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-settings text-danger"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1">Settings</p>
                      <p class="text-muted ellipsis mb-0"> Update dashboard </p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-link-variant text-warning"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1">Launch Admin</p>
                      <p class="text-muted ellipsis mb-0"> New admin wow! </p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <p class="p-3 mb-0 text-center">See all notifications</p>
                </div>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" id="profileDropdown" href="#" data-toggle="dropdown">
                  <div class="navbar-profile">
                    <img class="img-xs rounded-circle" src="getimage_teacher.jsp?filename=${filename}" alt="" style=" width:50px; height:50px;">
                    <p class="mb-0 d-none d-sm-block navbar-profile-name"><%=tecname%></p>
                    <i class="mdi mdi-menu-down d-none d-sm-block"></i>
                  </div>
                </a>
                <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list" aria-labelledby="profileDropdown">
                  <h6 class="p-3 mb-0">Profile</h6>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item" href="edit_teacher.jsp?email=<%=tecemail%>&name=<%=tecname%>&filename=${filename}" >
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-settings text-success"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1">Edit Profile</p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item preview-item" href="index.jsp">
                    <div class="preview-thumbnail">
                      <div class="preview-icon bg-dark rounded-circle">
                        <i class="mdi mdi-logout text-danger"></i>
                      </div>
                    </div>
                    <div class="preview-item-content">
                      <p class="preview-subject mb-1">Log out</p>
                    </div>
                  </a>
                  <div class="dropdown-divider"></div>
                  <p class="p-3 mb-0 text-center">Advanced settings</p>
                </div>
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
              <h4 style=" text-align: center"><u>Attendance List</u></h4><br>
             <div class="page-header">
                
                <h3 class="page-title"> Course teacher name. : ${tecname} </h3>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    
                    <li class="breadcrumb-item" style="font-size:16px"><b>Course code : ${code}</b></li>
                    
                    
                 </ol>
              </nav>
            </div>
            
            
             <form action="attendance_sent_email_controller" method="get"> 
               <input type="text" name="code" value="${code}"  hidden="" placeholder="out of 10"> 
               <input type="text" name="afilename" value="${filename}"  hidden="" placeholder="out of 10">
            <div class="row">
              
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        
                   
                      
                   
                   
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <thead>
                          <tr>
                              <th>User</th>
                            <th> Student ID </th>
                            <th> Student  name </th>
                            <th>No. of presented class</th>
                            <th> No. of total class</th>
                            <th>Percentage</th>
                            
                            
                          </tr>
                        </thead>
                        <tbody>
                           <%
                ArrayList<allstu_report> allreportlist =(ArrayList) request.getAttribute("allreportlist");
                
                int i = 0;
                for(allstu_report u : allreportlist){
                    i++;
               int present = u.getPresentno(); 
               int total = u.getTotalday();
               float per=(((float)present)/total)*100;
        %>
                          <tr>
                            <td class="py-1">
                                <img src="getimage_student.jsp?filename=${sfilename}" alt="image" style=" width:90px; height:90px;">
                            </td>
                            <td> 
                                <%= u.getClassid()%> 
                           
                            </td>
                            <td>
                              <%=u.getStudent_name()%>
                              
                            </td>
                            <td>
                                 
                              <%= present%>
                             
                            </td>
                             <td>
                                 
                              <%=total%>
                             
                            </td>
                             <td>
                                 
                              <%=per%>
                             
                            </td>
                            
                                
                            
                            
                            
                          </tr>
                           
      
                         
                          
                          <input type="text" name="stuemail" value="<%= u.getEmail()%>" hidden="" >
            <input type="text" name="stuid" value="<%= u.getClassid()%>" hidden="" > 
            <input type="text" name="stuname" value="<%= u.getStudent_name()%>" hidden="" >
            <input type="text" name="present" value="<%= present%>" hidden="" >
            <input type="text" name="total" value="<%=total%>" hidden="" >
            <input type="text" name="per" value="<%=per%>" hidden="" >
        <%
            
      }
      %>
                          
                        </tbody>
                      </table>
                    </div>
                  
                  </div>
                </div>
              </div>
              
               
              
            </div>
                    
      <h3 style="text-align:center">
            <button type="submit" class="btn btn-success btn-fw">Save and sent to email</button>
      </h3>
             </form>
             
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
    <!-- Custom js for this page -->
    <!-- End custom js for this page -->
  </body>
</html>
