package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_005fmain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    \n");
      out.write("    <head>\n");
      out.write("        <link href=\"css/admin_main_css.css\" rel=\"stylesheet\"> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"header\">\n");
      out.write("\t\t<div class=\"logo\">\n");
      out.write("\t\t\t<h1 class=\"welcome\" > Online Classromm </h1>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</a>\n");
      out.write("\t\t</div>\n");
      out.write("        </div>\n");
      out.write("\t\n");
      out.write("        \n");
      out.write("<div class=\"container dashboard\">\n");
      out.write("\t\t<h1>Welcome To Admin Panel</h1>\n");
      out.write("\t\t<div class=\"stats\">\n");
      out.write("\t\t\t<a href=\"users.php\" class=\"first\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<span>See All course's</span>\n");
      out.write("\t\t\t</a>\n");
      out.write("                    <a href=\"add_course.jsp\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<span>Add new course</span>\n");
      out.write("\t\t\t</a>\n");
      out.write("\t\t\t<a href=\"posts.php\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<span>Block the user's</span>\n");
      out.write("\t\t\t</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br><br><br>\n");
      out.write("\t\t<div class=\"buttons\">\n");
      out.write("\t\t\t<a href=\"users.php\">Add Users</a>\n");
      out.write("                        <a href=\"create_post_form.php\">Add Posts</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
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
