<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">

<div class="mycontent" id="paginationTableDiv2">
	
    <s:iterator value="newsMap.keySet()" id="key">  
    	<p style="font-weight:bold;"><s:property value="#key"/>:  <a style="font-size:14px; line-height:20px; color:grey; float:right;" href="/second_page?category=<s:property value="#key"/>">>>更多</a></p>
	    <div style="margin:0px 10px; border-bottom:1px solid rgb(25,85,145); padding:0 0px;">
			<ul>
				<s:iterator value="newsMap.get(#key)" var="i" status="index">
				<li class="newslist">
				<span style="font-size:12px; line-height:30px; color:grey; float:right;"><s:property value="date"/></span>
					<a href="<s:property value="#i.news_address" />" title="<s:property value="#i.newsTile" />">
						<s:property value="#i.newsTile" />
					</a>
					
				</li>
				</s:iterator>
			</ul>
		</div>    
      </s:iterator> 
 
</div>
</layout:override>



<%@ include file="base.jsp" %>

