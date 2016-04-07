<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
	<div class="inner">
		<ul>
			<s:iterator value="newsList" var="i" status="index">	
				<li><a><s:property value="#i.newsTile" /></a></li>
			</s:iterator>
		</ul>
	</div>
</div>
</layout:override>
<%@ include file="base.jsp" %>