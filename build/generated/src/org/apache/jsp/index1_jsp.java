package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!-- End Plugin css for this page -->\n");
      out.write("    <!-- inject:css -->\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Layout styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("    <!-- End layout styles -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"assets/images/favicon.png\" />\n");
      out.write("  </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-scroller\">\n");
      out.write("        <div class=\"main-panel\">\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("               <div class=\"col-md-6\" style=\"float:none;margin:auto;>\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <h3 style=\"text-align: center;\">Welcome to online classroom</h3>\n");
      out.write("                    </div>\n");
      out.write("                </div><br><br>\n");
      out.write("               \n");
      out.write("              <div class=\"row\" >\n");
      out.write("                \n");
      out.write("                  \n");
      out.write("              \n");
      out.write("                  <div class=\"col-md-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                  <div class=\"card-body\">\n");
      out.write("                      <h4 class=\"card-title\" style=\"text-align: center\"><u>Teacher - panel</u></h4>\n");
      out.write("                    <p class=\"card-description\" style=\"text-align: center;font-size: 19\">If you would like to use this website as a<code>Teacher</code>,click below . </p>\n");
      out.write("                    <p align=\"center\">\n");
      out.write("                    <a type=\"button\" href=\"teacher_register.jsp\" class=\"btn btn-success btn-rounded btn-fw\">Go....</a>\n");
      out.write("                    </p>\n");
      out.write("                    </div>\n");
      out.write("                   </div>\n");
      out.write("                  </div>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("              <div class=\"col-md-6 grid-margin stretch-card\">\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <div class=\"card-body\">\n");
      out.write("                        <h4 style=\"text-align: center\"><u>Student - panel</u></h4> \n");
      out.write("                        <p class=\"card-description\" style=\"text-align: center;font-size: 19\">If you would like to use this website as a<code>Student</code>,click below . </p>\n");
      out.write("                        <p align=\"center\">\n");
      out.write("                        <a type=\"button\" href=\"student_register.jsp\" class=\"btn btn-success btn-rounded btn-fw\" >Go....</a>\n");
      out.write("                        </p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("               \n");
      out.write("              </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("                  </div>\n");
      out.write("                \n");
      out.write("              \n");
      out.write("              \n");
      out.write("              \n");
      out.write("            \n");
      out.write("        \n");
      out.write("        <script src=\"assets/vendors/js/vendor.bundle.base.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin js for this page -->\n");
      out.write("    <!-- End plugin js for this page -->\n");
      out.write("    <!-- inject:js -->\n");
      out.write("    <script src=\"assets/js/off-canvas.js\"></script>\n");
      out.write("    <script src=\"assets/js/hoverable-collapse.js\"></script>\n");
      out.write("    <script src=\"assets/js/misc.js\"></script>\n");
      out.write("    <script src=\"assets/js/settings.js\"></script>\n");
      out.write("    <script src=\"assets/js/todolist.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
