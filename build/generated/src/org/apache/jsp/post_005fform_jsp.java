package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class post_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.8.0/ckeditor.js\"></script>\n");
      out.write("<title>Home</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<center>\n");
      out.write("<h1>Create Post</h1>\n");
      out.write("<table>\n");
      out.write("    \n");
      out.write(" <form action=\"post_form_controller\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("     <tr><td><input type=\"text\"  hidden=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"code\"/></td></tr>\n");
      out.write("\n");
      out.write("<tr><td>Enter File</td><td><input type=\"file\" name=\"image\"/></td></tr>\n");
      out.write("<tr><td>Body</td><td><textarea class=\"text_box\" name=\"body\" id=\"body\" cols=\"30\" rows=\"10\"></textarea><br>\n");
      out.write("</td></tr>\n");
      out.write("<tr><td colspan=\"2\"><input type=\"submit\" value=\"upload\"/></td></tr>\n");
      out.write("</form>\n");
      out.write("   \n");
      out.write("</table>\n");
      out.write("</center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<script>\n");
      out.write("\tCKEDITOR.replace('body');\n");
      out.write("        \n");
      out.write("        \n");
      out.write("</script>");
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
