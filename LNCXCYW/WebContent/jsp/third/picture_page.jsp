<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">

<div>  
	<p style="text-align:center; font-weight:bold;font-size:20px; line-height:32px; font-family:'微软雅黑'; margin-top:20px; color:#06c; text-shadow:1px 1px 1px #c1e0ff;"><s:property value="%{addressList.get(0).newsTile}"/></p>	
	<p style="text-align:center; color:grey; font-size:12px; margin-bottom:10px;">作者：<s:property value="%{addressList.get(0).author}"/></p>	
</div>


<div class="mycontent" id="paginationTableDiv">  
	<div style="margin-top:-15px; /* margin-left:-10px */">
		<a href="<s:property value="#i.news_address" />">			
			<img alt="<s:property value="%{addressList.get(0).newsTile}"/>" src="<s:property value="%{addressList.get(0).news_address}"/>" style="width:600px; height:450px;  margin:17px auto; ">
		</a>
	</div>
</div>
</layout:override>


<%@ include file="base.jsp" %>