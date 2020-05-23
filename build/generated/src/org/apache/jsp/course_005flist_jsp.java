package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import db.course;

public final class course_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"css/courselist.css\">\n");
      out.write("     <style>\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            body\n");
      out.write("            {\n");
      out.write("                background-image:url(\"image/webback3_1.jpeg\")\n");
      out.write("                    \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"heading\" align=\"center\">\n");
      out.write("            <h2>All course's</h2>\n");
      out.write("        </div>\n");
      out.write("             \n");
      out.write("             \n");
      out.write("        \n");
      out.write("        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead class=\"theading\">\n");
      out.write("                                    <tr >\n");
      out.write("                                        <th class=\"hname\" style=\"border: 3px solid red;\"><h5>Serial No.</h5></th>\n");
      out.write("                                        <th class=\"hdept\" style=\"border: 3px solid red; \"><h5>Course Name</h5></th>\n");
      out.write("                                        <th class=\"hemail\" style=\"border: 3px solid red;\"><h5>Course code</h5></th>\n");
      out.write("                                        <th class=\"hview\" style=\"border: 3px solid red;\"><h5>view course</h5></th>\n");
      out.write("                                        <th class=\"hdelete\" style=\"border: 3px solid red;\"><h5>Delete course</h5></th>\n");
      out.write("                                        \n");
      out.write("                                    </tr>\n");
      out.write("                                </thead><br>\n");
      out.write("                                <tbody>\n");
      out.write("        ");

                ArrayList<course> course_list =(ArrayList) request.getAttribute("course_list");
                
                int i = 0;
                for(course u : course_list){
                    i++;
                
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td class=\"bname\">");
      out.print( u.getId());
      out.write("</td>\n");
      out.write("            <td class=\"bdept\">");
      out.print( u.getName());
      out.write("</td>\n");
      out.write("        <td class=\"bemail\">");
      out.print( u.getCode());
      out.write("</td>\n");
      out.write("        <td class=\"bview\">");
out.print("<a href='select_file_controller?code="+u.getCode()+"'</a>");
      out.print(u.getCode());
      out.write("</td>\n");
      out.write("        <td class=\"bdelete\">");
out.print("<a href='UpdateServlet?id="+u.getId()+"'</a>");
      out.write(" Delete Course</td>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("      </tr>  \n");
      out.write("      ");

      }
      
      out.write("\n");
      out.write("      \n");
      out.write("    </tbody>\n");
      out.write("                            \n");
      out.write("    </table>\n");
      out.write("        </div>\n");
      out.write("      <div class=\"home\">\n");
      out.write("          <a href=\"index.jsp\" style=\"color: white; align-content: right; \"><h5>Home</h5></a>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
