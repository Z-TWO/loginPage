<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/register.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/web//js/jquery-3.5.1.js"></script>
</head>
<body>
	<div class="main">
		<div class="login_section">
			<div class="login_tab">
				<a href="${pageContext.request.contextPath }/login.jsp" class="f16">登录账号</a>
				<a href="${pageContext.request.contextPath }/register.jsp" class="f16">注册账号</a>
			</div>
			<div class="login_main">
				<form method="post" action="register">
				<div class="form_group mb2" id="teleDiv">
						<label>手机号</label>
					<div>
						<input type="text" name="teleNum" id="teleNum" class="form-control" placeholder="常用手机号" autocomplete="off">
				    </div>
				    <p id="teleP" class="hidden_p">输入手机号</p>
				</div>
				<div class="form_group mb2" id="nameDiv">
						<label>用户名</label>
				     <div>
						<input type="text" name="username" class="form-control" placeholder="中、英文均可，最长18个英文或9个汉字" autocomplete="off">
				    </div>
				    <p class="hidden_p" id="nameP">输入用户名</p>
				</div>
				<div class="form_group mb2" id="pswDiv">
						<label>密码</label>
					<div>
						<input type="password" name="password" class="form-control" placeholder="5-20位英文、数字、符号，区分大小写" autocomplete="off">
				    </div>
				    <p class="hidden_p" id="pswP">输入密码</p>
				</div>
				<div class="form_group mb2" id="emailDiv">
						<label>邮箱</label>
					<div>
						<input type="text" name="email" class="form-control" placeholder="常用邮箱" autocomplete="off">
				    </div>
				    <p class="hidden_p" id="emailP">输入邮箱</p>
				</div>
				<div class="mb2 submit">
						<input type="submit" value="同意服务协议并注册">
				</div>
				</form>
				<div class="link">
					<span>请详细阅读</span>
					<a href="">《用户服务协议》</a>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/web/js/register.js"></script>
</html>

