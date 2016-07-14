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
					<th>已有权限</th>
					<th>增加权限</th>
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
	 									id="userAuthoritiyList" listValue="category.newscategory" 
 	 									listKey="category.categoryId" theme="simple" cssStyle="width:200px;"> 
	 							</s:select> 
							</td>
							
							<td>
							<select id="sel<s:property value="#i.user.userId"/>">
 								<s:iterator value="categories" var="a" status="index" >
 								<option value="<s:property value="#a.categoryId" />"><s:property value="#a.newscategory" /></option>	
 								</s:iterator>
 							</select>
 								<%-- <s:select list="categories" listValue="newscategory" 
									listKey="categoryId"  theme="simple" id="sel" name="selected">
								</s:select>  --%>
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
			//var select = $("#sel");
			var select = document.getElementById("sel"+id);
			var index = select.selectedIndex;
			/* var selected = $("#sel option:selected").val(); */
			var selected = select[index].value;
			alert(selected);
			//alert(id);
			//var isPass=$('#judge').find("option:selected").val();

			$.ajax({
				url : '/admin/user_authority/add_ensure',
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
	<s:debug></s:debug>
</layout:override>


<%-- <%@ include file="super_base.jsp" %> --%>
<%@ include file="authority_edit.jsp"%>