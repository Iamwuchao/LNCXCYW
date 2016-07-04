<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">

<div>  
	<p style="text-align:center; font-weight:bold;font-size:16px; font-family:'微软雅黑';">标题：<s:property value="%{addressList.get(0).newsTile}"/></p>	
	<p style="text-align:center; color:grey; font-size:12px; margin-bottom:10px;">作者：<s:property value="%{addressList.get(0).author}"/></p>	
</div>


<div class="mycontent" id="paginationTableDiv">  
	<div style="margin-top:-15px; margin-left:-10px">
		<a href="<s:property value="#i.news_address" />">
			
			<img alt="<s:property value="%{addressList.get(0).newsTile}"/>" src="<s:property value="%{addressList.get(0).news_address}"/>" style="width:600px; height:620px;  margin-top:17px; ">
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
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(0).news_address}"/>"><img class="one" src="<s:property value="%{pictureNewsList.get(0).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(0).newsTile}"/>" width="140px" height="105px"></a>
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(1).news_address}"/>"><img class="two" src="<s:property value="%{pictureNewsList.get(1).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(1).newsTile}"/>" width="140px" height="105px"></a>
</layout:override>
<layout:override name="focus_right_picture">
	   <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(2).news_address}"/>"><img class="one" src="<s:property value="%{pictureNewsList.get(2).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(2).newsTile}"/>" width="140px" height="105px"></a>
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(3).news_address}"/>"><img class="two" src="<s:property value="%{pictureNewsList.get(3).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(3).newsTile}"/>" width="140px" height="105px"></a>
</layout:override>
<%@ include file="picture_base.jsp" %>