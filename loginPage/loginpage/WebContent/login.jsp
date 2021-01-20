<%@page import="java.io.PrintWriter"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/web/js/jquery-3.5.1.js"></script>
</head>
<body>
<div class="main">
		<div class="login_section">
			<div class="login_tab">
				<a href="${pageContext.request.contextPath }/login.jsp" class="f16">登录账号</a>
				<a href="${pageContext.request.contextPath }/register.jsp" class="f16">注册账号</a>
			</div>
			<div class="login_main">
				<form method="post" action="login">
<%-- 				<c:if test="${insertDiv != null }"> --%>
<%-- 					${insertDiv } --%>
<%-- 				</c:if> --%>
				<%
					Object insertDiv = request.getAttribute("insertDiv");
					if(insertDiv != null){
						out.print(insertDiv);
					}
				%>
					<div id="returnText">用户名或密码错误</div>
					<div class="form_group mb2" id="userDiv">
						<label>账号</label>
						<div>
							<input type="text" name="username" class="form-control" placeholder="邮箱/手机号/用户名" autocomplete="off">
						</div>
						<p id="userP" class="hidden_p"></p>
					</div>
					<div class="form_group mb2" id="pswDiv">
						<label>密码</label>
						<div>
							<input type="password" name="password" class="form-control" placeholder="密码" autocomplete="off">
						</div>
						<p id="pswP" class="hidden_p"></p>
					</div>
					<div class="mb2 check"><input type="checkbox" name="rember_psw">记住密码</div>
					<div class="mb2 submit"><input type="submit" value="登录"></div>
				</form>
				<div class="link">
					<a href="">找回密码</a>
					<span>|&nbsp;</span>
					<span>还没有注册账号？</span>
					<a href="${pageContext.request.contextPath }/register.jsp">立即注册</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/web/js/login.js"></script>
</html>