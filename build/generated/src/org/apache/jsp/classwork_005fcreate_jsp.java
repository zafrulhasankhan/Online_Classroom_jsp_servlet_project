package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class classwork_005fcreate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/classwork.css\">\n");
      out.write("        \n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.8.0/ckeditor.js\"></script>\n");
      out.write("        <title>\n");
      out.write("            \n");
      out.write("        </title>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"topnav\">\n");
      out.write("\n");
      out.write("  <!-- Centered link -->\n");
      out.write("  <div class=\"topnav-centered\">\n");
      out.write("    <a href=\"#home\" class=\"active\">Home</a>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("  <!-- Left-aligned links (default) -->\n");
      out.write("  <a href=\"#news\">News</a>\n");
      out.write("  <a href=\"#contact\">Contact</a>\n");
      out.write("  \n");
      out.write("  <!-- Right-aligned links -->\n");
      out.write("  <div class=\"topnav-right\">\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("        </div><br>\n");
      out.write("        \n");
      out.write("        <div class=\"cre_po_title\">\n");
      out.write("            <h3 style=\"color: black;\"> <u>Create Classwork</u> </h3>            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");

         String code = request.getParameter("code");
         
      out.write("\n");
      out.write("        \n");
      out.write("\t\t\t<form action=\"classwork_create_controller\" method=\"post\"/>\n");
      out.write("                           <div class=\"username\" >\n");
      out.write("                               \n");
      out.write("                                <input type=\"text\" name=\"code\" value=\"");
      out.print(code);
      out.write("\" placeholder=\"Your email id\" hidden=\"\" class=\"name\"/>\n");
      out.write("                           </div><br>\n");
      out.write("\t\t\t\t\n");
      out.write("               <label>Classwork details :</label><br>\n");
      out.write("               <textarea class=\"text_box\" name=\"body\" id=\"body\" cols=\"30\" rows=\"10\"></textarea><br><br>\n");
      out.write("               \n");
      out.write("                                <label>Deadline of classwork :</label><br>\n");
      out.write("\t\t\t\t<input type=\"date\" class=\"post-title\" name=\"title\" value=\"\" placeholder=\"Title\"><br>\n");
      out.write("                                \n");
      out.write("                                <button onclick=\"myFunction()\">Try it</button>\n");
      out.write("\n");
      out.write("<div id=\"myDIV\">\n");
      out.write("This is my DIV element.\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("function myFunction() {\n");
      out.write("  var x = document.getElementById(\"myDIV\");\n");
      out.write("  if (x.style.display === \"none\") {\n");
      out.write("    x.style.display = \"block\";\n");
      out.write("  } else {\n");
      out.write("    x.style.display = \"none\";\n");
      out.write("  }\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                            \n");
      out.write("                                \n");
      out.write("\n");
      out.write("\n");
      out.write("                           <input type=\"submit\" value=\"Upload\" class=\"btnn\" name=\"btn-upload\">\n");
      out.write("                                 \n");
      out.write("                                \n");
      out.write("\n");
      out.write("\t\t\t</form>\n");
      out.write("            \n");
      out.write("\t\t<!-- // Middle form - to create and edit -->\n");
      out.write("\t\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    \n");
      out.write("</html>\n");
      out.write("<script>\n");
      out.write("\tCKEDITOR.replace('body');\n");
      out.write("        \n");
      out.write("        \n");
      out.write("</script>\n");
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
