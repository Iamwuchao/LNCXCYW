<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
	<div class="inner">
		<ul>
			<s:iterator value="newsList" var="i" status="index">	
				<%-- <s:if test="%{#i.category==null}"> --%>
					<li>
						<a href="<s:property value="#i.news_address" />">
							<s:property value="#i.category" />
						</a>
					</li>
				<%-- </s:if> --%>
			</s:iterator>
		</ul>
	</div>
</div>
</layout:override>
<%@ include file="base.jsp" %>