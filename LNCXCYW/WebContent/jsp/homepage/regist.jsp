<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
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



	<!-- <div class="form-group"
		style="margin-left: 35%; margin-right: 35%; padding-top: 3%; padding-bottom: 5%; background-color:">
		<form action="" method="POST" style="position: relative; left: 20%">



			<h2>管理员注册</h2>
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
				

	</form>
	</div> -->
	
	<form class="form-inline" action="" method="POST" id="">
	  
	  <div class="form-group col-lg-offset-5">
	  	<h2>辽宁省创新创业网注册</h2>	
	  </div>
	  <br>
	  <br>
	  <div class="form-group col-lg-offset-5 ">
	  	<label for="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名</label>
	  	<input  type="text" class="form-control" name="username" id="username" onblur=checkUsername() value="" placeholder="用作登录的用户名">	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="username_msg">*</span>
	  </div>
	  
	  <br><br>
	  
	  <div class="form-group col-lg-offset-5">
	  	<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
	  	<input type="password" class="form-control" name="password" id="password" onblur="checkPassword()" value="" placeholder="">
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="password_msg">*</span>
	  </div>
	  
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="passwordAgain">确认密码</label>
	  	<input type="password" class="form-control" id="passwordAgain" name="passwordAgain" onblur="confirmPassword()" value="" placeholder="">
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="confirm_msg">*</span>
	  </div>
	  
	  <br><br>
	   <div class="form-group col-lg-offset-5">
	  	<label for="fullName">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
	  	<input type="text" class="form-control" name="fullName" id="fullName" onblur="checkFullName()" value="" placeholder="您的真实姓名">	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="fullName_msg">*</span>
	  </div>
	  
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="fullName">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
	  	<input type="text" class="form-control" name="Email" id="Email" onblur="" value="" >	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="fullName_msg">*</span>
	  </div>
	  
	  <br><br>
	  <div class="form-group col-lg-offset-6">
	  	<button type="button" class="btn btn-primary">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red">(*为必填项)</span>
	  </div>
	  <!-- <div class="form-group col-lg-offset-1">
	  	<span style="color:red">(*为必填项)</span>
	  </div> -->
	  </form>
 
</body>
</html>