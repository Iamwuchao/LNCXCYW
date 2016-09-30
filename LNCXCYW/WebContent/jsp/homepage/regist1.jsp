<%@ include file="/jsp/basepages/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<title>注册页面</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"> --%>
<script type='text/javascript' src="/js/base/jquery-2.1.4.min.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body style="background: url(/images/a.jpg); background-size:cover">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


<div class="form-group"
		style="margin-left: auto; margin-right: auto; padding-top: 3%; padding-bottom: 5%; background-color:">
	
	
	<form class="form-inline" action="" method="POST" id="">
	  
	  <div class="form-group col-lg-offset-5">
	  	<h2>辽宁省创新创业网注册</h2>	
	  </div>
	  <br>
	  <br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="fullname">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
	  	<input type="text" class="form-control" name="username" id="username"  value="" placeholder="您的真实姓名">	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="userName_msg">*</span>
	  </div>
	  
	  <br><br>
	  
	  <div class="form-group col-lg-offset-5">
	  	<label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
	  	<input type="password" class="form-control" name="password" id="password" value="" placeholder="">
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="password_msg">*</span>
	  </div>
	  
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="passwordAgain">确认密码</label>
	  	<input type="password" class="form-control" id="passwordAgain" name="passwordAgain"  value="" placeholder="">
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="confirm_msg">*</span>
	  </div>
	   
	  
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="fullName">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
	  	<input type="text" class="form-control" name="email" id="email"  value="" placeholder="请填写有效邮箱">	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="email_msg">*</span>
	  </div> 
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="fullName">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色</label>
	  	<select class="judge" id="role">
			<option value="0" selected>管理员</option>
			<option value="2">学生用户</option>
			<option value="3">企业用户</option>
		</select>	
	  </div>
	  <br>
	  <div class="student" >
	  <br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="college">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校</label>
	  	<input type=text class="form-control" id="college" name="college"  value="" placeholder="">
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="school_msg">*</span>
	  </div>
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="schoolNum">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
	  	<input type="text" class="form-control" id="schoolNum" name="schoolNum"  value="" placeholder="">
	  </div>	
	  <div class="form-group">
	  	<span style="color:red" id="schoolNum_msg">*</span>
	  </div>
	  </div>
	  
	  <div class="company">
	  <div class="form-group col-lg-offset-5">
	  <br>
	  	<label for="companyFor">公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司</label>
	  	<input type="text" class="form-control" id="companyFor" name="studentId"  value="" placeholder="">
	  
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="company_msg">*</span>
	  </div>	
	 </div>
	  
	  <br>
	  <div class="form-group col-lg-offset-5">
	  
	  	<label for="phoneNumber">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>
	  	<input type="text" class="form-control" id="phoneNumber" name="phoneNumber"  value="" placeholder="">
	  </div>	  
	  
	  <br><br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="remark">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</label>
	  	<input type="text" class="form-control" id="remark" name="remark"  value="" placeholder="">
	  </div>
	  
	  	  
	  <br><br>
	  <div class="form-group col-lg-offset-6">
	  	<button type="button" id="regist" class="btn btn-primary">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red">(*为必填项)</span>
	  </div>
	  <!-- <div class="form-group col-lg-offset-1">
	  	<span style="color:red">(*为必填项)</span>
	  </div> -->
	  </form>
	  </div>
	  
 
</body>
<script >
document.onload = function(){
	var $stud = $(".student");
	var $company = $(".company");
	//console.log("ooo");
	$stud.hide();
	$company.hide();
}();
$(document).on("change","#role",function(){
	
	var selectedVal = $("#role").val();
		var $stud = $(".student");
		var $company = $(".company");
		switch (selectedVal) {
		case "0"://管理员
			$stud.hide();
			$company.hide();
			break;
		case "2"://学生
			$stud.show();
			$company.hide();
			break;
		case "3"://企业
			$stud.hide();
			$company.show();
			break;
		}
		console.log(selectedVal);
	})

	$(document).on(
			"click",
			"#regist",
			function() {

				/* checkPassword();
				confirmPassword();
				checkEmail(); */
				if (checkUserName() && checkPassword() && confirmPassword()
						&& checkEmail() && checkNull($("#college"), $("#school_msg")) 
						&& checkNum($("#schoolNum"), $("#schoolNum_msg")) && checkNull($("#companyFor"), $("#company_msg"))) {
					//alert("4");
					var username = $("#username").val();
					var password = $("#password").val();

					var role = $("#role").val();
					var college = $("#college").val();
					var phoneNumber = $("#phoneNumber").val();
					var remark = $("#remark").val();
					var studentId = $("#schoolNum").val();
					
					var company = $("companyFor").val();
					
					alert(role + "学校：" + college + " " + phoneNumber + " 学号"
							+ studentId +"公司:"+company);

					var email = $("#email").val();
					var params = {
						username : username,
						password : password,
						email : email,
						role : role,
						studentId : studentId,
						college : college,
						company : company,
						phoneNumber : phoneNumber,
						remark : remark,
					}

					$.ajax({
						url : '/regist',
						type : 'post',
						dataType : 'json',
						data : params,
						success : registerCallback
					});
				} else {

				}

			});

	function checkUserName() {

		var username = $("#username").val();
		//alert(username);
		if (username == "") {

			$("#userName_msg").text("不能为空");
			//$("#username").focus();
			return false;
		} else {
			$("#userName_msg").text("");
			return true;
		}

	}

	function checkPassword() {
		var password = $('#password').val();
		if (password == "") {
			$('#password_msg').text("不能为空");
			return false;
		} else {
			$('#password_msg').text("");
			return true;
		}
	}

	function confirmPassword() {
		var password = $('#password').val();
		var passwordAgain = $('#passwordAgain').val();
		if (!(password == passwordAgain)) {
			$('#confirm_msg').text("两次密码不一致");
			//	$('#passwordAgain').focus();
			return false;
		} else {
			$('#confirm_msg').text("");
			return true;
		}
	}
	
	

	function checkEmail() {
		var email = $("#email").val();
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if (!reg.test(email)) {
			$('#email_msg').text("请填入有效的邮箱");
			return false;
		} else {
			$('#email_msg').text("");
			return true;
		}
	}
	
function checkNum($elem, $msg){
	if($elem.is(":hidden")){
		$elem.val(null);
		return true;
	}
		var reg = /^[0-9]*$/;
		if(!reg.test($elem.val().trim())){
			$msg.text("请输入数字");
			return false;
		}
		else{
			$msg.text("");
			return true;
		}
	}
	function checkNull($elem, $msg){
		if($elem.is(":hidden")){
			$elem.val(null);
			return true;
		}
		if($elem.val().trim() == ""){
			$msg.text("不能为空");
			return false;
		}
		else{
			$msg.text("");
			return true;
		}
	}
	function registerCallback(data) {
		if (data.register_status == "0") {
			alert("注册成功, 您现在可以登录了");
			window.location.href = "/login";
		} else if (data.register_status == "1") {
			alert("该邮箱已被注册");
		} else {
			alert("error with status：" + data.register_status);
		}

	}
</script>

</html>
<%@ include file="/jsp/basepages/base2.jsp" %>