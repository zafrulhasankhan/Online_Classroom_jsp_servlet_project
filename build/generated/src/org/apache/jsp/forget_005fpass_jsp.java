package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import db.DBConnection;
import java.sql.PreparedStatement;

public final class forget_005fpass_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\">\n");
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br><br><br><<h1 class=\"welcome-title\">Forget password</h1>\n");
      out.write("        \n");
      out.write("        <div class=\"container\" style=\"height: 270px;\">\n");
      out.write("        <form action=\"student_forget_pass_controller\" method=\"post\">\n");
      out.write("                           \n");
      out.write("                        \n");
      out.write("                           <label class=\"\" style=\"color: black\">Course code:</label>\n");
      out.write("\t\t\t\t<div class=\"username\">\n");
      out.write("                                    \n");
      out.write("                               <select id=\"cars\" name=\"code\" class=\"code1\">   \n");
      out.write("                                ");

                              PreparedStatement  ps = DBConnection.getConnection().prepareStatement("Select * from add_course");
                               ResultSet rs = ps.executeQuery();
                                 while(rs.next()){
                                String code = rs.getString("course_code");
      out.write("\n");
      out.write("                                <option  value=\"");
      out.print(code);
      out.write('"');
      out.write('>');
      out.print(code);
      out.write("</option>\n");
      out.write("                                 ");
 }
      out.write("\n");
      out.write("                               </select>                          \n");
      out.write("                               </div><br>\n");
      out.write("                           \n");
      out.write("                           <div class=\"username\">\n");
      out.write("                               \n");
      out.write("                               <input type=\"email\" name=\"email\" placeholder=\"Your email id\" required=\"\" class=\"name\"/>\n");
      out.write("                           </div><br>\n");
      out.write("                           \n");
      out.write("                           <div class=\"tooltip1\">\n");
      out.write("                           <input type=\"button\" value=\"Reset password\" onClick=\"myFunction()\"><br>\n");
      out.write("                           <span class=\"tooltiptext1\"> Double Click for reset password  </span>\n");
      out.write("                           </div> \n");
      out.write("                           <div id=\"myDIV\" hidden=\"\" class=\"container\" style=\"height: 170px;\">\n");
      out.write("                           <div class=\"pass\"><br>\n");
      out.write("\t\t\t\t <input type=\"password\" name=\"pass\" placeholder=\"set password\"  class=\"password\" />\n");
      out.write("\t\t\t   </div>\n");
      out.write("                                <div class=\"pass\"><br>\n");
      out.write("\t\t\t\t <input type=\"password\" name=\"repass\" placeholder=\"confirm set password\"  class=\"password\" />\n");
      out.write("\t\t\t   </div>\n");
      out.write("                          </div>\n");
      out.write("                           \n");
      out.write("                           <div class=\"tooltip1\">\n");
      out.write("                           <input type=\"button\" value=\"Reset password\" onClick=\"myFunction()\"><br>\n");
      out.write("                           <span class=\"tooltiptext1\"> Double Click for reset password  </span>\n");
      out.write("                           </div> \n");
      out.write("                           <div id=\"myDIV\" hidden=\"\" class=\"container\" style=\"height: 170px;\">\n");
      out.write("                           <div class=\"pass\"><br>\n");
      out.write("\t\t\t\t <input type=\"password\" name=\"pass\" placeholder=\"set password\"  class=\"password\" />\n");
      out.write("\t\t\t   </div>\n");
      out.write("                                <div class=\"pass\"><br>\n");
      out.write("\t\t\t\t <input type=\"password\" name=\"repass\" placeholder=\"confirm set password\"  class=\"password\" />\n");
      out.write("\t\t\t   </div>\n");
      out.write("                          </div>\n");
      out.write("                           \n");
      out.write("                           <div class=\"tooltip1\">\n");
      out.write("                               <br><div class=\"st\">\n");
      out.write("                                   <button class=\"button button2\"  type=\"submit\" name=\"login\">Sent</button>\n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                             <span class=\"tooltiptext1\"> Click for find password by email </span>\n");
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
