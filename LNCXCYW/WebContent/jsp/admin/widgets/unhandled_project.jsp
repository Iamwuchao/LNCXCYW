<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="mycontent">
 <div class="mycontent">
	<div id="classlist-content">
		<table class="classlist table table-bordered table-striped" id="user_messeage">
			<tr class="row">
				<th>标题</th>
				<th>类型</th>
				<th>状态</th>
				
				<th></th>
			</tr>	
			
			<s:iterator value="projectList" var="i" status="index">
				<tr class="row" id="<s:property value="#i.newsId"/>" >
					<td><s:property value="#i.newsTile" /></td>
					<td><s:property value="#i.category.newscategory" /></td>	
					<td> 
						<select class="judge" name="strValue">
							<option value="0">不通过</option>
							<option value="1">通过</option>
						</select>
					</td>	
					<td>
						<button type="button" class="btn btn-primary btn-sm ensure-button">确定</button>
					</td>	
				</tr>
			</s:iterator>		
			
			
			
				
		</table>
	</div>
</div>

<script>
$(".ensure-button").click(function(){
	var id=$(this).closest("tr").attr("id");
	var isPass=$(this).closest("td").prev().children("select").val();
	//alert(id+" "+isPass);
	//var isPass=$('#judge').find("option:selected").val();
	
 	$.ajax({
		url: '/admin/project_manage/request_ensure',
        type: 'post',
        dataType: 'json',
        data:{newsRowID:id,isPass:isPass},
        success:ensureCallBack
	}); 
})
	
function ensureCallBack(data){
	if(data.strValue=="success"){
		var t=$("#"+data.newsRowID);
		$("#"+data.newsRowID).remove();
	}
	else alert("something wrong!!");
}
</script>
	
</layout:override>


<%@ include file="/jsp/admin/project_manage.jsp" %>