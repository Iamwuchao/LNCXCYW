<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="base_content">

<div class="con">
	<div id="content">
		<layout:block name="content">			
		</layout:block>
	</div>
	
	<div class="content-right">
		<div class="inner-top"><p>每日推荐</p>
			<div class="deep-inner-top recommend">
				<%@ include file="/jsp/third/even_push.jsp" %>
			</div>
		</div>
	
		<div class="inner-hot"><p>排行榜</p>
			<div class="deep-inner-hot recommend">
				<%@ include file="/jsp/third/hotest_news.jsp" %>
			</div>
		</div>
	</div>



</div>
</layout:override>



<%@ include file="/jsp/basepages/base.jsp" %>