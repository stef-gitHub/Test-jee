/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-09-05 19:11:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"fr\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Connexion</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style =\" background-color: #c47e7e2b;\" >\r\n");
      out.write("<nav style=\"background-color: #9E2772\" class=\"navbar navbar-expand-md navbar-dark \">\r\n");
      out.write("    <div class=\"navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2\"></div>\r\n");
      out.write("    <div class=\"mx-auto order-0\">\r\n");
      out.write("        <a class=\"navbar-brand mx-auto\">Bienvenue sur votre application de gestion d'école</a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\".dual-collapse2\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"navbar-collapse collapse w-100 order-3 dual-collapse2\"></div>\r\n");
      out.write("</nav>\r\n");
      out.write("<div class=\"container\" >\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\r\n");
      out.write("            <div class=\"card card-signin my-5\">\r\n");
      out.write("                <div class=\"card-body\">\r\n");
      out.write("                    <h5 class=\"card-title text-center\">Se connecter</h5>\r\n");
      out.write("                    <form class=\"form-signin\" action=\"login\" method=\"post\">\r\n");
      out.write("                        <div class=\"form-label-group\">\r\n");
      out.write("                            <label for=\"inputEmail\">Identifiant</label>\r\n");
      out.write("                            <input type=\"text\" id=\"inputEmail\" class=\"form-control\" name=\"login\" placeholder=\"Identifiant\" required autofocus>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <div class=\"form-label-group\">\r\n");
      out.write("                            <label for=\"inputPassword\">Mot de passe</label>\r\n");
      out.write("                            <input type=\"password\" id=\"inputPassword\" class=\"form-control\" name=\"mdp\" placeholder=\"Mot de passe\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <hr>\r\n");
      out.write("                        <button class=\"btn btn-lg btn-success btn-block \" type=\"submit\">Connexion</button>\r\n");
      out.write("                        <br>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}