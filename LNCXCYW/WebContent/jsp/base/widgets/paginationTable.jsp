<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/basepages/taglib.jsp" %>


<nav>
	<ul class="pagination pagination-lg " >
		<li class="previous" ><a>current: <s:property value="currentPageNum"/></a></li>
		<li class="previous" ><a>total: <s:property value="totalPageNum"/></a></li>
	</ul>
</nav>



<nav>
	<ul class="pagination pagination-lg " >
		<s:if test="totalPageNum < 7">
			<s:iterator var="i" begin="1" end="totalPageNum" step="1">
				<li>
					<a requestPageNum=<s:property value="i"/> class="page-link"><s:property value="i"/></a>
				</li>
			</s:iterator> 
		</s:if>
		
		<s:else>
			<s:if test="currentPageNum <= 4">
				<s:iterator var="i" begin="1" end="@@min(6, totalPageNum)" step="1">
					<li><a requestPageNum=<s:property value="i"/> class="page-link"><s:property value="i"/></a></li>
				</s:iterator> 
				<s:if test="totalPageNum > 6">
					<li><a requestPageNum=totalPageNum class="page-link">...<s:property value="totalPageNum"/></a></li>
				</s:if>
			</s:if>	
			
			<s:else>
				<li><a requestPageNum=1 class="page-link">1...</a></li>
				<s:iterator var="i" begin="currentPageNum - 2" end="@@min(currentPageNum + 2, totalPageNum)" step="1">
					<li><a requestPageNum=<s:property value="i"/> class="page-link"><s:property value="i"/></a></li>
				</s:iterator> 
				
				<s:if test="currentPageNum + 2 < totalPageNum">
					<li><a requestPageNum=totalPageNum class="page-link">...<s:property value="totalPageNum"/></a></li>
				</s:if>			
			</s:else>		
		</s:else>
		
		
	</ul>
</nav>



