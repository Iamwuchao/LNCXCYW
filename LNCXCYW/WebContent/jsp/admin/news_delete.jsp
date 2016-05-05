<%@ include file="/jsp/basepages/taglib.jsp" %>
 <!-- <link href="dashboard.css" rel="stylesheet">  -->
<layout:override name="main_content">
<div class="mycontent">  
<form class="form-horizontal" id="news_search_form">
			<div class="form-horizontal">
				<div class="form-group">

					
					<label class="col-lg-2 control-label" style="margin: 2px">按标题查询：</label>

					<div class="col-lg-2">
						<input type="text" class="col-lg-3 form-control"
							style="margin: 3px; height: 34px;"
							aria-describedby="basic-addon1" name="keyWords" id="keyWords">
					</div>

					<div class="col-lg-1">
						<button type="button" class="btn btn-primary" style="margin: 2px;"
							id="news_search_by_title">查&nbsp;&nbsp;询</button>
					</div>
				</div>
			</div>
			<div class="form-horizontal">
				<div class="form-group">

					<label class="col-lg-2 control-label" style="margin: 2px">按时间查询：</label>
					

					<div class="col-lg-2">
						<input class="form-control" type='date' id="inputBeginDate" >
					</div>
					
					<div class="col-lg-2">
						<input class="form-control" type='date' id="inputEndDate" >
					</div>
					
					<div class="col-lg-1">
						<button type="button" class="btn btn-primary" style="margin: 2px;"
							id="news_search_by_time">查&nbsp;&nbsp;询</button>
					</div>
				</div>
			</div>
		</form>

	<div id="news_messeage_table">
			<%@ include file="/jsp/admin/widgets/news_message_table.jsp" %>
		</div>
		
		
		
</div>
		
<script>
$("#news_search_by_title").click(function(){
	var keyWords = $("#keyWords").val();
	$.ajax({
		url : '/admin/news_manage/news_search_by_title',
		type : 'post',
		dataType : 'json',
		data : {
			keyWords : keyWords
		},
		success : searchCallback,
		error : errorSolution
	}); 
})
$("#news_search_by_time").click(function(){
	var startDate = $("#inputBeginDate").val();
	var endDate = $("#inputEndDate").val();
	$.ajax({
		url : '/admin/news_manage/news_search_by_time',
		type : 'post',
		dataType : 'json',
		data : {
			startDate : startDate,
			endDate : endDate
		},
		success : searchCallback,
		error : errorSolution
	}); 
})

$(".ensure-button").click(function() {
	alert(0009);		
	var newsId = $(this).closest("tr").attr("id");
			alert(newsId);

			$.ajax({
				url : '/admin/news_manage/news_delete',
				type : 'post',
				dataType : 'json',
				data : {
					newsId : newsId
				},
				success : searchCallback,
				error : errorSolution
			}); 
		})

		function errorSolution(data){
			alert("error");
		}
		function ensureCallBack(data) {
			/* if (data.strValue == "success") {
				var t = $("#" + data.userId);
				$("#" + data.userId).remove();
			} else*/
				alert("something wrong!!"); 
		}
function searchCallback(data) {
	if(data.status == "1"){
		
		$("#news_messeage_table").html(data.newsMessageTable);
	}	
	else{
		alert("没有符合条件的查询结果！");
		location.reload();
	}
}
	</script>	
		
</layout:override>
<%@ include file="/jsp/basepages/menu_base.jsp" %>