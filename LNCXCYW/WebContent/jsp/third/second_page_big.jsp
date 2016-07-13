<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">

<div class="mycontent" id="paginationTableDiv2">
	
    <s:iterator value="newsMap.keySet()" id="key">  
    	<p style="font-weight:bold;"><s:property value="#key"/>:  <a style="font-size:14px; line-height:20px; color:grey; float:right;" href="/second_page?category=<s:property value="#key"/>">>>更多</a></p>
	    <div style="margin:20px 10px; border-bottom:1px solid rgb(25,85,145); padding:0 20px;">
			<ul>
				<s:iterator value="newsMap.get(#key)" var="i" status="index">
					<li>
						<a href="<s:property value="#i.getNews_address()" />">
							<s:property value="#i.getNewsTile()" />
						</a>
						<p style="display:inline-block; font-size:12px; color:grey; float:right;"><s:property value="date"/></p>
					</li>
				</s:iterator>
			</ul>
		</div>    
      </s:iterator> 
 
</div>
</layout:override>



<%@ include file="base.jsp" %>

