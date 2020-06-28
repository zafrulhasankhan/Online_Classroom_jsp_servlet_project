package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/classwork.css\">\n");
      out.write("        <script langauge=\"JavaScript\">\n");
      out.write("    function myFunction() {\n");
      out.write("  var x = document.getElementById(\"myDIV\");\n");
      out.write("  if (x.style.display === \"none\") {\n");
      out.write("    x.style.display = \"block\";\n");
      out.write("  } else {\n");
      out.write("    x.style.display = \"none\";\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("    </script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.8.0/ckeditor.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<form action=\"nyform.jsp\" method=\"post\">\n");
      out.write("    <div id=\"myDIV\" hidden=\"\">\n");
      out.write("This is my DIV element.\n");
      out.write("</div>\n");
      out.write("    <input type=\"button\" value=\"Reset\" onClick=\"myFunction()\">\n");
      out.write("    \n");
      out.write("    <input type=\"date\" class=\"post-title\" name=\"title\" value=\"\" placeholder=\"Title\">\n");
      out.write("    <input type=\"submit\"/>\n");
      out.write("</form>\n");
      out.write("    <a href=\"date?age='c'\">click here</a>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
