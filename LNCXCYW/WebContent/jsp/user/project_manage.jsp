<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="main_content">

<div class="mycontent">  
	<br>
	<br>
	<br>
	<br> 
	项目管理


	<table class="classlist table table-bordered " id="news_messeage_table">
		<thead>
			<tr>
				<th>标题</th>
				<th>时间</th>
				<th>分类</th>
				<th>状态</th>
				<th>删除</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="newsList" var="i" status="index">
				<tr id="<s:property value="#i.newsId"/>">

<%-- 					<td><a style="color: black;" href="<s:property value="#i.news_address" />">
						<s:property	value="#i.newsTile" /></a>
					</td>						
					<td><s:property value="#i.date" /></td>
					<td>
						<button type="button" class="btn btn-primary btn-sm ensure-button">删除</button>
					</td> --%>
					
				</tr>
			</s:iterator>
		</tbody>
	</table>
		
		
</div>

</layout:override>




<%@ include file="/jsp/user/user.jsp" %>