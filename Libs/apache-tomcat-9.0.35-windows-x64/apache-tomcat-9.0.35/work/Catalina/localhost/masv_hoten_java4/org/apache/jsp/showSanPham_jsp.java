/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.35
 * Generated at: 2020-07-07 01:44:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entities.KhachHang;
import entities.laptop;
import model.SanPhamModel;
import java.util.ArrayList;

public final class showSanPham_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/iOllio/Desktop/masv_hoten/masv_hoten/PS11141_NguyenMinhKhoi_Lab_SOF301/build/web/WEB-INF/lib/jstl-impl.jar!/META-INF/c.tld", Long.valueOf(1343794618000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl.jar", Long.valueOf(1593864375331L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("entities.laptop");
    _jspx_imports_classes.add("entities.KhachHang");
    _jspx_imports_classes.add("model.SanPhamModel");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

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
      out.write("        <link href=\"CSS/menu.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"CSS/showSanPham.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"CSS/validateForm.css\" rel=\"stylesheet\" type=\"text/css\">       \n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js\"></script>\n");
      out.write("        <script defer src=\"./js/scripts.js\"></script>\n");
      out.write("        <title>Xshop</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        ");

            String loginValidateChk = String.valueOf(session.getAttribute("loginValidateChk"));
            session.setAttribute("loginValidateChk", null);
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var Chk = ");
      out.print( '"' + loginValidateChk + '"');
      out.write(";\n");
      out.write("            if(Chk != \"null\"){\n");
      out.write("                window.onload = function(){\n");
      out.write("                    if (Chk == \"success\"){\n");
      out.write("                        console.log('success try');\n");
      out.write("                        document.getElementById(\"welcomeText\").innerText=\"Logging in ...\";                                                \n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                        console.log('fail try');\n");
      out.write("                        document.getElementById(\"welcomeText\").innerText=\"Opsss!! Wrong input.\";                    \n");
      out.write("                    }\n");
      out.write("                    document.getElementById(\"welcomeModal\").style.display =\"block\";                      \n");
      out.write("                    document.querySelector(\".welcomeModalContent\").style.cssText = \"animation: w70 0.3s ease forwards;\";                     \n");
      out.write("                    document.querySelector(\".welcomeModalContent\").addEventListener(\"animationend\", ()=>{  \n");
      out.write("                        document.getElementById(\"welcomeText\").style.opacity=\"1\";  \n");
      out.write("                        document.getElementById(\"welcomeText\").addEventListener(\"transitionend\", ()=>{                            \n");
      out.write("                            document.getElementById(\"lottieAnimation\").style.display =\"block\";\n");
      out.write("                            setTimeout(function(){\n");
      out.write("                                document.getElementById(\"welcomeModal\").style.display =\"none\";\n");
      out.write("                            }, 2000);\n");
      out.write("                        });                                                                                   \n");
      out.write("                    })\n");
      out.write("                };\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <div id=\"welcomeModal\">\n");
      out.write("            <div class=\"welcomeModalContent\">\n");
      out.write("                <div id=\"welcomeText\">Logging in ...</div>        \n");
      out.write("                <!-- <div id=\"lottieAnimation\" width=\"100px\"></div>    -->\n");
      out.write("                <lottie-player \n");
      out.write("                    ");
  if(loginValidateChk.equalsIgnoreCase("success")){
                            out.print("src='ok.json'");
                        }
                        else{
                            out.print("src='fail.json'");
                        }
                    
      out.write(" id=\"lottieAnimation\"  \n");
      out.write("                    background=\"transparent\" speed=\"1.0\"  style=\"width: 100px; height: 100px;\" autoplay>\n");
      out.write("                </lottie-player>   \n");
      out.write("                <!-- <script src=\"lottie.js\"></script>\n");
      out.write("                <script>\n");
      out.write("                    var animation = bodymovin.loadAnimation({\n");
      out.write("                        container: document.getElementById('lottieAnimation'),\n");
      out.write("                        renderer: 'svg',\n");
      out.write("                        background : \"transparent\",\n");
      out.write("                        speed: \"1.0\",\n");
      out.write("                        // loop: true,\n");
      out.write("                        autoplay: true,\n");
      out.write("                        path: \"ok.json\"\n");
      out.write("                    })\n");
      out.write("                </script> -->\n");
      out.write("\n");
      out.write("            </div>           \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <nav>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"showSanPham.jsp\">HOME</a></li>\n");
      out.write("                    <li><a href=\"#\">PRODUCTS</a></li>\n");
      out.write("                    <li><a href=\"#\">SERVICES</a></li>\n");
      out.write("                    <li><a href=\"#\">CONTACT</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div id=\"account\">                   \n");
      out.write("                    ");

                        Cookie[] cookies = request.getCookies();
                        String name = null, diachi = null, phone = null;
                        if (cookies != null) {
                            for (int i = 0; i < cookies.length; i++) {
                                if (cookies[i].getName().equalsIgnoreCase("khachHangInfo")) {
                                    String[] khachHangInfo = cookies[i].getValue().split("gap");
                                    name = khachHangInfo[0].trim().replace("-", " ");
                                    diachi = khachHangInfo[1].trim().replace("-", " ");
                                    phone = khachHangInfo[2].trim();
                                    out.print("<a id='khachHang' href='Cart?yeucau=KhachHangInfo'>" + name + "</a>");
                                    out.print("<a id='logOut' href='Cart?dangNhap=logOut'>Log out</a>");
                                }
                            }
                        }
                        if (name == null) {
                            out.print("<a id='login' onclick='logIn()' >Login | Sign up</a>");
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div> <!-- Menu -->\n");
      out.write("\n");
      out.write("        <form action=\"Cart\" method=\"post\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"containerTskBar\">\n");
      out.write("                    <div class=\"type\">LAPTOP</div>\n");
      out.write("                    <div class=\"filterBar\">\n");
      out.write("                        <select id=\"brandSelector\">\n");
      out.write("                            <option value=\"Asus\"> Asus </option>\n");
      out.write("                            <option value=\"Lenovo\"> Lenovo </option>\n");
      out.write("                            <option value=\"Dell\"> Dell </option>\n");
      out.write("                            <option selected=\"selected\"> All </option>\n");
      out.write("                        </select>\n");
      out.write("                        <!--\n");
      out.write("                        --><a href=\"Cart?yeucau=giatangdan\">Price up</a><!--\n");
      out.write("                        --><a href=\"Cart?yeucau=giagiamdan\">Price down</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    ");
  ArrayList<laptop> list = new SanPhamModel().getList(null);
                        for (int i = 0; i < list.size(); i++) {
      out.write("\n");
      out.write("                    <div>\n");
      out.write("                        <image src=\"laptop/");
      out.print( list.get(i).getPhoto());
      out.write("\">\n");
      out.write("                        <a class=\"productName\">");
      out.print( list.get(i).getName());
      out.write("</a>\n");
      out.write("                        <a>");
      out.print( list.get(i).getPrice() + "$");
      out.write("</a>\n");
      out.write("                        <div> <a href=\"Cart?yeucau=buy&tensp=");
      out.print( list.get(i).getName());
      out.write("\">BUY</a> </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
  }
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("\n");
      out.write("    <div id=\"modal\">\n");
      out.write("        <form class=\"loginForm\" action=\"Cart\" method=\"post\">\n");
      out.write("            <div id=\"closeForm\">Close</div>\n");
      out.write("\n");
      out.write("            <div class=\"loginFormContent login\">\n");
      out.write("                <a>User</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"username\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a>Password</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"password\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>    \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"loginFormContent create\">\n");
      out.write("                <a>User</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"username\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a>Password</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"password\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a>Re-enter Password</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"reEnterPassword\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a>Full name</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"fullName\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a>Phone number</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"phone\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a>Addres</a>\n");
      out.write("                <div>\n");
      out.write("                    <div>\n");
      out.write("                        <input onchange=\"formValidate(this)\" name=\"address\" type=\"text\">\n");
      out.write("                        <img src=\"img/check.png\">\n");
      out.write("                    </div>\n");
      out.write("                    <a></a>  \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <hr>\n");
      out.write("            <input id=\"loginFormBtn\" type=\"submit\" name=\"dangNhap\" value=\"Login\">\n");
      out.write("            <span onclick=\"signUp(this)\">Sign up</span>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        .find {\n");
      out.write("            background-image: url(\"img/search.png\");\n");
      out.write("            background-size: 50%;\n");
      out.write("            background-position: center;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-color: rgba(0, 0, 0, 0.8);\n");
      out.write("\n");
      out.write("            height: 60px;\n");
      out.write("            width: 60px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <div class=\"findContainer\">\n");
      out.write("        <div class=\"findTxtContainer\">\n");
      out.write("            <input type=\"text\" onkeyup=\"findByKeyUp(this)\" id=\"findTxtField\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"find\"></div>\n");
      out.write("        <div id=\"findResult\"></div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}