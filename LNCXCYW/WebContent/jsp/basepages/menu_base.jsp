<%@ include file="/jsp/basepages/taglib.jsp" %>
<!-- <link href="dashboard.css" rel="stylesheet">  -->


<layout:override name="menu_list">

	<div class="menu-list" style="height: 820px">
		
		<s:if test="#session.user.role==2">
			<a href="/user/priojectAdd" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;项目提交</span>
			</a> 
			
			<a href="/user/projectManage" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;项目管理</span>
			</a> 
			
			<a href="/user/information" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;个人信息</span>
			</a> 
		
		</s:if>
		
		<s:else>
			<a href="/admin/newsAdd" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;新闻添加</span>
			</a> 
			<a href="/jsp/admin/news_delete.jsp" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;新闻删除</span>
			</a>
			
			<a href="/admin/pictureLink" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;图片新闻链接</span>
			</a> 
			
			
			<a href="/admin/project_manage/" class="menu-button-middle">
				<span class="glyphicon glyphicon-th-large">&nbsp;对接项目审核</span>
			</a>
				
				
			<s:if test="#session.user.role==1">
				<a href="/admin/user_request/" class="menu-button-middle"><span
					class="glyphicon glyphicon-th">&nbsp;管理员审核</span></a>
				<a href="/admin/user_authority/" class="menu-button-middle"><span
					class="glyphicon glyphicon-th">&nbsp;权限管理</span></a>
				<a href="/examManage" class="menu-button-middle"><span
					class="glyphicon glyphicon-th">&nbsp;试卷管理</span></a>
			</s:if>
	
			<a href="#" class="menu-button-middle"><span
				class="glyphicon glyphicon-list-alt">&nbsp;下载中心</span></a> <a href="#"
				class="menu-button-middle"><span
				class="glyphicon glyphicon glyphicon-user">&nbsp;个人信息</span></a>
			
			</s:else>


	</div>


</layout:override>








<%@ include file="/jsp/basepages/user_base.jsp" %>
