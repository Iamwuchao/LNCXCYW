<%@ include file="/jsp/basepages/taglib.jsp" %>
<!-- <link href="dashboard.css" rel="stylesheet">  -->


<layout:override name="menu_list">

	<div class="menu-list" style="height: 820px">
		
		<a href="/user/projectAdd" class="menu-button-middle">
			<span class="glyphicon glyphicon-th-large">&nbsp;项目提交</span>
		</a> 
		<a href="/user/projectManage" class="menu-button-middle">
			<span class="glyphicon glyphicon-th-large">&nbsp;项目管理</span>
		</a>
		<a href="/user/information" class="menu-button-middle">
			<span class="glyphicon glyphicon glyphicon-user">&nbsp;个人信息</span></a>
	</div>

</layout:override>



<%@ include file="/jsp/basepages/user_base.jsp" %>
