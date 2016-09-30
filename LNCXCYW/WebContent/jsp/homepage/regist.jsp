<%@ include file="/jsp/basepages/taglib.jsp" %>  

<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" /> 
<title>注册页面</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"> --%>

 <link href="/css/registCss.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
<div class = "form-center">
	<h1>辽宁省创新创业网注册</h1>
	<br/>	
    <form class="form text">
        <table >
            <tr>
                <td >姓&nbsp;&nbsp;名</td>
                <td><input type="text" class="" name="username" id="username"  value="" placeholder="您的真实姓名"></td>
                <td><span style="color:red" id="userName_msg">*</span></td>
            </tr>

            <tr>
            <td>密&nbsp;&nbsp;码</td>
            <td><input type="password" class="" name="password" id="password" value="" placeholder=""></td>
            <td><span style="color:red" id="password_msg">*</span></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" class="" id="passwordAgain" name="passwordAgain"  value="" placeholder=""></td>
                <td><span style="color:red" id="confirm_msg">*</span></td>
            </tr>
            <tr>
                <td>邮&nbsp;&nbsp;箱</td>
                <td><input type="text" class="" name="email" id="email"  value="" placeholder="请填写有效邮箱">	</td>
                <td><span style="color:red" id="email_msg">*</span></td>
            </tr>
            <tr>
                <td>角&nbsp;&nbsp;色</td>
                <td><select class="judge" id="role">
                    <option value="0" selected>管理员</option>
                    <option value="2">学生用户</option>
                    <option value="3">企业用户</option>
                </select>	</td>
                <td></td>
            </tr>

            <tr class="student">
                <td>学&nbsp;&nbsp;校</td>
                <td><input type=text class="form-control" id="college" name="college"  value="" placeholder="">	</td>
                <td><span style="color:red" id="school_msg">*</span></td>
            </tr>
            <tr class="student">
                <td>学&nbsp;&nbsp;号</td>
                <td><input type="text" class="form-control" id="schoolNum" name="schoolNum"  value="" placeholder="">	</td>
                <td><span style="color:red" id="schoolNum_msg">*</span></td>
            </tr>
            <tr class="company">
                <td>公&nbsp;&nbsp;司</td>
                <td><input type="text" class="form-control" id="companyFor" name="studentId"  value="" placeholder="">	</td>
                <td><span style="color:red" id="company_msg">*</span></td>
            </tr>
            <tr>
                <td>手&nbsp;&nbsp;机</td>
                <td><input type="password" class="form-control" id="phoneNumber" name="phoneNumber"  value="" placeholder="">	</td>
                <td></td>
            </tr>
            <tr>
                <td>备&nbsp;&nbsp;注</td>
                <td><input type="text" class="form-control" id="remark" name="remark"  value="" placeholder="">	</td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td  style="text-align: center">
                    <button type="button" id="regist" class="btn btn-primary">注册</button>

                </td>
<td></td>
            </tr>
        </table>

    </form>

</div>
<footer  style="font-size:14px; margin-top:100px; margin-bottom:0px;display:block;width:100%;
	text-align:center;">
		  <p>Copyright © 1986 - 2016 All rights reserved | <a href="http://chuangxin.dlut.edu.cn">大连理工大学创新实验学院版权所有</a> | GPLv3 <a href="http://gplv3.fsf.org/">Terms</a></p>
		</footer>
<script type='text/javascript' src="/js/base/jquery-2.1.4.min.js"></script>
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
<%-- <%@ include file="/jsp/basepages/base2.jsp" %> --%>