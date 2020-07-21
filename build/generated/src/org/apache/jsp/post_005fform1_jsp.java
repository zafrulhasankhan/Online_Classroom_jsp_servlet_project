package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import db.DBConnection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public final class post_005fform1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Online classroom</title>\n");
      out.write("    <!-- plugins:css -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/mdi/css/materialdesignicons.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/vendors/css/vendor.bundle.base.css\">\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin css for this page -->\n");
      out.write("    <!-- End plugin css for this page -->\n");
      out.write("    <!-- inject:css -->\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Layout styles -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("    <!-- End layout styles -->\n");
      out.write("    <link rel=\"shortcut icon\" href=\"assets/images/favicon.png\" />\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      ");

        String code = request.getParameter("code");
        
      out.write("\n");
      out.write("    <div class=\"container-scroller\">\n");
      out.write("      <div class=\"container-fluid page-body-wrapper full-page-wrapper\">\n");
      out.write("        <div class=\"row w-100 m-0\">\n");
      out.write("          <div class=\"content-wrapper full-page-wrapper d-flex align-items-center auth login-bg\">\n");
      out.write("            <div class=\"card col-lg-4 mx-auto\">\n");
      out.write("              <div class=\"card-body px-5 py-5\">\n");
      out.write("                  <h3 style=\"text-align: center;font-size: 20px;\"><u>Post - From</u></h3><br>\n");
      out.write("                <form action=\"post_form_controller\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                  <input type=\"text\"  hidden=\"\" value=\"");
      out.print(code);
      out.write("\" name=\"code\">\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                        <label>File upload</label>\n");
      out.write("                        <input type=\"file\" name=\"image\" class=\"file-upload-default\">\n");
      out.write("                        <div class=\"input-group col-xs-12\">\n");
      out.write("                          <input type=\"text\" class=\"form-control file-upload-info\" disabled placeholder=\"Upload Image\">\n");
      out.write("                          <span class=\"input-group-append\">\n");
      out.write("                            <button class=\"file-upload-browse btn btn-primary\" type=\"button\">Upload</button>\n");
      out.write("                          </span>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                     <div class=\"form-group\">\n");
      out.write("                        <label for=\"exampleTextarea1\">Textarea</label>\n");
      out.write("                        <textarea class=\"form-control\" name=\"body\" id=\"exampleTextarea1\" rows=\"4\"></textarea>\n");
      out.write("                      </div>\n");
      out.write("                    <div class=\"text-center\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary btn-block enter-btn\">Upload</button>\n");
      out.write("                  </div>\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <!-- content-wrapper ends -->\n");
      out.write("        </div>\n");
      out.write("        <!-- row ends -->\n");
      out.write("      </div>\n");
      out.write("      <!-- page-body-wrapper ends -->\n");
      out.write("    </div>\n");
      out.write("    <!-- container-scroller -->\n");
      out.write("    <!-- plugins:js -->\n");
      out.write("    <script src=\"assets/vendors/js/vendor.bundle.base.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
      out.write("    <!-- Plugin js for this page -->\n");
      out.write("    <!-- End plugin js for this page -->\n");
      out.write("    <!-- inject:js -->\n");
      out.write("    <script src=\"assets/js/off-canvas.js\"></script>\n");
      out.write("    <script src=\"assets/js/hoverable-collapse.js\"></script>\n");
      out.write("    <script src=\"assets/js/misc.js\"></script>\n");
      out.write("    <script src=\"assets/js/settings.js\"></script>\n");
      out.write("    <script src=\"assets/js/todolist.js\"></script>\n");
      out.write("    <!-- endinject -->\n");
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
