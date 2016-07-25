<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">

<div class="mycontent" id="paginationTableDiv">  
	<ul>
		<s:iterator value="newsList" var="i" status="index">	
			<li class="newslist">
			<span style="font-size:12px; line-height:30px; color:grey; float:right;"><s:property value="date"/></span>
				<a href="<s:property value="#i.news_address" />" title="<s:property value="#i.newsTile" />">
					<s:property value="#i.newsTile" />
				</a>
				
			</li>
		</s:iterator>
	</ul>
</div>

<!-- 为了使用分页，include如下jsp -->
<%@ include file="/jsp/base/widgets/pagination.jsp" %>

</layout:override>



<%@ include file="base.jsp" %>

