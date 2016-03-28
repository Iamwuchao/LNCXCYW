<%@ include file="/jsp/basepages/taglib.jsp" %>
 <!-- <link href="dashboard.css" rel="stylesheet">  -->
<layout:override name="main_content">
<div class="mycontent">  
		
	<br>
	<br>
	<br>
	<br>
	<div>
		标题
		<input type="text" id="title">
	</div>
	<div>
		分类
		<input type="text" id="classify"> 
	</div>
	<div>
		作者
		<input type="text" id="author"> 
	</div>	
	<div>
		<%@ include file="/UEditor/ueditor.jsp" %>
	</div>	
	<br>
	<br>
	<br>
	<br>
	<div>
		<button onclick="submit()">提交</button>
	</div>
		
</div>
<script>
	function submit(){
		var title = $("#title").val();
		var classify = $("#classify").val();
		var author = $("#author").val();
		var content = UE.getEditor('editor').getContent();
		alert(title+" "+classify+" "+author+" "+content);
		
		$.ajax({
			url : '/newsSubmit',
			type : 'post',
			dataType : 'json',
			data : {
				"title" : title,
				"classify" : classify,
				"author" : author,
				"content" : content,
			},
			success : submitCallback
		});
	}
	
	function submitCallback(data){
		alert("callback");
	}
</script>









</layout:override>

<%@ include file="super_base.jsp" %>