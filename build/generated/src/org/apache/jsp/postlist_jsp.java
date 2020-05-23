package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.post;
import java.util.ArrayList;

public final class postlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link href=\"css/postlist.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String name = session.getAttribute("name").toString();
               session.setAttribute("name", name);
               
      out.write("\n");
      out.write("           \n");
      out.write("            \n");
      out.write("                \n");
      out.write("            \n");
      out.write("  <div class=\"navbar\">\n");
      out.write("  <a href=\"#home\">Home</a>\n");
      out.write("  <a href=\"#news\">News</a>\n");
      out.write("  <div class=\"dropdown\">\n");
      out.write("    <button class=\"dro\n");
      out.write("      <i class=\"fa fa-caret-down\">Dropdown</i>\n");
      out.write("    </button>\n");
      out.write("    <div class=\"dropdown-content\">\n");
      out.write("      <a href=\"#\">Link 1</a>\n");
      out.write("      <a href=\"#\">Link 2</a>\n");
      out.write("      <a href=\"#\">Link 3</a>\n");
      out.write("    </div>\n");
      out.write("  </div> \n");
      out.write("   </div>\n");
      out.write("\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            \n");
      out.write("       \n");
      out.write("             \n");
      out.write("        \n");
      out.write("        <div class=\"table-responsive\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <thead class=\"theading\">\n");
      out.write("                                    <tr >\n");
      out.write("                                        <th class=\"hname\" style=\"border: 3px solid red;\"><h5>course code</h5></th>\n");
      out.write("                                        <th class=\"hdept\" style=\"border: 3px solid red; \"><h5>file Name</h5></th>\n");
      out.write("                                        <th class=\"hemail\" style=\"border: 3px solid red;\"><h5>body</h5></th>\n");
      out.write("                                       <th class=\"hemail\" style=\"border: 3px solid red;\"><h5>course_name</h5></th>\n");
      out.write("                                        \n");
      out.write("                                        \n");
      out.write("                                    </tr>\n");
      out.write("                                </thead><br>\n");
      out.write("                                <tbody>\n");
      out.write("        ");

                ArrayList<post> postlist =(ArrayList) request.getAttribute("postlist");
                
                int i = 0;
                for(post po : postlist){
                    i++;
                
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td class=\"bname\">");
      out.print( po.getCode());
      out.write("</td>\n");
      out.write("            <td class=\"bdept\"><a href=\"getImage.jsp?name=");
      out.print(po.getName());
      out.write("\"> ");
      out.print(po.getName());
      out.write("</a></td>\n");
      out.write("           \n");
      out.write("            <td class=\"bemail\">");
      out.print( po.getBody());
      out.write("</td>\n");
      out.write("      \n");
      out.write("        \n");
      out.write("      </tr>  \n");
      out.write("      ");

      }
      
      out.write("\n");
      out.write("      \n");
      out.write("    </tbody>\n");
      out.write("                            \n");
      out.write("    </table>\n");
      out.write("      \n");
      out.write("     \n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("      <div class=\"home\">\n");
      out.write("          <a href=\"index.jsp\" style=\"color: white; align-content: right; \"><h5>Home</h5></a>\n");
      out.write("      </div>\n");
      out.write("     \n");
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
