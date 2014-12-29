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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("        <title>FCI Research Login</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />\n");
      out.write("        <script>\n");
      out.write("            function validateLogin()\n");
      out.write("            {\n");
      out.write("              var name = document.forms[\"f1\"][\"email\"].value;\n");
      out.write("              var email = document.forms[\"f1\"][\"password\"].value;\n");
      out.write("              if(email == \"\" || password == \"\")\n");
      out.write("              {\n");
      out.write("                    alert(\"Fill missing info\");\n");
      out.write("                    //<meta http-equiv=\"refresh\" content=\"0; url=index.jsp\" />\n");
      out.write("                    return false;\n");
      out.write("              }\n");
      out.write("              return true;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  <form name =\"f1\" method=\"post\" onsubmit = \"return validateLogin()\" action=\"LoginAuthentication\" class=\"login\">\n");
      out.write("    <p>\n");
      out.write("      <label for=\"login\">Email:</label>\n");
      out.write("      \n");
      out.write("      <input type=\"text\" name=\"email\" id=\"login\" value=\"name@example.com\">\n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("    <p>\n");
      out.write("      <label for=\"password\">Password:</label>\n");
      out.write("      <input type=\"password\" name=\"password\" id=\"password\" value=\"4815162342\">\n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("    <p class=\"login-submit\">\n");
      out.write("      <button type=\"submit\" class=\"login-button\">Login</button>\n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("    <p class=\"forgot-password\"><a href=\"SignUp.jsp\">Sign up</a></p>\n");
      out.write("  </form>\n");
      out.write("\n");
      out.write("<section class=\"about\">\n");
      out.write("    \n");
      out.write("    <p class=\"about-author\">\n");
      out.write("      © 2014–2015 <a href=\"https://www.facebook.com/Sho3laaa\" target=\"_blank\">Khaled</a>\n");
      out.write("<a href=\"https://www.facebook.com/Ahmed.justyou\" target=\"_blank\">Ahmed Kamal</a>\n");
      out.write("<a href=\"https://www.facebook.com/Programmer.A7mD.MakRaM.22.s3oOoDy.74\" target=\"_blank\">ِAhmed Makram</a>\n");
      out.write("  </p></section>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
