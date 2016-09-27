<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="mycontent">
	<!-- <script type='text/javascript' src="/js/admin/teachbuilding.js"></script> -->
	
	<!-- <div class="mycontent">  
		超级管理员主页(include super_admin下的super_base.jsp)

	 </div>   -->
	 <div class="mycontent">
		<div id="classlist-content">
			<table class="classlist table table-bordered table-striped" id="user_messeage">
				<tr class="row">
					<!-- <th>序号</th> -->
					<th>姓名</th>
					<th>邮箱</th>
					<th>角色</th>
					<th>状态</th>
					
					<th></th>
				</tr>
			
			
		<s:iterator value="users" var="i" status="index">
			<s:if test="%{#i.avaliable==0}">
				<tr class="row" id=<s:property value="#i.userId"/> >
					<%-- <td> <s:property value="#index.count"/> </td> --%>
					<td> <s:property value="#i.userName"/> </td>
					<td> <s:property value="#i.mail"/> </td>
					<td> 
						<s:if test="#i.role==0">管理员</s:if>
						<s:elseif test="#i.role==2">学生用户</s:elseif>
						<s:elseif test="#i.role==3">企业用户</s:elseif>
					</td>
					
					<form class="form-inline" action="untreated" method="POST" id="request_form">
					<td> 
					<%-- <s:select list="{'不通过','通过'}" name="strValue"></s:select>  --%>
						<select class="judge" name="strValue">
							<option value="0">不通过</option>
							<option value="1">通过</option>
						</select>
					</td>
					</form>
					<td>
						<button type="button" class="btn btn-primary btn-sm ensure-button">确定</button>
					</td>
				</tr>
			</s:if>		
		</s:iterator>
			</table>
		</div>
	</div>
	<script>
$(".ensure-button").click(function(){
		var id=$(this).closest("tr").attr("id");
		var isPass=$(this).closest("td").prev().children("select").val();
		alert(isPass);
		//var isPass=$('#judge').find("option:selected").val();
		
		$.ajax({
			url: '/admin/user_request/request_ensure',
	        type: 'post',
	        dataType: 'json',
	        data:{userId:id,isPass:isPass},
	        success:ensureCallBack
		});
	})
	
	function ensureCallBack(data){
		if(data.strValue=="success"){
			var t=$("#"+data.userId);
			$("#"+data.userId).remove();
		}
		else alert("something wrong!!");
	}
	</script>
	
</layout:override>


<%-- <%@ include file="super_base.jsp" %> --%>
<%@ include file="users_request.jsp" %>