<%-- 
    Document   : student_post_form
    Created on : Jul 25, 2020, 9:49:54 PM
    Author     : Zafrul Hasan Nasim
--%>

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
    <title>Home</title>
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
    <style>
.alert {
  padding: 20px;
  background-color: red;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: white;
}

         .tooltip {
  position: relative;
  display: inline-block;
    
    position: center;
}



.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
  background-color: black;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;

  /* Position the tooltip */
  position: absolute;
  z-index: 1;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
} 
        
</style>
  </head>
  <body>
       
      
        <%
            String semail = session.getAttribute("semail").toString();
            String sname = session.getAttribute("sname").toString();
            String sid = session.getAttribute("sid").toString();
            String coursename = session.getAttribute("course_name").toString();
            String sfilename = session.getAttribute("sfilename").toString();
           String code = session.getAttribute("code").toString();
             String tecname = session.getAttribute("tecname").toString();
             String tecemail = session.getAttribute("tecemail").toString();
              String tecfilename = session.getAttribute("tecfilename").toString();
              // String npmsg = session.getAttribute("npmsg").toString();
            %>
            
                  
                  
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
                    <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=<%=tecfilename%>" alt="image" style="width: 50px; height: 50px">
                  
                </div>
                <div class="profile-name">
                    <h5 class="mb-0 font-weight-normal"><%=tecname%></h5>
                  <span>Course Teacher</span>
                </div>
              </div>
            </div>
               </li><br><br>
               
               <li class="nav-item menu-items">
            <a class="nav-link" href="student_post_list_controller?code=<%=code%>&email=<%=semail%>">
              <span class="menu-icon">
               <i class="mdi mdi-home"></i>
              </span>
              <span class="menu-title">Home </span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="return_create_classwork?code=<%=code%>&email=<%=semail%>&cname=<%=coursename%>&sname=<%=sname%>&tecname=<%=tecname%>&tecfilename=<%=tecfilename%>">
              <span class="menu-icon">
               <i class="mdi mdi-newspaper"></i>
              </span>
              <span class="menu-title">Classwork </span>
            </a>
          </li>
           <li class="nav-item menu-items">
            <a class="nav-link" href="stu_people_list_controller?code=<%=code%>&email=<%=semail%>&cname=<%=coursename%>&sname=<%=sname%>&tecname=<%=tecname%>&tecfilename=<%=tecfilename%> ">                                                                                                                                                                                                                                                                                                                                                                                           
              <span class="menu-icon">
              <i class="mdi mdi-account-multiple"></i>
              </span>
              <span class="menu-title">People</span>
            </a>
          </li>
          <li class="nav-item menu-items">
            <a class="nav-link" href="student_post_share.jsp?code=${code}&email=<%=semail%>&name=<%=sname%>&filename=${sfilename} ">                                                                                                                                                                                                                                                                                                                                                                                           
              <span class="menu-icon">
              <i class="mdi mdi-share"></i>
              </span>
              <span class="menu-title">Share Something </span>
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
                    <h5><%=coursename%>--<%=code%></h5>
                </form>
              </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
              <li class="nav-item dropdown d-none d-lg-block">
               
              </li>
              <li class="nav-item dropdown border-left">
              
                <a class="nav-link btn btn-inverse-secondary  create-new-button " title="Edit Your Profile"  href="edit_student_acc.jsp?email=<%=semail%>&name=<%=sname%>&filename=${sfilename}&code=${code}" >
                <i class="mdi mdi-lead-pencil"></i>
                  
                </a>

                    
                
              </li>
             
              <li class="nav-item dropdown border-left">
                  
                  <a class="nav-link btn btn-inverse-secondary create-new-button" title="Log out here" href="student_login.jsp" >
                    
                    <i class="mdi mdi-logout text-danger"></i>
                  
                   
                </a>
                  
              </li>
              
               <li class="nav-item dropdown">
                <a class="nav-link" id="profileDropdown" href="#" data-toggle="dropdown">
                  <div class="navbar-profile">
                    <img class="img-xs rounded-circle" src="getimage_student.jsp?filename=${sfilename}" alt="" style=" width:42px; height:42px;" >
                    <p class="mb-0 d-none d-sm-block navbar-profile-name"><%=sname%></p>
                   
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
              <h4 style="text-align: center;color: blue;"><u>All - post's</u></h4><br>
             <h1 style="text-align: center;">${npmsg}</h1>
             <%
                 String ncw = session.getAttribute("ncw").toString();  
            String ncw1="ncw"; 
            
               if(ncw1==ncw){
            %>
             
             <div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>Hey!</strong> No ClassWork Created in ' <%=code%> ' Yet By Teacher
</div>
             <%}%>
            <div class="page-header">
               
              
              <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                 
                </ol>
              </nav>
            </div>
              
              <%
                ArrayList<post> postlist =(ArrayList) request.getAttribute("postlist");
                
                int i = 0;
                for(post po : postlist){
                    i++;
                
        %>
              <div class="row">
                 
                  <div class="col-12 grid-margin stretch-card" style="position: center">
                <div class="card">
                  <div class="card-body">
                      <h6 style="text-align:center;"><u> <%=po.getTime()%></u></h6>
                      <h4 class="card-title">
                          
                      
                          <img class="img-xs rounded-circle " src="getimage_teacher.jsp?filename=<%= po.getPoster_filename()%>" alt="" style="width: 50px; height: 50px">  <%= po.getPoster_name()%> 
                      
                      </h4>
                     
                               
                    <p class="card-description"><%= po.getBody()%> </p>
                    <a href="getImage.jsp?name=<%=po.getName()%>"> <u><%=po.getName()%></u> </a>
                    <p style="text-align: right; font-size: 35px">
                    <a href="downloadFileServlet?name=<%=po.getName()%>"><i class="mdi mdi-download"></i></a> 
                    </p>
                  
                    
                    
                  </div>
                </div>
              </div> 
                  
              
            </div>
                    <%}%>
          </div>
          
          <!-- partial:../../partials/_footer.html -->
          <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
                <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Created by  <a href="https://web.facebook.com/zafrulhasan.nasim" target="_blank">Zafrul Hasan Nasim </a>.</span>
                <span class="text-muted float-none float-sm-right d-block mt-1 mt-sm-0 text-center"><a href="https://github.com/zafrulhasankhan" title="Github" target="_blank"><i class="mdi mdi-github-circle text-danger" style="font-size:30px;"></i> </a> <a href="https://web.facebook.com/zafrulhasan.nasim" title="Facebook" target="_blank"><i class="mdi mdi-facebook text-danger" style="font-size:30px;"></i> </a><a href="https://www.instagram.com/zafrul_hasan_nasim/"  title="instagram" target="_blank"><i class="mdi mdi-instagram text-danger" style="font-size:30px;"></i> </a></span>
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

