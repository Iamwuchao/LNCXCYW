<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
		<div id="chooseExam">
			<table>
				<s:iterator value="examPaperList" var="i" status="index">
					<tr class="row" id=<s:property value="#i.id"/> >
						<%-- <td> <s:property value="#index.count"/> </td> --%>
						<td> <s:property value="#i.description"/> </td>
						<td>
							<button type="button" class="btn btn-primary btn-sm ensure-button">确定</button>
						</td>
					</tr>	
				</s:iterator>
			</table>
		</div>
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
       <img class="one" src="<s:property value="%{pictureNewsList.get(0).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(0).newsTile}"/>" width="165.5px" height="155px">
       <img class="two" src="<s:property value="%{pictureNewsList.get(1).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(1).newsTile}"/>" width="165.5px" height="155px">
</layout:override>
<layout:override name="focus_right_picture">
	   <img class="one" src="<s:property value="%{pictureNewsList.get(2).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(2).newsTile}"/>" width="165.5px" height="155px">
       <img class="two" src="<s:property value="%{pictureNewsList.get(3).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(3).newsTile}"/>" width="165.5px" height="155px">
</layout:override>
<%@ include file="/jsp/third/base.jsp" %>