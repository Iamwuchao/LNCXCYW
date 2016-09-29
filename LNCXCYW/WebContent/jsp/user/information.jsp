<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="main_content">

<div class="mycontent">  
		
	<br><br><br><br>
	
	<form class="form-inline" action="" method="POST" id="">
	
		<div class="form-group col-lg-offset-1">
			<label for="email">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
			<input type="text" class="form-control" 
				id="email" name="email" value="<s:property value="email"/>" 
				placeholder="<s:property value="email"/>" readonly>
		</div>
		
		<div class="form-group col-lg-offset-1">
			<label for="username">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</label>
			<input type="text" class="form-control" 
				id="username" name="username" value="<s:property value="username"/>" readonly>
		</div>
			
		<br><br><br>
		
		
		<s:if test="#session.user.role==2">
			<div class="form-group col-lg-offset-1">
				<label for="college">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校</label>
				<input type="text" class="form-control" 
					id="college" name="college" value="<s:property value="college"/>">
			</div>	
			
			<div class="form-group col-lg-offset-1">
				<label for="studentId">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号</label>
				<input type="text" class="form-control" 
					id="studentId" name="studentId" value="<s:property value="studentId"/>">
			</div>	
		</s:if>
		<s:else>
			<div class="form-group col-lg-offset-1">
				<label for="company">公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司</label>
				<input type="text" class="form-control" 
					id="company" name="company" value="<s:property value="company"/>">
			</div>	
			
			<div class="form-group col-lg-offset-1">
				<label for="address">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址</label>
				<input type="text" class="form-control" 
					id="address" name="address" value="<s:property value="address"/>">
			</div>	
		</s:else>

		
		<br><br><br>
		
		<div class="form-group col-lg-offset-1">
			<label for="phoneNumber">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机</label>
			<input type="text" class="form-control" 
				id="phoneNumber" name="phoneNumber" value="<s:property value="phoneNumber"/>">
		</div>	
		
		<div class="form-group col-lg-offset-1">
			<label for="remark">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</label>
			<input type="text" class="form-control" 
				id="remark" name="remark" value="<s:property value="remark"/>">
		</div>		
	</form>
		
	<br><br><br>
		
	<div class="form-group col-lg-offset-4">
		<button type="button" onclick="change()">更改</button>
	</div>	
		
</div>

</layout:override>
<script>
	function change(){
		var college = $("#college").val();
		var studentId = $("#studentId").val();
		var company = $("#company").val();		
		var address = $("#address").val();
		var phoneNumber = $("#phoneNumber").val();
		var remark = $("#remark").val();

		//alert(college+" "+studentId+" "+company+" "+address+" "+phoneNumber+" "+remark);
		
		$.ajax({
			url : '/informationChange',
			type : 'post',
			dataType : 'json',
			data : {
				"college" : college,
				"studentId" : studentId,
				"company" : company,
				"address" : address,
				"phoneNumber" : phoneNumber,
				"remark" : remark,
			},
			success : submitCallback
		});
	}
	
	function submitCallback(data){
		if(data.status=="1"){
			alert("添加失败");
		}else{
			alert("添加成功！");
			location.reload();
		}
	}
</script>
<%@ include file="/jsp/user/user.jsp" %>