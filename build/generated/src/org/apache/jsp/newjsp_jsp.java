package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            .tooltip {\n");
      out.write("  position: relative;\n");
      out.write("  display: inline-block;\n");
      out.write("    \n");
      out.write("    position: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write(".tooltip .tooltiptext {\n");
      out.write("  visibility: hidden;\n");
      out.write("  width: 120px;\n");
      out.write("  background-color: black;\n");
      out.write("  color: #fff;\n");
      out.write("  text-align: center;\n");
      out.write("  border-radius: 6px;\n");
      out.write("  padding: 5px 0;\n");
      out.write("\n");
      out.write("  /* Position the tooltip */\n");
      out.write("  position: absolute;\n");
      out.write("  z-index: 1;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".tooltip:hover .tooltiptext {\n");
      out.write("  visibility: visible;\n");
      out.write("}\n");
      out.write("        </style> \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <div class=\"tooltip\">\n");
      out.write("                                 <a href=\"forget_pass.jsp\" style=\"color: black;\"><b>Forget password?</b></a>\n");
      out.write("                            <span class=\"tooltiptext\"> Click for find password </span>\n");
      out.write("                             </div>\n");
      out.write("   \n");
      out.write("    \n");
      out.write("    <a href=\" \" title=\"This is some text I want to display.\" style=\"background-color:#FFFFFF;color:#000000;text-decoration:none\">This link has mouseover text.</a>\n");
      out.write("    </body>\n");
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
