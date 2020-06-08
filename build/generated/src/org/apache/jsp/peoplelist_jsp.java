package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.people;
import java.util.ArrayList;

public final class peoplelist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/courselist.css\">\n");
      out.write("        <link href=\"css/postlist.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("        \n");
      out.write("       <div class=\"navbar\">\n");
      out.write("  <a href=\"#home\">Home</a>\n");
      out.write("  <a href=\"#news\">News</a>\n");
      out.write("  <div class=\"navbar-centered\">\n");
      out.write("      <a  class=\"active\"></a>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"dropdown\">\n");
      out.write("    <button class=\"dropbtn\">Dropdown \n");
      out.write("      <i class=\"fa fa-caret-down\"></i>\n");
      out.write("    </button>\n");
      out.write("    <div class=\"dropdown-content\">\n");
      out.write("        \n");
      out.write("       \n");
      out.write("      \n");
      out.write("      <a href=\"peoplelist_controller?code=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${code}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \">People</a>\n");
      out.write("      <a href=\"#\">Link 2</a>\n");
      out.write("      <a href=\"#\">Link 3</a>\n");
      out.write("    </div>\n");
      out.write("  </div> \n");
      out.write("</div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("       \n");
      out.write("      <div class=\"heading\" align=\"center\">\n");
      out.write("            <h4>People's details</h4>\n");
      out.write("            \n");
      out.write("      </div><br>\n");
      out.write("      <h4 style=\"color: red\">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Course Teacher Name: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tecname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4><br>\n");
      out.write("      <h4 style=\"color:red\">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Student List : </h4><br>\n");
      out.write("    <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead class=\"theading\">\n");
      out.write("      <tr>\n");
      out.write("        <th class=\"hname\" style=\"border: 3px solid red;\">Class ID</th>\n");
      out.write("      <th class=\"hdept\" style=\"border: 3px solid red; \"> Student Name</th>\n");
      out.write("        <th class=\"hemail\" style=\"border: 3px solid red;\">Email</th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        ");

                ArrayList<people> peoplelist =(ArrayList) request.getAttribute("peoplelist");
                
                int i = 0;
                for(people po : peoplelist){
                    i++;
                
        
      out.write("\n");
      out.write("      <tr>\n");
      out.write("        <td class=\"bname\">");
      out.print( po.getClass_id());
      out.write("</td>\n");
      out.write("        <td class=\"bdept\">");
      out.print( po.getStudentlist());
      out.write("</td>\n");
      out.write("        <td class=\"bemail\">");
      out.print( po.getEmail());
      out.write("</td>\n");
      out.write("      </tr>  \n");
      out.write("      ");

      }
      
      out.write("\n");
      out.write("      \n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write("       </div>\n");
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
