package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class delete_005falert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Corona Admin</title>\n");
      out.write("    <!-- plugins:css -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../assets/vendors/mdi/css/materialdesignicons.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../assets/vendors/css/vendor.bundle.base.css\">\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin css for this page -->\n");
      out.write("    <!-- End Plugin css for this page -->\n");
      out.write("    <!-- inject:css -->\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Layout styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../assets/css/style.css\">\n");
      out.write("    <!-- End layout styles -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../assets/images/favicon.png\" />\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            background: black;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div class=\"container-scroller\">\n");
      out.write("      <div class=\"container-fluid page-body-wrapper full-page-wrapper\">\n");
      out.write("        <div class=\"content-wrapper d-flex align-items-center text-center error-page bg-info\">\n");
      out.write("          <div class=\"row flex-grow\">\n");
      out.write("            <div class=\"col-lg-7 mx-auto text-white\">\n");
      out.write("              <div class=\"row align-items-center d-flex flex-row\">\n");
      out.write("                <div class=\"col-lg-6 text-lg-right pr-lg-4\">\n");
      out.write("                  <h1 class=\"display-1 mb-0\">500</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-6 error-page-divider text-lg-left pl-lg-4\">\n");
      out.write("                  <h2>SORRY!</h2>\n");
      out.write("                  <h3 class=\"font-weight-light\">Internal server error!</h3>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"row mt-5\">\n");
      out.write("                <div class=\"col-12 text-center mt-xl-2\">\n");
      out.write("                  <a class=\"text-white font-weight-medium\" href=\"../../index.html\">Back to home</a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"row mt-5\">\n");
      out.write("                <div class=\"col-12 mt-xl-2\">\n");
      out.write("                  \n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- content-wrapper ends -->\n");
      out.write("      </div>\n");
      out.write("      <!-- page-body-wrapper ends -->\n");
      out.write("    </div>\n");
      out.write("    <!-- container-scroller -->\n");
      out.write("    <!-- plugins:js -->\n");
      out.write("    <script src=\"../../assets/vendors/js/vendor.bundle.base.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin js for this page -->\n");
      out.write("    <!-- End plugin js for this page -->\n");
      out.write("    <!-- inject:js -->\n");
      out.write("    <script src=\"../../assets/js/off-canvas.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/hoverable-collapse.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/misc.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/settings.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/todolist.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("  </body>\n");
      out.write("</html>");
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
