<%@ include file="/jsp/basepages/taglib.jsp" %>
	<ul>
		<s:iterator value="list" var="i" status="index">
			<li>
				<a href="<s:property value="#i.news_address" />">
					<s:property value="#i.newsTile" />
				</a>
			</li>
		</s:iterator>
	</ul>