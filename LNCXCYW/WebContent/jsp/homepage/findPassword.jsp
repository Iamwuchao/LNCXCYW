<%@ include file="/jsp/basepages/taglib.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>找回密码</title>
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
		<form action="" method="POST" style="position: relative;  left: 20%"">



			<div class="h2">请输入邮箱地址：</div>
			<br>
			<div class="form-group" >
				<label for="email"></label> <input style="width: 60%"
					type="text" class="form-control" name="email" id="email" onblur="checkEmail()" placeholder="邮箱">
			</div>

			
			<div class="form-group">
				
					<button type="button" class="btn btn-primary" id="login"
				style="width: 60%" >确定</button>
			</div>

			<!-- <button type="reset" class="btn btn-primary" id=reset
				style="margin-left: 5%">重置</button>
			<button type="button" class="btn btn-primary" id="login"
				style="margin-left: 5%; margin-right: 5%" >登录</button> -->
				<!-- onclick="window.open('/jsp/admin/newsmanager.jsp')" -->
				<!-- <a>注册</a> -->
	
	</form>
	</div>

</body>
<script type="text/javascript">

$(document).on("click","#login", function (){
  //alert("5");
	if(checkEmail()){
  var email = $("#email").val();
    var params={
    		email : email,
    }
    
//     alert("1111");
//     alert($("#username").val());
//	   alert($("#phoneNumber").val());
    
    $.ajax({
      url: '/findPassword',
      type: 'post',
      dataType: 'json',
      data: params,
     
      success: loginCallback
    });
	}

}); 

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
	if(data.register_status == "ok")
	{    		
		alert("邮箱已发送到该邮箱");
		window.location.href = "/jsp/homepage/login.jsp";
	}
	
	else  
		{
		alert("error with status：" + data.register_status);
		}

	
}


</script>
</html>
<%@ include file="/jsp/basepages/base2.jsp" %>