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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Toggle Password Visibility</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css\">\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        .container i {\n");
      out.write("    margin-left: -30px;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Toggle Password Visibility</h1>\n");
      out.write("        <input type=\"password\" name=\"pass\" id=\"password\" placeholder=\"Enter the password\">\n");
      out.write("        <i class=\"far fa-eye\" id=\"togglePassword\"></i>\n");
      out.write("    </div>\n");
      out.write("    ");

        String name = "djfndj";
        session.setAttribute("name", name);
        
      out.write("\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h1>\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("        const togglePassword = document.querySelector('#togglePassword');\n");
      out.write("const password = document.querySelector('#password');\n");
      out.write("        togglePassword.addEventListener('click', function (e) {\n");
      out.write("    // toggle the type attribute\n");
      out.write("    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';\n");
      out.write("    password.setAttribute('type', type);\n");
      out.write("    // toggle the eye slash icon\n");
      out.write("    this.classList.toggle('fa-eye-slash');\n");
      out.write("});\n");
      out.write("    </script>\n");
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
