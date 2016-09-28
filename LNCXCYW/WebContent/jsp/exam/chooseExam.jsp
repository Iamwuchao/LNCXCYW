<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
		<div id="chooseExam">
			<table class="table table-bordered">
				<s:iterator value="examPaperList" var="i" status="index">
					<tr class="row" id=<s:property value="#i.id"/> >
						<td> <s:property value="#i.name"/> </td>
						<td>
							<a href="/showExam?paperName=<s:property value="#i.name"/>"><button type="button" class="btn btn-primary btn-sm ensure-button">确定</button></a>
						</td>
					</tr>	
				</s:iterator>
			</table>
		</div>
</div>
</layout:override>


<%@ include file="/jsp/third/base.jsp" %>
