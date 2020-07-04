package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class email_005fverification_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("         <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String email = request.getParameter("tecemail");
            String code = request.getParameter("code");
            
      out.write("\n");
      out.write("        <br><br><br><h1 class=\"welcome-title\">Email verification for sent classes all update to all of students by email</h1><br>\n");
      out.write("        <div class=\"container\" style=\"width: 400px;\n");
      out.write("    height: 310px;  margin: 25px auto;\">\n");
      out.write("            <form action=\"email_verification_controller\" method=\"get\">\n");
      out.write("                           <div class=\"username\">\n");
      out.write("                               \n");
      out.write("                               <input type=\"email\" name=\"email\" hidden=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"email id\"  class=\"name\"/>\n");
      out.write("                           </div><br>\n");
      out.write("                            <div class=\"username\">\n");
      out.write("                               \n");
      out.write("                                <input type=\"text\" name=\"name\"  hidden=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"email id\"  class=\"name\"/>\n");
      out.write("                           </div>\n");
      out.write("                            \n");
      out.write("                            <div class=\"pass\"><br>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t    \n");
      out.write("                            <input type=\"password\" name=\"pass\" placeholder=\" Your email PassWord\" required=\"\" class=\"password\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("                            \n");
      out.write("                             \n");
      out.write("                            <br><div class=\"st\">\n");
      out.write("                                <button class=\"button button2\" type=\"submit\" name=\"login\">Login</button>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        </form>\n");
      out.write("        </div>\n");
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
