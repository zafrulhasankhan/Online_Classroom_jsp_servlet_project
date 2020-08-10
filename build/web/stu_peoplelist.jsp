<%-- 
    Document   : stu_peoplelist
    Created on : Jul 28, 2020, 12:20:07 AM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="dao.people"%>
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
    <title>People</title>
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
     
           <% /*
               String code = session.getAttribute("code").toString(); 
           PreparedStatement ps6 = DBConnection.getConnection().prepareStatement("SELECT ifnull((SELECT COUNT(id) FROM student_list WHERE course_code=? and id=?),\"post not yet\") as id ");
             ps6.setString(1, code);
             ps6.setString(2, sid);
             
              
             ResultSet rs6=ps6.executeQuery();
             if(rs6.next()){
                 int count = Integer.parseInt(rs6.getString(1));
                 if(count!=0){*/
           %>
           <ul class="nav">
               <li class="nav-item profile">
            <div class="profile-desc">
              <div class="profile-pic">
                <div class="count-indicator">
                    <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=${tecfilename}" alt="image" style="width: 50px; height:50px">
                  
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
          <li class="nav-item menu-items">
            <a class="nav-link" href="student_post_share.jsp?code=${code}&email=${email}&name=${sname}&filename=${sfilename}">
              <span class="menu-icon">
              <i class="mdi mdi-share"></i>
              </span>
              <span class="menu-title">Share Something</span>
            </a>
          </li>
           </ul>
                  <%// } %>
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
                    <h5> ${cname}--${code}</h5>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
              
            <li class="nav-item dropdown border-left">
                <a class="nav-link btn  btn-inverse-secondary create-new-button" title="Edit your Profile"  href="edit_student_acc.jsp?email=${email}&name=${sname}&filename=${sfilename}&code=${code}" >
                <i class="mdi mdi-lead-pencil"></i> 
                  
                </a>
              </li>
              <li class="nav-item dropdown border-left">
                  <a class="nav-link btn  btn-inverse-secondary create-new-button" title="Log out here"  href="student_list.jsp" >
                 <i class="mdi mdi-logout text-danger"></i> 
                  
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
              <h3 class="page-title"> </h3>
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                 
                </ol>
              </nav>
            </div>
              
              <div class="row">
              
              <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        
                   
                      
                   
                   
                    <div class="table-responsive">
                      <table class="table table-striped">
                        <thead>
                          <tr>
                              <th>User</th>
                            <th> Class ID </th>
                            <th> Student  name </th>
                            <th> Email </th>
                            
                            
                          </tr>
                        </thead>
                        <tbody>
                           <%
                ArrayList<people> peoplelist =(ArrayList) request.getAttribute("peoplelist");
                
                int j = 0;
                for(people po1 : peoplelist){
                    j++;
                
        %>
                          <tr>
                            <td class="py-1">
                                <img src="getimage_student.jsp?filename=<%=po1.getPhoto()%>" alt="image" style=" width:50px; height:50px;">
                            </td>
                            <td> 
                                <%= po1.getClass_id()%> 
                            <input type="text" hidden=""   value="<%= po1.getClass_id()%>" name="id"/>
                            </td>
                            <td>
                              <%= po1.getStudentlist()%>
                              <input type="text" hidden="" value="<%= po1.getStudentlist()%>" name="name"/>
                            </td>
                            <td>
                                 
                              <%= po1.getEmail()%>
                              <input type="text" hidden="" value="<%= po1.getStudentlist()%>" name="name"/>
                            </td>
                            
                                
                            
                            
                            
                          </tr>
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
       
                    
          </div>
          <!-- content-wrapper ends -->
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
                <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Created by  <a href="https://web.facebook.com/zafrulhasan.nasim" target="_blank">Zafrul Hasan Nasim </a>.</span>
                <span class="text-muted float-none float-sm-right d-block mt-1 mt-sm-0 text-center"><a href="https://github.com/zafrulhasankhan" title="Github" target="_blank"><i class="mdi mdi-github-circle text-danger" style="font-size:30px;"></i> </a> <a href="https://web.facebook.com/zafrulhasan.nasim"  title="Facebook" target="_blank"><i class="mdi mdi-facebook text-danger" style="font-size:30px;"></i> </a><a href="https://www.instagram.com/zafrul_hasan_nasim/" title="instagram" target="_blank"><i class="mdi mdi-instagram text-danger" style="font-size:30px;"></i> </a></span>
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
 
    <!-- End custom js for this page -->
    
    
  </body>
</html>

