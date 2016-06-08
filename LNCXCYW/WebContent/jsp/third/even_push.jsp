<%@ include file="/jsp/basepages/taglib.jsp" %>
	<ul>
		<s:iterator value="newestNewsList" var="i" status="index">
			<li>
				<a href="<s:property value="#i.news_address" />" style="font-size:12px;">
					<s:property value="#i.newsTile" />
				</a>
			</li>
		</s:iterator>
	</ul>