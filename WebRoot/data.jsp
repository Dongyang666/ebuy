<%@ page language="java" import="java.util.*,cn.ebuy.im.*" pageEncoding="utf-8"%>
<%
   request.setCharacterEncoding("utf-8");
   String info=request.getParameter("info");
   String answer= ChatsUtil.getResult(info);
   out.println(answer);
   
%>
