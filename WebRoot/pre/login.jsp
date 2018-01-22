<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    if(request.getSession().getAttribute("loginUser")!=null){
        response.sendRedirect(request.getContextPath()+"/Home?action=index");
    }
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%@ include file="/common/pre/header.jsp" %>
    <script type="text/javascript" src="${ctx}/statics/js/login/login.js"></script>
    <title>全球e购</title>
</head>
<body>  
<!--Begin Login Begin-->
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="${ctx}/Home?action=index"><img src="${ctx}/statics/images/logo.png" /></a></div>
    </div>
	<div class="login">
    	
		<div class="log_c">
        	<form>
            <table border="0" style="width:370px; font-size:14px; margin-top:54px;" cellspacing="0" cellpadding="0">
              
                <td>用户名</td>
                <td><input type="text" name="loginName" id="loginName" value="" class="l_user" /></td>
              </tr>
              <tr height="70">
                <td>密&nbsp; &nbsp; 码</td>
                <td><input type="password" name="password" id="password" value="" class="l_pwd" /></td>
              </tr>
              <tr height="60">
              	<td>&nbsp;</td>
                <td><input type="button" value="登录" class="log_btn" onclick="login();" /></td>
              </tr>
              <tr height="50" valign="bottom" >
              	<td width="55">&nbsp;</td>
                <td>
                	<span class="fr"><a href="#" style="color:#6c6c6c;  ">忘记密码</a></span>
                    <span class="fr"><a href="${ctx}/Register?action=toRegister" style="color:#6c6c6c;">立即注册&nbsp;&nbsp;&nbsp;</a></span>
                </td>
              
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<!--End Login End--> 
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="${ctx}/statics/images/b_1.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_2.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_3.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_4.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_5.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_6.gif" width="98" height="33" />
    </div>    	
</div>
<!--End Footer End -->
</body>
<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
