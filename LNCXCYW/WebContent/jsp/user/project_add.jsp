<%@ include file="/jsp/basepages/taglib.jsp" %>

<layout:override name="main_content">

<div class="mycontent">  
	<a href="#"></a>
	
	<div id="authorId" value=<s:property value="#session.user.userId"/>></div>
	
	
	
	<br>
	<br>
	<br>
	<br>
	<div>
		标题	<input type="text" id="title">
	</div>
	<div>
		分类		
		<select class="judge" id="category">
			<option value="项目推介">项目推介</option>
			<option value="企业需求">企业需求</option>
		</select>
	</div>

	<div>
		来源	<input type="text" id="source"> 
	</div>		

	
	<div>
		作者	<input type="text" id="author"> 
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
		<button onclick="test()">test</button>
	</div>
		
</div>

</layout:override>


<script>
	function test(){
		var title = $("#title").val();
		var category = $("#category").val();
		var author = $("#author").val();
		var source = $("#source").val();
		var content = UE.getEditor('editor').getContent();
		var authorId = document.getElementById("authorId").getAttribute('value');
		alert(uathorId);
	}
 
	function submit(){
		var title = $("#title").val();
		var category = $("#category").val();
		var author = $("#author").val();
		var source = $("#source").val();
		var content = UE.getEditor('editor').getContent();
		var authorId = document.getElementById("authorId").getAttribute('value');
		//alert(title+" "+author+" "+content+" "+source);
		
		$.ajax({
			url : '/newsSubmit',
			type : 'post',
			dataType : 'json',
			data : {
				"title" : title,
				"category" : category,
				"author" : author,
				"authorId" : authorId,
				"source" : source,
				"content" : content,
			},
			success : submitCallback
		});
	}
	
	function submitCallback(data){
		if(data.status=="1"){
			alert("添加失败");
		}else{
			alert("添加成功！");
			location.reload();
		}
	}
</script>



<%@ include file="/jsp/user/user.jsp" %>