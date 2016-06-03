<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">.

<div class="mycontent" id="paginationTableDiv">  
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



<!-- 为了使用分页，include如下jsp -->
<%@ include file="/jsp/base/widgets/pagination.jsp" %>

</layout:override>


<layout:override name="focus_left_picture">
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(0).news_address}"/>"><img class="one" src="<s:property value="%{pictureNewsList.get(0).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(0).newsTile}"/>" width="130px" height="120px"></a>
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(1).news_address}"/>"><img class="two" src="<s:property value="%{pictureNewsList.get(1).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(1).newsTile}"/>" width="130px" height="120px"></a>
</layout:override>
<layout:override name="focus_right_picture">
	   <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(2).news_address}"/>"><img class="one" src="<s:property value="%{pictureNewsList.get(2).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(2).newsTile}"/>" width="130px" height="120px"></a>
       <a id="pic" href="/picture_news?news_address=<s:property value="%{pictureNewsList.get(3).news_address}"/>"><img class="two" src="<s:property value="%{pictureNewsList.get(3).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(3).newsTile}"/>" width="130px" height="120px"></a>
</layout:override>



<%@ include file="base.jsp" %>

<script type="text/javascript">
	/* $("img").click(function(){
		alert("hello");
		var img_src = $(this).attr('src'); 
		alert(img_src);
		
		 $.ajax({
			url:'picture_address',
			type:'post',
			dataType:'json',
			data:{"news_address":img_src},
			success:ShowPic
		}); 
	}) */
</script>