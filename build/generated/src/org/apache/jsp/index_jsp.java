package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br><br><br><<h1 class=\"welcome-title\">Welcome To Nasim's Classroom</h1><br><br><br><br><br><br><br>\n");
      out.write("       \n");
      out.write("        <h2 style=\"text-align: center;color: #ffffff\"><u>Student Register</u></h2><br>\n");
      out.write("        <div class=\"container\" style=\"width: 400px;\n");
      out.write("    height: 465px;  margin: -35px auto;\">\n");
      out.write("            \n");
      out.write("            <form action=\"student_list_controller\" method=\"Post\" style=\"position: relative;\n");
      out.write("    top: 5%;\n");
      out.write("    transform: translateY(5%);\">\n");
      out.write("                           <div class=\"username\">\n");
      out.write("                               \n");
      out.write("                               <input type=\"text\" name=\"name\" placeholder=\"Your name\" required=\"\" class=\"name\"/>\n");
      out.write("                           </div><br>\n");
      out.write("                             <div class=\"username\">\n");
      out.write("                               \n");
      out.write("                               <input type=\"email\" name=\"email\" placeholder=\"Your email id\" required=\"\" class=\"name\"/>\n");
      out.write("                           </div><br>\n");
      out.write("                           <div class=\"username\">\n");
      out.write("                               \n");
      out.write("                               <input type=\"text\" name=\"id\" placeholder=\"Your class id\" required=\"\" class=\"name\"/>\n");
      out.write("                           </div><br>\n");
      out.write("                            \n");
      out.write("                            <div class=\"pass\">\n");
      out.write("\t\t\t\t<div class=\"username\">\n");
      out.write("                               \n");
      out.write("                               <input type=\"text\" name=\"code\" placeholder=\"course code\" required=\"\" class=\"name\"/>\n");
      out.write("                                </div><br>\t\t\t\t\n");
      out.write("\t\t\t     <div class=\"pass\">\n");
      out.write("                            <input type=\"password\" name=\"pass\" placeholder=\"PassWord\" required=\"\" class=\"password\" />\n");
      out.write("                             </div><br>\n");
      out.write("                            <div class=\"pass\">\n");
      out.write("                            <input type=\"password\" name=\"repass\" placeholder=\"Confirm PassWord\" required=\"\" class=\"password\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("                             \n");
      out.write("                            <br><div class=\"st\">\n");
      out.write("                                <button class=\"button button2\" type=\"submit\" name=\"login\">Register</button>\n");
      out.write("                                <h4>Already have account??\n");
      out.write("                                    <div class=\"tooltip\">\n");
      out.write("                                        <a href=\"student_login.jsp\" style=\"color:black; font-size: 25;\">Login</a>\n");
      out.write("                                        <span class=\"tooltiptext\"> Click for Login  </span>\n");
      out.write("                                    </div>\n");
      out.write("                                </h4>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                        </form>\n");
      out.write("        </div>\n");
      out.write("                            <div class=\"teacher_container\">\n");
      out.write("                                <h3>&ensp;If you want to use this site as teacher,click below.</h3>\n");
      out.write("            <div class=\"tooltip1\">\n");
      out.write("            <h3 class=\"welcome-title\"><a href=\"teacher_register.jsp\">Register as teacher</a></h3>\n");
      out.write("                   <span class=\"tooltiptext1\"> Click for Go to teacher's Panel </span>\n");
      out.write("            </div>\n");
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
