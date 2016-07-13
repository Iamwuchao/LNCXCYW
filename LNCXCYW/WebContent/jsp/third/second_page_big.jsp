<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">

<div class="mycontent" id="paginationTableDiv">  
	<p style="font-weight:bold;">高校基地情况</p>
	<div style="margin:20px 10px; border-bottom:1px solid rgb(25,85,145); padding:0 20px;">
		<ul>
			<s:iterator value="%{newsMap.get('创新创业教育基地_高校基地情况')}" var="i" status="index">	
				<li>
					<a href="<s:property value="#i.getNews_address()" />">
						<s:property value="#i.getNewsTile()" />
					</a>
					<p style="display:inline-block; font-size:12px; color:grey; float:right;"><s:property value="date"/></p>
				</li>
			</s:iterator>
		</ul>
	</div>
	
	<p style="font-weight:bold;">高校政策文件</p>
	<div style="margin:20px 10px;  padding:0 20px;">
		<ul>
			<s:iterator value="%{newsMap.get('创新创业教育基地_政策文件')}" var="i" status="index">
				<li>
					<a href="<s:property value="#i.getNews_address()" />">
						<s:property value="#i.getNewsTile()" />
					</a>
					<p style="display:inline-block; font-size:12px; color:grey; float:right;"><s:property value="date"/></p>
				</li>
			</s:iterator>
		</ul>
	</div>
	
</div>

<!-- 为了使用分页，include如下jsp -->
<%-- <%@ include file="/jsp/base/widgets/pagination.jsp" %> --%>

</layout:override>



<%@ include file="base.jsp" %>

