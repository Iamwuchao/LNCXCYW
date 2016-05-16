<%@ include file="/jsp/basepages/taglib.jsp" %>
<table class="table table-bordered" id="exam_table">
	<tr class="active">
		<th style="display:none;">编号</th>
		<th>题目</th>
		<th>选项</th>
		<!-- <th>操作</th> -->
	</tr>
	
	<%--   <s:iterator value="qtitle" var="i"  begin="0" end="qtitle.size()-1" step="1"> --%>
		  <s:iterator  var="i" begin="0" end="qtitle.size()-1" step="1" >
		<tr class="danger" titleId=<s:property value="qtitle.get(#i).emTitleId" />>
			<td style="display:none;"><s:property value="qtitle.get(#i).emTitleId" /></td>
			
			<td class="titleContent"><s:property value="qtitle.get(#i).emTitle" escape="false"/></td>
			
			<td class="optionList">
				<s:iterator  var="j" begin="0" end="qoption.get(#i).size() - 1" step="1">
				<div isRight='<s:property value="qoption.get(#i).get(#j).emOptionWeight" />'
					     optionText='<s:property value="qoption.get(#i).get(#j).emOption" />' >
					
					
					
					<s:property value="qoption.get(#i).get(#j).emStrID" />.
						<s:property value="qoption.get(#i).get(#j).emOption" />
						(<s:property value="qoption.get(#i).get(#j).emOptionWeight" />)
					</div>
				</s:iterator>
			</td>
			
			<!-- <td>
				<button type="button" class="btn btn-success edit">编辑</button>&nbsp;&nbsp;
				<button type="button" class="btn btn-danger delete">删除</button>
			</td> -->
		</tr>
	</s:iterator>  
  	
</table>