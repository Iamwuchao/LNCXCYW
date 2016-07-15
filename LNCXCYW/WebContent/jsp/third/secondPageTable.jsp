<%@ include file="/jsp/basepages/taglib.jsp" %>

<div class="mycontent">  
	<ul>
		<s:iterator value="newsList" var="i" status="index">	
			<li>
				<a href="<s:property value="#i.news_address" />">
					<s:property value="#i.newsTile" />
				</a>
				<span style="font-size:12px; line-height:30px; color:grey; float:right;"><s:property value="date"/></span>
			</li>
		</s:iterator>
	</ul>

</div>