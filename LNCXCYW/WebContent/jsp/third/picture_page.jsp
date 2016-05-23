<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent" id="paginationTableDiv">  
	<div class="inner" style="margin-top:-35px; margin-left:-10px">
		<a href="<s:property value="#i.news_address" />">
			
			<img alt="<s:property value="%{addressList.get(0).newsTile}"/>" src="<s:property value="%{addressList.get(0).news_address}"/>" width="600px" height="620px">
		</a>
	</div>
</div>



<!-- 为了使用分页，include如下jsp -->
<%-- <%@ include file="/jsp/base/widgets/pagination.jsp" %> --%>

</layout:override>

<layout:override name="eve_push">
	<ul>
		<s:iterator value="list" var="i" status="index">
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
<%@ include file="picture_base.jsp" %>