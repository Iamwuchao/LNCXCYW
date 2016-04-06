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
					<th>状态</th>
					
					<th>修改</th>
				</tr>
			
			
		<s:iterator value="users" var="i" status="index">
			<%-- <s:if test="%{#i.avaliable==1}"> --%>
				<tr class="row" id=<s:property value="#i.userId"/> >
					<%-- <td> <s:property value="#index.count"/> </td> --%>
					<td> <s:property value="#i.userName"/> </td>
					<td> <s:property value="#i.mail"/> </td>
					
					<s:if test="%{#i.avaliable==0}">
					<td>审核不通过</td>
				</s:if>
				<s:else >
					<td>审核通过</td>
				</s:else>
					<td>
						<button type="button" class="btn btn-primary btn-sm change">撤销</button>
					</td>	
				</tr>
		<%-- 	</s:if>	 --%>	
		</s:iterator>
			</table>
		</div>
	</div>
	<script>
	$(".change").click(function(){
		var id=$(this).closest("tr").attr("id");
		/* var isPass=$('#judge').find("option:selected").val(); */
		$.ajax({
			url: '/admin/user_request/request_change',
	        type: 'post',
	        dataType: 'json',
	        data:{userId:id},
	        success:changeCallBack
		});
	})
	
	function changeCallBack(data){
		if(data.strValue=="success"){
			var p=$("#"+data.userId);
			$("#"+data.userId).remove();
		}
		else alert("something wrong!!");
	}
	</script>
	
</layout:override>


<%-- <%@ include file="super_base.jsp" %> --%>
<%@ include file="users_request.jsp" %>