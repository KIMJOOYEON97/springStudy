/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.44
 * Generated at: 2021-06-09 10:42:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.funding;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ready3BasicRequire_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/makerNav.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Basic Require | IF Maker Studio", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ????????? ?????? ???????????? ?????? ??????????????? ??????. ??????????????? ????????? ????????? -->\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("/* ?????? ???????????? ?????????  */\r\n");
      out.write(".modal-backdrop\r\n");
      out.write("{\r\n");
      out.write("    opacity:0.5 !important;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* ?????? scroll */\r\n");
      out.write("/* Important part */\r\n");
      out.write(".modal-dialog{\r\n");
      out.write("    overflow-y: initial !important\r\n");
      out.write("}\r\n");
      out.write(".modal-body{\r\n");
      out.write("    height: 80vh;\r\n");
      out.write("    overflow-y: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container p-5\">\r\n");
      out.write("            \r\n");
      out.write("    <h1 class=\"font-weight-bold\">?????? ??????</h1>\r\n");
      out.write("    <p class=\"text-muted\">?????? ????????? ?????? ?????? ????????? ??????????????? ?????????. ?????? ??? ???????????? ????????? ??????????????? ????????? ????????? ????????? ???????????????.\r\n");
      out.write("        ?????? ????????? ????????? ?????? ??????, ?????? ????????? ?????? ???????????? ????????? ??? ????????????.\r\n");
      out.write("    </p>\r\n");
      out.write("\r\n");
      out.write("    <p>\r\n");
      out.write("        Q1. ???????????? ??? ????????????????????? ??? ????????? ?????????, ?????? ???????????? ??? ?????? ??????????????? ????????? ?????? ????????? ?????? ?????? ?????????????\r\n");
      out.write("    </p>\r\n");
      out.write("    <div class=\"makerbasicrequirechb\">\r\n");
      out.write("        <div class=\"input-group-prepend\">\r\n");
      out.write("          <div class=\"input-group-text\">\r\n");
      out.write("            <input type=\"radio\" aria-label=\"Radio button for following text input\">\r\n");
      out.write("          </div>\r\n");
      out.write("            <label for=\"\">?????????. ?????? ????????? ????????? ?????? ????????? ???????????? ?????? ?????? ???????????? ???????????????.</label>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br />\r\n");
      out.write("        <div class=\"input-group-prepend\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"input-group-text\">\r\n");
      out.write("                <input type=\"radio\" aria-label=\"Radio button for following text input\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <label for=\"\">???, ?????? ????????? ????????? ?????? ????????????. ?????? ?????? ?????? ????????????.</label>\r\n");
      out.write("        </div>\r\n");
      out.write("            \r\n");
      out.write("            <!-- ?????? ????????? ??????????????? TEXTAREA  -->\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <p class=\"text-muted\">\r\n");
      out.write("                    ???????????? ?????? ??????????????? ????????? ?????? ????????? ???????????? ????????? ??? ????????????.\r\n");
      out.write("                    ????????? ???????????? ??????/???????????? ?????? ????????? ?????? ????????? ????????? ???????????? ??????????????????.\r\n");
      out.write("                </p>\r\n");
      out.write("                <textarea class=\"form-control\" aria-label=\"With textarea\" id=\"basicRequireYes\" placeholder=\"ex) ???????????? ???????????? ???????????? 00??? ???????????????, ????????? ????????? ??? ?????? ????????? ????????? ????????? ????????? ??????????????? ???????????? ?????????.\" cols=\"\"  rows=\"3\" maxlength=\"500\"></textarea>\r\n");
      out.write("                <!-- ??? ?????? ???????????? ?????? -->\r\n");
      out.write("                <p>500</p>\r\n");
      out.write("            </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <p>\r\n");
      out.write("        Q2. ???????????? ????????? ???????????? ?????? ?????? ??? ???????????? ????????? ??????????????? ??????????????????.\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"text-muted\">\r\n");
      out.write("        1) ???????????? ????????? ????????? ?????? ?????? ????????? ?????? ?????? ???????????? ?????? ?????? ??? ?????? ???????????? ?????? ?????? ?????? ???????????? ????????? ???????????? ?????? ????????? ??????????????????.\r\n");
      out.write("        2) ??????, ??????, ?????? ??? ?????? ???????????? ??????, ?????? ??????, ?????? ?????? ?????? ?????? ?????? ?????? ??? ???????????? ????????? ??????????????????.\r\n");
      out.write("    </p>\r\n");
      out.write("  \r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <textarea class=\"form-control\" aria-label=\"With textarea\" id=\"basicRequireYes\" placeholder=\"????????? ???????????????.\" cols=\"\"  rows=\"3\" maxlength=\"500\"></textarea>\r\n");
      out.write("        <!-- ??? ?????? ???????????? ?????? -->\r\n");
      out.write("        <p>500</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <p>\r\n");
      out.write("        Q3. ???????????? ?????? ????????? ???????????????.\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"text-muted\">\r\n");
      out.write("        1) ???????????? ?????? ??????(?????? or SMS ???)??? ????????????, ????????? ?????? ??? ?????? ????????? ????????? ???????????? ????????? ????????? ???????????????.\r\n");
      out.write("        2) ?????? ????????? ??? ?????? ?????? ?????? ???????????? ??????????????????.\r\n");
      out.write("        3) ??????, ??????, ?????? ??? ?????? ???????????? ?????? ?????????, ??? ?????? ?????? ?????? ?????? ?????? ??????????????????.\r\n");
      out.write("    </p>\r\n");
      out.write("  \r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <textarea class=\"form-control\" aria-label=\"With textarea\" id=\"basicRequireYes\" placeholder=\"????????? ???????????????.\" cols=\"\"  rows=\"3\" maxlength=\"500\"></textarea>\r\n");
      out.write("        <!-- ??? ?????? ???????????? ?????? -->\r\n");
      out.write("        <p>500</p>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <p>\r\n");
      out.write("        ????????? ?????? ??? ?????? ??????\r\n");
      out.write("    </p>\r\n");
      out.write("    <p class=\"text-muted\">\r\n");
      out.write("        ????????? ?????? ??? ?????? ????????? ????????? ???, ?????? ?????? ?????? ????????? ??????????????????. ????????? ?????? ???????????? ????????? ????????? ???????????????.\r\n");
      out.write("    </p>\r\n");
      out.write("    <button type=\"button\" class=\"btn btn-secondary\" onclick=\"makerRewardCategory();\">\r\n");
      out.write("        +????????????\r\n");
      out.write("    </button>\r\n");
      out.write("\r\n");
      out.write("    <!-- ????????? ?????? ?????? -->\r\n");
      out.write("    <div id=\"makerRewardCategory\" class=\"modal\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\" >\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("            <p class=\"font-weight-bold\">????????? ?????? ??? ?????? ??????</p>\r\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("            </button>\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <div class=\"modal-body\" data-spy=\"scroll\"  style=\"height: 500px;\">\r\n");
      out.write("            <!--: ????????????, ??????, ??????, ?????????, ????????????, ??????, ????????????, ????????????-->\r\n");
      out.write("            <div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>????????????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"????????????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>??????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"??????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>??????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"??????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>?????????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"?????????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>????????????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"????????????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>??????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"??????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>????????????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"????????????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"list-group-item\">\r\n");
      out.write("                    <strong>????????????</strong>\r\n");
      out.write("                    <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm\" onclick=\"nextModal(this)\" value=\"????????????\">??????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- ????????? ???????????? -->\r\n");
      out.write("    <div id=\"makerRewardCategoryDetail\" class=\"modal\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("    <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <h5 class=\"modal-title\">????????? ?????? ??? ?????? ??????</h5>\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("                <p>???????????? ????????? ???????????????</p>\r\n");
      out.write("                <div class=\"border\">\r\n");
      out.write("                    <div class=\"font-weight-bold p-1\" id=\"detailRewardCategory\">??????</div>\r\n");
      out.write("                    <button class=\"float-right btn btn-outline-secondary btn-sm \r\n");
      out.write("                    \"style=\" margin-top: -31px;\"\r\n");
      out.write("                     onclick=\"rewardRechoice()\">?????????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("                <p class=\"text-muted\" style=\"font-size: 9px;\">??? ????????? ????????? ?????? ????????? ????????? ????????????\r\n");
      out.write("                    ????????? ?????? ????????? ?????? ?????? ?????? ????????? ?????????????????????.</p>\r\n");
      out.write("                <br><br>\r\n");
      out.write("\r\n");
      out.write("                <p>???????????? ?????? ?????? ????????? ???????????????</p>\r\n");
      out.write("                <input type=\"radio\" name=\"moldYN\" value=\"moldY\"/> <label for=\"moldYN\">????????? ???????????? ???????????? ??????????????????.</label>\r\n");
      out.write("                <br>\r\n");
      out.write("                <input type=\"radio\" name=\"moldYN\" value=\"moldN\"/><label for=\"moldYN\">????????? ???????????? ?????? ???????????? ??????????????????.</label>\r\n");
      out.write("                <br>\r\n");
      out.write("                <br><br>\r\n");
      out.write("\r\n");
      out.write("                <p>????????? ?????? ????????? ???????????????</p>\r\n");
      out.write("                <p class=\"text-muted\"  style=\"font-size: 9px;\">??? ?????? ????????? ?????? ????????? ????????? ????????? ?????? ????????? ?????? ?????? ?????? ????????? ?????????????????????.\r\n");
      out.write("                    ??? ???????????? ????????? ????????? ?????? ????????? ?????? ???????????? ??????????????? ?????????.</p>\r\n");
      out.write("                <input type=\"radio\" name=\"madeForm\" value=\"madeAll\" /> <label for=\"madeForm\">???????????? ???????????? ???????????? ???????????? ?????? ??? ??????, ??????????????? ??? ????????? ???????????????.</label>\r\n");
      out.write("                <input type=\"radio\" name=\"madeForm\" value=\"madeCommisson\" /><label for=\"madeForm\">???????????? ???????????? ???????????? ?????? ?????? ??? ????????? ???????????????, ????????? ?????? ?????? ????????? ???3?????? ?????? ?????? ????????? ???????????????.</label>\r\n");
      out.write("\r\n");
      out.write("                <input type=\"radio\" name=\"madeForm\" value=\"madeFix\" /><label for=\"madeForm\">???????????? ????????? ?????????????????? ????????? ????????? ????????? ????????? ?????? ?????? ????????? ??? ????????? ???????????? ?????? ????????? ?????????????????????.</label>\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"radio\" name=\"madeForm\" value=\"made\" /><label for=\"madeForm\">?????? ?????? ????????? ?????? ???????????? ????????? ???????????? ?????? ??? ?????? ????????? ???????????? ???????????? ???????????????.</label>\r\n");
      out.write("              \r\n");
      out.write("                <br><br>\r\n");
      out.write("                \r\n");
      out.write("                <!-- ??????????????? ??????  -->\r\n");
      out.write("                <p>????????? ?????? ??? ?????? ????????? ?????? ?????? ????????? ??????????????????</p>\r\n");
      out.write("                <p class=\"font-weight-bold\" style=\"font-size: 9px;\">?????? ??????</p>\r\n");
      out.write("                <button class=\"d-inline-flex float-right btn btn-outline-info btn-sm \" onclick=\"rewardRechoice()\">?????????</button>\r\n");
      out.write("                <p class=\"text-muted\" style=\"font-size: 8px;\">jpg, jpeg, png, pdf, zip, xlsx, hwp, 10MB ?????? 20?????? ?????? ????????? ??????</p> \r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-footer d-block\">\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"checkbox\" name=\"mailSend\" aria-label=\"Checkbox for following text input\">\r\n");
      out.write("                <label for=\"mailSend\">????????? ????????????????????? (?????? ?????? ???????????? ??????)</label>\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"checkbox\" name=\"beforeship\" aria-label=\"Checkbox for following text input\">\r\n");
      out.write("                <label for=\"beforeship\">????????? ?????? ????????? ????????? ????????? ?????? ?????? ?????? ????????? ????????? ??????????????????.</label>\r\n");
      out.write("                \r\n");
      out.write("                <input type=\"checkbox\" name=\"uncalledDocument\" aria-label=\"Checkbox for following text input\">\r\n");
      out.write("                <label for=\"uncalledDocument\">????????? ???????????? ????????? ?????? ????????? ???????????????.</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class =\"pb-3\"style=\"text-align:center;\">\r\n");
      out.write("                <input type=\"reset\" value=\"??????\" class=\"d-inline-flex btn btn-outline-primary btn-lg \" onclick=\"cancel()\"/>\r\n");
      out.write("                &nbsp;&nbsp;\r\n");
      out.write("                <input type=\"submit\" value=\"??????\" class=\"d-inline-flex btn btn-primary btn-lg\"></input>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- ????????? ???????????? ?????? ????????? -->\r\n");
      out.write("    <div class=\"d-flex justify-content-between\">\r\n");
      out.write("\r\n");
      out.write("       \r\n");
      out.write("        <div class=\"p-5 border rounded\" style=\"width: 18rem;\">\r\n");
      out.write("            <h5>????????? ??????</h5>\r\n");
      out.write("            <p>??????</p>\r\n");
      out.write("            <br>\r\n");
      out.write("            <h5>????????? ?????? ?????? ??????</h5>\r\n");
      out.write("            <p>??????</p>\r\n");
      out.write("            <br>\r\n");
      out.write("            <h5>????????? ?????? ??????</h5>\r\n");
      out.write("            <p>??????</p>\r\n");
      out.write("            <br>\r\n");
      out.write("            <h5>?????? ?????? ??????</h5>\r\n");
      out.write("            <p>??????</p>\r\n");
      out.write("            <br>\r\n");
      out.write("            <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm \" onclick=\"\">??????</button>\r\n");
      out.write("            <button class=\"d-inline-flex float-right btn btn-outline-secondary btn-sm \" onclick=\"\">??????</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    </div>\r\n");
      out.write("        \r\n");
      out.write("    <br><br>\r\n");
      out.write("    <button type=\"button\" class=\"btn btn-primary btn-lg\" style=\"width: 200px;\">????????????</button>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</section> \r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function makerRewardCategory(){\r\n");
      out.write("        $(\"#makerRewardCategory\").modal()\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("function nextModal(btn){\r\n");
      out.write("    console.log(btn.value);\r\n");
      out.write("    $(\"#makerRewardCategoryDetail\").modal();\r\n");
      out.write("    var catagoryTitle = document.querySelector(\"#detailRewardCategory\");\r\n");
      out.write("    catagoryTitle.innerText=btn.value;\r\n");
      out.write("    console.log(catagoryTitle.innerText);\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function rewardRechoice(){\r\n");
      out.write("    $(\"#makerRewardCategory\").modal()\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
