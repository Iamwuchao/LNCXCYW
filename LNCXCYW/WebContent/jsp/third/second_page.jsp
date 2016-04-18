<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent" id="paginationTableDiv">  
	<div class="inner">
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
</div>



<!-- 为了使用分页，include如下jsp -->
<%@ include file="/jsp/base/widgets/pagination.jsp" %>

<script>

// 你可以定义pageAddtionalData变量，这个变量应该是json变量，这个变量可以直接通过ajax 在选择页码的时候传到后台
// 你应该重写下面这个函数，使其在回调的时候可以做你自己做的事情
function requestPageCallback(data){
	
	$("#resourceFileTableDiv").html(data.news_list_html);
}
</script>


</layout:override>
<%@ include file="base.jsp" %>