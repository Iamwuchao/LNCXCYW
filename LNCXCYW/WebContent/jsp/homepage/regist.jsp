<%@ include file="/jsp/basepages/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"> --%>
<script type='text/javascript' src="/js/base/jquery-2.1.4.min.js"></script>
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



	
	
	<form class="form-inline" action="" method="POST" id="">
	  
	  <div class="form-group col-lg-offset-5">
	  	<h2>辽宁省创新创业网注册</h2>	
	  </div>
	  <br>
	  <br>
	  <div class="form-group col-lg-offset-5">
	  	<label for="fullname">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
	  	<input type="text" class="form-control" name="username" id="username" onblur="checkUserName()" value="" placeholder="您的真实姓名">	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="userName_msg">*</span>
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
	  	<label for="fullName">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
	  	<input type="text" class="form-control" name="email" id="email" onblur="checkEmail()" value="" placeholder="">	
	  </div>
	  <div class="form-group">
	  	<span style="color:red" id="email_msg">*</span>
	  </div>
	  
	  <br><br>
	  <div class="form-group col-lg-offset-6">
	  	<button type="button" id="regist" class="btn btn-primary">注册</button>&nbsp;&nbsp;&nbsp;&nbsp;<span style="color:red">(*为必填项)</span>
	  </div>
	  <!-- <div class="form-group col-lg-offset-1">
	  	<span style="color:red">(*为必填项)</span>
	  </div> -->
	  </form>
 
</body>
<script >
$(document).on("click","#regist", function (){
    alert("4");
	var username = $("#username").val();
    var password = $("#password").val();
    var email = $("#email").val();
    var params={
    		username : username,
    		password : password,
    		email : email,
    }
    
//     alert("1111");
//     alert($("#username").val());
//	   alert($("#phoneNumber").val());
    
    $.ajax({
      url: 'regist',
      type: 'post',
      dataType: 'json',
      data: params,
     /*  async:true,
      contentType:false,
      processData:false, */
      success: registerCallback
    });

}); 

function checkUserName(){
	
	var username = $("#username").val(); 
	//alert(username);
	 if(username=="")
		 {
		 
		$("#userName_msg").text("不能为空"); 
		$("#username").focus();
		 }
	 else
		 $("#userName_msg").text("");
}


function checkPassword(){
	var password=$('#password').val();
	if(password=="")
		$('#password_msg').text("不能为空");
	else
		$('#password_msg').text("");
}

function confirmPassword(){
	var password=$('#password').val();
	var passwordAgain=$('#passwordAgain').val();
	if(!(password==passwordAgain))
		{
			$('#confirm_msg').text("两次密码不一致");
			$('#passwordAgain').focus();
		}
	else
		$('#confirm_msg').text("");
}

function checkEmail(){
	var email = $("#email").val();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(!reg.test(email)){
		$('#email_msg').text("请填入有效的邮箱");
	}
	else{
		$('#email_msg').text("");
	}
}
function registerCallback(data)
{    	
	if(data.register_status == "0")
	{    		
		alert("注册成功, 您现在可以登录了");
		window.location.href = "/login";
	}
	else if(data.register_status == "1")
	{
		alert("有未填项，注册失败");
	}
	else if(data.register_status == "2")
		{
		alert("注册用户名重复");
		}
	/* else if(data.register_status == "4")
	{
		alert("姓名不能为空");
	}*/
	else if(data.register_status == "3")
	{
		alert("两次密码不一致");
	} 
	else if(data.register_status == "6")
	{
		alert("学号已经存在！");
	} 
	else 
		{
		alert("error with status：" + data.register_status);
		}

	
}
</script>

</html>
<%@ include file="/jsp/basepages/base2.jsp" %>