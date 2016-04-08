<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
	<div class="inner">
		<ul>
			<s:iterator value="newsList" var="i" status="index">	
					<li>
						<a href="<s:property value="#i.news_address" />">
							<s:property value="#i.newsTile" />   
						</a>       类         别  ->  
						<a href="http://localhost:8080/second_page?category=<s:property value="#i.getCategory().getNewscategory()" />" >
							<s:property value="#i.getCategory().getNewscategory()" />
						</a>
					</li>
			</s:iterator>
		</ul>
	</div>
</div>
</layout:override>
<%@ include file="base.jsp" %>