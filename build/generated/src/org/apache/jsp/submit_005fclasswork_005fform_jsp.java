package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class submit_005fclasswork_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

String cw_no = request.getParameter("cw_no");
String code = request.getParameter("code");
String sname = request.getParameter("sname");
String sid = request.getParameter("sid");
 
      out.write("\n");
      out.write(" <form action=\"classwork_submit_controller\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("              \n");
      out.write("             <input type=\"text\" class=\"image\" name=\"cw_no\" value=\"");
      out.print(cw_no);
      out.write("\"    placeholder=\"enter cw no\"/>\n");
      out.write("             <input type=\"text\" class=\"image\" name=\"code\" value=\"");
      out.print(code);
      out.write("\"    placeholder=\"enter course code\"/><br>\n");
      out.write("             <input type=\"text\" class=\"image\" name=\"sname\" value=\"");
      out.print(sname);
      out.write("\"     placeholder=\"enter student name\"/>\n");
      out.write("             <input type=\"text\" class=\"image\" name=\"sid\" value=\"");
      out.print(sid);
      out.write("\"      placeholder=\"enter student id\"/>\n");
      out.write("             <div id=\"myDIV\">\n");
      out.write("              <input type=\"file\" class=\"image\" name=\"file\"   placeholder=\"enter file\"/><br>\n");
      out.write("               </div><br>\n");
      out.write("             <div >\n");
      out.write("             <input type=\"submit\" class=\"btnn\" value=\"upload\"/><br>\n");
      out.write("             </div>\n");
      out.write("          </form>\n");
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
