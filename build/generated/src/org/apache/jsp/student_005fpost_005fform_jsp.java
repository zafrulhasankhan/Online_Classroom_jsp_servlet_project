package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;

public final class student_005fpost_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Corona Admin</title>\n");
      out.write("    <!-- plugins:css -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/mdi/css/materialdesignicons.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/css/vendor.bundle.base.css\">\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin css for this page -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/jvectormap/jquery-jvectormap.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/flag-icon-css/css/flag-icon.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/owl-carousel-2/owl.carousel.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/owl-carousel-2/owl.theme.default.min.css\">\n");
      out.write("    <!-- End plugin css for this page -->\n");
      out.write("    <!-- inject:css -->\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Layout styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("    <!-- End layout styles -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"assets/images/favicon.png\" />\n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("       ");

            String tecemail = session.getAttribute("email").toString();
            String tecname = session.getAttribute("name").toString();
              
            PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
            ps.setString(1, tecname);
            ps.setString(2, tecemail);
            ResultSet rs = ps.executeQuery();
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("    <div class=\"container-scroller\">\n");
      out.write("      <!-- partial:partials/_sidebar.html -->\n");
      out.write("     \n");
      out.write("      <!-- partial -->\n");
      out.write("      <div class=\"container-fluid page-body-wrapper\">\n");
      out.write("        <!-- partial:partials/_navbar.html -->\n");
      out.write("        <nav class=\"navbar p-0 fixed-top d-flex flex-row\">\n");
      out.write("          <div class=\"navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center\">\n");
      out.write("            <a class=\"navbar-brand brand-logo-mini\" href=\"index.html\"><img src=\"assets/images/logo-mini.svg\" alt=\"logo\" /></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"navbar-menu-wrapper flex-grow d-flex align-items-stretch\">\n");
      out.write("            <button class=\"navbar-toggler navbar-toggler align-self-center\" type=\"button\" data-toggle=\"minimize\">\n");
      out.write("              <span class=\"mdi mdi-menu\"></span>\n");
      out.write("            </button>\n");
      out.write("            <ul class=\"navbar-nav w-100\">\n");
      out.write("              <li class=\"nav-item w-100\">\n");
      out.write("                <form class=\"nav-link mt-2 mt-md-0 d-none d-lg-flex search\">\n");
      out.write("                  <input type=\"text\" class=\"form-control\" placeholder=\"Search products\">\n");
      out.write("                </form>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("            <ul class=\"navbar-nav navbar-nav-right\">\n");
      out.write("              <li class=\"nav-item dropdown d-none d-lg-block\">\n");
      out.write("                <a class=\"nav-link btn btn-success create-new-button\" id=\"createbuttonDropdown\" data-toggle=\"dropdown\" aria-expanded=\"false\" href=\"#\"></a>\n");
      out.write("                <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"createbuttonDropdown\">\n");
      out.write("                  <h6 class=\"p-3 mb-0\">Projects</h6>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-file-outline text-primary\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject ellipsis mb-1\">Software Development</p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-web text-info\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject ellipsis mb-1\">UI Development</p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-layers text-danger\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject ellipsis mb-1\">Software Testing</p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <p class=\"p-3 mb-0 text-center\">See all projects</p>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item nav-settings d-none d-lg-block\">\n");
      out.write("                <a class=\"nav-link\" href=\"#\">\n");
      out.write("                  <i class=\"mdi mdi-view-grid\"></i>\n");
      out.write("                </a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item dropdown border-left\">\n");
      out.write("                <a class=\"nav-link count-indicator dropdown-toggle\" id=\"messageDropdown\" href=\"#\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                  <i class=\"mdi mdi-email\"></i>\n");
      out.write("                  <span class=\"count bg-success\"></span>\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"messageDropdown\">\n");
      out.write("                  <h6 class=\"p-3 mb-0\">Messages</h6>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <img src=\"assets/images/faces/face4.jpg\" alt=\"image\" class=\"rounded-circle profile-pic\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject ellipsis mb-1\">Mark send you a message</p>\n");
      out.write("                      <p class=\"text-muted mb-0\"> 1 Minutes ago </p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <img src=\"assets/images/faces/face2.jpg\" alt=\"image\" class=\"rounded-circle profile-pic\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject ellipsis mb-1\">Cregh send you a message</p>\n");
      out.write("                      <p class=\"text-muted mb-0\"> 15 Minutes ago </p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <img src=\"assets/images/faces/face3.jpg\" alt=\"image\" class=\"rounded-circle profile-pic\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject ellipsis mb-1\">Profile picture updated</p>\n");
      out.write("                      <p class=\"text-muted mb-0\"> 18 Minutes ago </p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <p class=\"p-3 mb-0 text-center\">4 new messages</p>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item dropdown border-left\">\n");
      out.write("                <a class=\"nav-link count-indicator dropdown-toggle\" id=\"notificationDropdown\" href=\"#\" data-toggle=\"dropdown\">\n");
      out.write("                  <i class=\"mdi mdi-bell\"></i>\n");
      out.write("                  <span class=\"count bg-danger\"></span>\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"notificationDropdown\">\n");
      out.write("                  <h6 class=\"p-3 mb-0\">Notifications</h6>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-calendar text-success\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject mb-1\">Event today</p>\n");
      out.write("                      <p class=\"text-muted ellipsis mb-0\"> Just a reminder that you have an event today </p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-settings text-danger\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject mb-1\">Settings</p>\n");
      out.write("                      <p class=\"text-muted ellipsis mb-0\"> Update dashboard </p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-link-variant text-warning\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject mb-1\">Launch Admin</p>\n");
      out.write("                      <p class=\"text-muted ellipsis mb-0\"> New admin wow! </p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <p class=\"p-3 mb-0 text-center\">See all notifications</p>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item dropdown\">\n");
      out.write("                <a class=\"nav-link\" id=\"profileDropdown\" href=\"#\" data-toggle=\"dropdown\">\n");
      out.write("                  <div class=\"navbar-profile\">\n");
      out.write("                    <img class=\"img-xs rounded-circle\" src=\"getimage_teacher.jsp?filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"\" style=\" width:50px; height:50px;\">\n");
      out.write("                    <p class=\"mb-0 d-none d-sm-block navbar-profile-name\">");
      out.print(tecname);
      out.write("</p>\n");
      out.write("                    <i class=\"mdi mdi-menu-down d-none d-sm-block\"></i>\n");
      out.write("                  </div>\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown-menu dropdown-menu-right navbar-dropdown preview-list\" aria-labelledby=\"profileDropdown\">\n");
      out.write("                  <h6 class=\"p-3 mb-0\">Profile</h6>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\" href=\"edit_teacher.jsp?email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-settings text-success\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                      <p class=\"preview-subject mb-1\">Edit Profile</p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <a class=\"dropdown-item preview-item\" href=\"index.jsp\">\n");
      out.write("                    <div class=\"preview-thumbnail\">\n");
      out.write("                      <div class=\"preview-icon bg-dark rounded-circle\">\n");
      out.write("                        <i class=\"mdi mdi-logout text-danger\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"preview-item-content\">\n");
      out.write("                        <p class=\"preview-subject mb-1\" >Log out</p>\n");
      out.write("                    </div>\n");
      out.write("                  </a>\n");
      out.write("                  <div class=\"dropdown-divider\"></div>\n");
      out.write("                  <p class=\"p-3 mb-0 text-center\">Advanced settings</p>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("            <button class=\"navbar-toggler navbar-toggler-right d-lg-none align-self-center\" type=\"button\" data-toggle=\"offcanvas\">\n");
      out.write("              <span class=\"mdi mdi-format-line-spacing\"></span>\n");
      out.write("            </button>\n");
      out.write("          </div>\n");
      out.write("        </nav>\n");
      out.write("        <!-- partial -->\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("          <div class=\"content-wrapper\">\n");
      out.write("           \n");
      out.write("             \n");
      out.write("              <h3 style=\"text-align: center\">Welcome to Teacher panel</h3><br><br><br>\n");
      out.write("              \n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-sm-4 grid-margin\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                      <h4>Attendance report</h4><br>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                      <div class=\"col-8 col-sm-12 col-xl-8 my-auto\">\n");
      out.write("                        <div class=\"d-flex d-sm-block d-md-flex align-items-center\">\n");
      out.write("                            \n");
      out.write("                       <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"dropdownMenuOutlineButton1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Individual report </button>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuOutlineButton1\">\n");
      out.write("                           <h6 class=\"dropdown-header\">Course code</h6>\n");
      out.write("                            ");
 
                      PreparedStatement  psi = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psi.setString(1, tecname);
                      psi.setString(2, tecemail);
                      ResultSet rsi = psi.executeQuery();
                      while(rsi.next()){
                    String code = rsi.getString("course_code");
      out.write("\n");
      out.write("                          <a class=\"dropdown-item\" href=\"individual_report_form.jsp?code=");
      out.print(code);
      out.write("&email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >");
      out.print(code);
      out.write("</a>\n");
      out.write("                          ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                       </div><br>\n");
      out.write("                        \n");
      out.write("                        <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"dropdownMenuOutlineButton1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Date Wise report </button>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuOutlineButton1\">\n");
      out.write("                           <h6 class=\"dropdown-header\">Course code</h6>\n");
      out.write("                            ");
 
                      PreparedStatement  psd = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psd.setString(1, tecname);
                      psd.setString(2, tecemail);
                      ResultSet rsd = psd.executeQuery();
                      while(rsd.next()){
                    String code = rsd.getString("course_code");
      out.write("\n");
      out.write("                          <a class=\"dropdown-item\" href=\"datewise_attendance_report.jsp?code=");
      out.print(code);
      out.write("&email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.print(code);
      out.write("</a>\n");
      out.write("                          ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        </div><br>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"dropdownMenuOutlineButton1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> All Student report </button>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuOutlineButton1\">\n");
      out.write("                           <h6 class=\"dropdown-header\">Course code</h6>\n");
      out.write("                            ");
 
                      PreparedStatement  psa = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      psa.setString(1, tecname);
                      psa.setString(2, tecemail);
                      ResultSet rsa = psa.executeQuery();
                      while(rsa.next()){
                    String code = rsa.getString("course_code");
      out.write("\n");
      out.write("                          <a class=\"dropdown-item\" href=\"all_student_attendance_report_controller?code=");
      out.print(code);
      out.write("&email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" >");
      out.print(code);
      out.write("</a>\n");
      out.write("                          ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-4 col-sm-12 col-xl-4 text-center text-xl-right\">\n");
      out.write("                          <img src=\"assets/images/attendent_shift.png\" height=\"90px\" width=\"75px\">\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("             \n");
      out.write("              <div class=\"col-sm-4 grid-margin\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                      <h4>Classwork report and details</h4><br><br>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                      <div class=\"col-8 col-sm-12 col-xl-8 my-auto\">\n");
      out.write("                        <div class=\"d-flex d-sm-block d-md-flex align-items-center\">\n");
      out.write("                          \n");
      out.write("                       \n");
      out.write("                          <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"dropdownMenuOutlineButton1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Show classwork </button>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuOutlineButton1\">\n");
      out.write("                           <h6 class=\"dropdown-header\">Course code</h6>\n");
      out.write("                            ");
 
                      PreparedStatement  pscr = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      pscr.setString(1, tecname);
                      pscr.setString(2, tecemail);
                      ResultSet rscr = pscr.executeQuery();
                      while(rscr.next()){
                    String code = rscr.getString("course_code");
      out.write("\n");
      out.write("                          <a class=\"dropdown-item\" href=\"all_classwork_codewise?code=");
      out.print(code);
      out.write("&email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.print(code);
      out.write("</a>\n");
      out.write("                          ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        </div><br><br>\n");
      out.write("                          \n");
      out.write("                         <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-outline-primary dropdown-toggle\" type=\"button\" id=\"dropdownMenuOutlineButton1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> Classwork marks </button>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuOutlineButton1\">\n");
      out.write("                           <h6 class=\"dropdown-header\">Course code</h6>\n");
      out.write("                            ");
 
                      PreparedStatement  pscs = DBConnection.getConnection().prepareStatement("Select * from add_course where teacher_name=? and teacher_email=?");
                      pscs.setString(1, tecname);
                      pscs.setString(2, tecemail);
                      ResultSet rscs = pscs.executeQuery();
                      while(rscs.next()){
                    String code = rscs.getString("course_code");
      out.write("\n");
      out.write("                          <a class=\"dropdown-item\" href=\"classwork_mark_form.jsp?code=");
      out.print(code);
      out.write("&email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.print(code);
      out.write("</a>\n");
      out.write("                          ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-4 col-sm-12 col-xl-4 text-center text-xl-right\">\n");
      out.write("                        <i class=\"icon-lg mdi mdi-monitor text-success ml-auto\"></i>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("                <div class=\"col-sm-4 grid-margin\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                      <h6>Without Gmail verification , all the students will not get the latest updates of the class.If you already get the Gmail verification message,then there is no need for more Gmail verification.<code>Otherwise verify Gmail by cliclking below</code></h6>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                      <div class=\"col-8 col-sm-12 col-xl-8 my-auto\">\n");
      out.write("                        <div class=\"d-flex d-sm-block d-md-flex align-items-center\">\n");
      out.write("                         \n");
      out.write("                            <a href=\"email_verification.jsp?email=");
      out.print(tecemail);
      out.write("&name=");
      out.print(tecname);
      out.write("&filename=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filename}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Gmail Verification</a>\n");
      out.write("                              \n");
      out.write("                         \n");
      out.write("                        </div>\n");
      out.write("                            \n");
      out.write("                      </div>\n");
      out.write("                      <div class=\"col-4 col-sm-12 col-xl-4 text-center text-xl-right\">\n");
      out.write("                        \n");
      out.write("                        <i class=\"mdi mdi-gmail\" style=\"font-size: 50px;\"></i>  \n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          \n");
      out.write("           \n");
      out.write("            </div>\n");
      out.write("          \n");
      out.write("          <!-- content-wrapper ends -->\n");
      out.write("          <!-- partial:partials/_footer.html -->\n");
      out.write("          <footer class=\"footer\">\n");
      out.write("            <div class=\"d-sm-flex justify-content-center justify-content-sm-between\">\n");
      out.write("              <span class=\"text-muted text-center text-sm-left d-block d-sm-inline-block\">Copyright © 2019 <a href=\"https://www.bootstrapdash.com/\" target=\"_blank\">BootstrapDash</a>. All rights reserved.</span>\n");
      out.write("              <span class=\"text-muted float-none float-sm-right d-block mt-1 mt-sm-0 text-center\">Hand-crafted & made with <i class=\"mdi mdi-heart text-danger\"></i></span>\n");
      out.write("            </div>\n");
      out.write("          </footer>\n");
      out.write("          <!-- partial -->\n");
      out.write("        </div>\n");
      out.write("        <!-- main-panel ends -->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("      <!-- page-body-wrapper ends -->\n");
      out.write("    \n");
      out.write("    <!-- container-scroller -->\n");
      out.write("    <!-- plugins:js -->\n");
      out.write("    <script src=\"assets/vendors/js/vendor.bundle.base.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin js for this page -->\n");
      out.write("    <script src=\"assets/vendors/chart.js/Chart.min.js\"></script>\n");
      out.write("    <script src=\"assets/vendors/progressbar.js/progressbar.min.js\"></script>\n");
      out.write("    <script src=\"assets/vendors/jvectormap/jquery-jvectormap.min.js\"></script>\n");
      out.write("    <script src=\"assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js\"></script>\n");
      out.write("    <script src=\"assets/vendors/owl-carousel-2/owl.carousel.min.js\"></script>\n");
      out.write("    <!-- End plugin js for this page -->\n");
      out.write("    <!-- inject:js -->\n");
      out.write("    <script src=\"assets/js/off-canvas.js\"></script>\n");
      out.write("    <script src=\"assets/js/hoverable-collapse.js\"></script>\n");
      out.write("    <script src=\"assets/js/misc.js\"></script>\n");
      out.write("    <script src=\"assets/js/settings.js\"></script>\n");
      out.write("    <script src=\"assets/js/todolist.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Custom js for this page -->\n");
      out.write("    <script src=\"assets/js/dashboard.js\"></script>\n");
      out.write(" \n");
      out.write("    <!-- End custom js for this page -->\n");
      out.write("    \n");
      out.write("    ");

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
            
               if(ssp1==ssp){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('Successfully save and sent post');\n");
      out.write("            </script>\n");
      out.write("                  ");
 } 
                  
                  
                  
            
            else if (nos1==nos){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('No one Submit this work yet');\n");
      out.write("            </script>\n");
      out.write("                  ");
 } 
                  
                  
                  
             
           else  if(sac1==sac){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('Course successfully added');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }
                       
                  
                  
                 
            
           else  if(dc1==dc){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('Course successfully deleted');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }  
                  else  if(ae1==ae){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('Already exists');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }  
                  else  if(np1==np){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('No post uploaded Yet');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }  
                  else  if(nwc1==nwc){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('No classwork created Yet');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }
                  else  if(ncm1==ncm){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('No classwork mark set Yet');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }
                  else  if(asa1==asa){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('No Attendance taken  Yet');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }
                  else  if(ev1==ev){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('Email verified! Check your gmail inbox either get email yes verfied or try again...click.. Email verification');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }
                  else  if(ns1==ns){
            
      out.write("\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("            alert('No Student Found in this course ');\n");
      out.write("            </script>\n");
      out.write("                  ");
 }
      out.write("\n");
      out.write("          \n");
      out.write("  </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
