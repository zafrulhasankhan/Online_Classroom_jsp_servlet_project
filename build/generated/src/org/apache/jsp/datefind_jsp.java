package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;

public final class datefind_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <title>Corona Admin</title>\n");
      out.write("    <!-- plugins:css -->\n");
      out.write("    <style>\n");
      out.write("   \n");
      out.write("\n");
      out.write(".hero-text-area-container {\n");
      out.write("\n");
      out.write("float: left;\n");
      out.write("margin: 0% 30%;\n");
      out.write("max-height: 2em;\n");
      out.write("padding-top: 11em;\n");
      out.write("position: relative;\n");
      out.write("vertical-align: middle;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write(" .hero-text-area-container h3 {\n");
      out.write("\n");
      out.write("opacity: .8;\n");
      out.write("padding: 1em;\n");
      out.write("text-align: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("       \n");
      out.write("   \n");
      out.write("    <div class=\"hero-text-area-container\">\n");
      out.write("      \n");
      out.write("        <h3>dufufuhuu</h3>\n");
      out.write("    </div>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("  </body>\n");
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
