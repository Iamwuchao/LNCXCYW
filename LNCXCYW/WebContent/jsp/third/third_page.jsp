<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">


<div>  
	<p style="text-align:center; font-weight:bold;font-size:16px; font-family:'微软雅黑';">标题：<s:property value="title"/></p>	
	<p style="text-align:right; color:grey; font-size:12px;">作者：<s:property value="author"/></p>	
</div>


<div class="mycontent">  
	<s:property escape="false" value="content"/>			
</div>
</layout:override>

<layout:override name="eve_push">
	<ul>
		<s:iterator value="newestNewsList" var="i" status="index">
			<li>
				<a href="<s:property value="#i.news_address" />">
					<s:property value="#i.newsTile" />
				</a>
			</li>
		</s:iterator>
	</ul>
</layout:override>

<layout:override name="focus_left_picture">
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(0).news_address}"/>"><img class="one" src="<s:property value="%{pictureNewsList.get(0).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(0).newsTile}"/>" width="115px" height="120px"></a>
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(1).news_address}"/>"><img class="two" src="<s:property value="%{pictureNewsList.get(1).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(1).newsTile}"/>" width="115px" height="120px"></a>
</layout:override>
<layout:override name="focus_right_picture">
	   <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(2).news_address}"/>"><img class="one" src="<s:property value="%{pictureNewsList.get(2).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(2).newsTile}"/>" width="115px" height="120px"></a>
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(3).news_address}"/>"><img class="two" src="<s:property value="%{pictureNewsList.get(3).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(3).newsTile}"/>" width="115px" height="120px"></a>
</layout:override>
<%@ include file="base.jsp" %>