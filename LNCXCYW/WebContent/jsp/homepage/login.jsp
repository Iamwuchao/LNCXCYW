<%@ include file="/jsp/basepages/taglib.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css"> --%>
<script type='text/javascript' src="/js/base/jquery-2.1.4.min.js"></script>
</head>
<body style="background: url(/images/a.jpg)">
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



			<div class="h2">辽宁省创新创业网登录</div>
			<br>
			<div class="form-group" >
				<label for="email">用户名</label> <input style="width: 60%"
					type="text" class="form-control" name="email" id="email" onblur="checkEmail()" placeholder="邮箱">
			</div>

			<div class="form-group">
				<label for="password">密码</label> <input style="width: 60%"
					type="password" class="form-control" name="password" id="password"
					placeholder="密码">
			</div>

			<button type="reset" class="btn btn-primary" id=reset
				style="margin-left: 5%">重置</button>
			<button type="button" class="btn btn-primary" id="login"
				style="margin-left: 5%; margin-right: 5%" >登录</button>
				<!-- onclick="window.open('/jsp/admin/newsmanager.jsp')" -->
				<!-- <a>注册</a> -->
	
	</form>
	</div>

</body>
<script type="text/javascript">
$(document).on("click","#login", function (){
  //alert("5");
	if(checkPassword() && checkEmail()){
  var email = $("#email").val();
    var password = $("#password").val();
  alert(email+password);
    var params={
    		password : password,
    		email : email,
    }
    
//     alert("1111");
//     alert($("#username").val());
//	   alert($("#phoneNumber").val());
    
    $.ajax({
      url: '/login_handle',
      type: 'post',
      dataType: 'json',
      data: params,
     
      success: loginCallback
    });
	}

}); 




function checkPassword(){
	var password=$('#password').val();
	if(password=="")
		{
			alert("不能为空");
			$('#password').focus();
			return false;
		}
	return true;
}



function checkEmail(){
	var email = $("#email").val();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(!reg.test(email)){
		alert("请填入有效的邮箱");
		 $("#email").focus();
		return false;
	}
	return true;
}
function loginCallback(data)
{   
	//alert(99); 	
	if(data.register_status == "0")
	{    		
		alert("普通管理员登陆成功");
		window.location.href = "/jsp/admin/newsmanager.jsp";
	}
	else if(data.register_status == "1")
		{
		alert("用户名或密码错误");
		}
	else if(data.register_status == "3")
	{
		alert("超级管理员登陆成功");
		window.location.href = "/jsp/super_admin/admin.jsp";
	}
	else  
		{
		alert("error with status：" + data.register_status);
		}

	
}

/* function registerCallback(data)
{    //alert(000);	
	if(data.register_status == "0")
	{    		
		alert("注册成功, 您现在可以登录了");
		window.location.href = "/jsp/admin/newsmanager.jsp";
	}
	else if(data.register_status == "1")
		{
		alert("用户名或密码错误");
		}
	else if(data.register_status == "3")
	{
		alert("超级管理员");
		window.location.href = "/jsp/super_admin/admin.jsp";
	}
	else  
		{
		alert("error with status：" + data.register_status);
		}

	
} */

</script>
</html>
<%@ include file="/jsp/basepages/base2.jsp" %>