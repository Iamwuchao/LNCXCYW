<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">

</head>
<body style="background: url(a.jpg)">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



	<div class="form-group"
		style="margin-left: 35%; margin-right: 35%; padding-top: 3%; padding-bottom: 5%; background-color:">
		<form action="" method="POST" style="position: relative; left: 20%">



			<h2>辽宁省创新创业网登录</h2>
			<br>
			<div class="form-group">
				<label for="username">用户名</label> <input style="width: 60%"
					type="text" class="form-control" name="username" placeholder="用户名">
			</div>

			<div class="form-group">
				<label for="password">密码</label> <input style="width: 60%"
					type="password" class="form-control" name="password"
					placeholder="密码">
			</div>

			<button type="reset" class="btn btn-primary" id="login"
				style="margin-left: 5%">重置</button>
			<button type="submit" class="btn btn-primary" id="login"
				style="margin-left: 5%; margin-right: 5%">登录</button>
				<!-- <a>注册</a> -->
	
	</form>
	</div>

</body>
</html>