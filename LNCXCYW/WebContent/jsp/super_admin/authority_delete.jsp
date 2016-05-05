<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="mycontent">
	<!-- <script type='text/javascript' src="/js/admin/teachbuilding.js"></script> -->

	<!-- <div class="mycontent">  
		超级管理员主页(include super_admin下的super_base.jsp)

	 </div>   -->
	 
	 
	 <div class="mycontent">
		<div id="classlist-content">
			<table class="classlist table table-bordered "
				id="user_messeage">
				<thead> 
				<tr >

					<th>姓名</th>
					<th>邮箱</th>
					<th>撤销权限</th>
					<th></th>
				</tr>
				</thead>
				<tbody>

					<s:iterator value="userAuthorities" var="i" status="index">
						<tr   id="<s:property value="#i.user.userId"/>" >
						
						
							<td><s:property value="#i.user.userName" /></td>
							<td><s:property value="#i.user.mail" /></td>
							 <td>
							
							
							
							
								<s:select list="#i.userAuthoritiyList" 
	 									 listValue="category.newscategory" 
 	 									listKey="category.categoryId" theme="simple" id="sel" name="selected"> 
	 							</s:select> 
							</td> 
							
						
									
							<td>
								<button type="button"
									class="btn btn-primary btn-sm ensure-button">
									确定</button>
							</td>
						</tr>

					</s:iterator>
					 
				</tbody>
			</table>
		</div>
	</div> 
	<script>
		$(".ensure-button").click(function() {
			var id = $(this).closest("tr").attr("id");
			var selected = $("#sel option:selected").val();
			alert(selected);
			//alert(id);
			//var isPass=$('#judge').find("option:selected").val();

			$.ajax({
				url : '/admin/user_authority/delete_ensure',
				type : 'post',
				dataType : 'json',
				data : {
					userId : id,
					selected : selected
				},
				success : ensureCallBack
			}); 
		})

		function ensureCallBack(data) {
			/* if (data.strValue == "success") {
				var t = $("#" + data.userId);
				$("#" + data.userId).remove();
			} else
				alert("something wrong!!"); */
		} 
	</script>
	
</layout:override>


<%-- <%@ include file="super_base.jsp" %> --%>
<%@ include file="authority_edit.jsp"%>