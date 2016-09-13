<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="main_content">

<div class="mycontent">  
	<br>
	<br>
	<br>
	<br> 
	项目管理
	<button onclick="myProject()">我的项目</button>
	
	<div id="news_table">
		<%@ include file="/jsp/user/widgets/news_table.jsp" %>
	</div>

		
		
</div>

</layout:override>

<script>
	function myProject(){
		var authorId = document.getElementById("authorId").innerText;
		alert("id:"+authorId);
	
		$.ajax({
			url : '/user/myProject',
			type : 'post',
			dataType : 'json',
			data : {
				"authorId" : authorId,
			},
			success : submitCallback
		}); 
	}
	
	
	function submitCallback(data){
		$("#news_table").html(data.newsMessageTable);
	}

</script>

<%@ include file="/jsp/user/user.jsp" %>