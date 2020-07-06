package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.classwork;
import java.util.ArrayList;
import db.course;

public final class classwork_005fmark_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"css/course_list.css\">\n");
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
      out.write("        <div class=\"heading1\" align=\"center\">\n");
      out.write("          &ensp;<h4><u>Student's classwork Marks</u></h4>\n");
      out.write("          <h4 style=\"color:red; text-align: center;\">Classwork no. : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cwno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h4><br>\n");
      out.write("            <h4 style=\"color:red; text-align: center;\">Course code. : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </h4><br>\n");
      out.write("      </div><br>\n");
      out.write("        \n");
      out.write("             \n");
      out.write("         <form action=\"NewServlet\" method=\"get\">     \n");
      out.write("        <input type=\"text\" name=\"code\" value=\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" hidden=\"\" >\n");
      out.write("        <input type=\"text\" name=\"cw_no\" value=\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cwno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" hidden=\"\" >\n");
      out.write("        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead class=\"theading\">\n");
      out.write("                                    <tr >\n");
      out.write("                                        <th class=\"hemail\" style=\"border: 3px solid red; \"><h5>Student ID.</h5></th>\n");
      out.write("                                        <th class=\"hdept\" style=\"border: 3px solid red; \"><h5>Email</h5></th>\n");
      out.write("                                        <th class=\"hemail\" style=\"border: 3px solid red;\"><h5>Marks</h5></th>\n");
      out.write("                                        \n");
      out.write("                                      \n");
      out.write("                                        \n");
      out.write("                                    </tr>\n");
      out.write("                                </thead><br>\n");
      out.write("                                <tbody>\n");
      out.write("        ");

                ArrayList<classwork> worklist =(ArrayList) request.getAttribute("worklist");
                
                int i = 0;
                for(classwork u : worklist){
                    i++;
                
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("           <td class=\"bemail\">");
      out.print( u.getStudent_id());
      out.write("</td>\n");
      out.write("            <td class=\"bdept\">");
      out.print( u.getStudent_email());
      out.write("</td>\n");
      out.write("        <td class=\"bemail\">");
      out.print( u.getMark() );
      out.write("</td>\n");
      out.write("                          \n");
      out.write("      </tr>\n");
      out.write("            <input type=\"text\" name=\"stuid\" value=\"");
      out.print( u.getStudent_id());
      out.write("\" hidden=\"\" >\n");
      out.write("            <input type=\"text\" name=\"stuemail\" value=\"");
      out.print( u.getStudent_email());
      out.write("\"  > \n");
      out.write("            <input type=\"text\" name=\"stumark\" value=\"");
      out.print( u.getMark());
      out.write("\" hidden=\"\" >\n");
      out.write("      ");

      }
      
      out.write("\n");
      out.write("      \n");
      out.write("    </tbody>\n");
      out.write("                            \n");
      out.write("    </table>\n");
      out.write("       \n");
      out.write("        </div> \n");
      out.write("      <div class=\"save\">\n");
      out.write("          <input type=\"submit\" value=\"click for email to sent Attendance report\" class=\"saveatr\" />\n");
      out.write("      </div>\n");
      out.write("         </form>\n");
      out.write("    </body>\n");
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
