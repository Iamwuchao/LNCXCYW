<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
		<div id="chooseExam">
			<table>
				<s:iterator value="examPaperList" var="i" status="index">
					<tr class="row" id=<s:property value="#i.id"/> >
						<%-- <td> <s:property value="#index.count"/> </td> --%>
						<td> <s:property value="%{i.getDescription())"/> </td>
						<td>
							<button type="button" class="btn btn-primary btn-sm ensure-button">确定</button>
						</td>
					</tr>	
			</s:iterator>
			</table>
		</div>
</div>
</layout:override>
<%@ include file="/jsp/third/base.jsp" %>