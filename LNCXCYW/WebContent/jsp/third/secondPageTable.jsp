<%@ include file="/jsp/basepages/taglib.jsp" %>

<div class="mycontent">  
	<div class="inner">
		<ul>
			<s:iterator value="newsList" var="i" status="index">	
				<li>
					<a href="<s:property value="#i.news_address" />">
						<s:property value="#i.newsTile" />
					</a>
				</li>
			</s:iterator>
		</ul>
	</div>
</div>