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
	<br>

	
	<div>
		新闻链接	<input type="text" id="pictureLink"> 
	</div>	
	<br>

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
		var category = "图片新闻链接";
		var pictureLink = $("#pictureLink").val();
		var content = UE.getEditor('editor').getContent();
		alert(category+""+pictureLink);
	}
 
	function submit(){
		var title = $("#title").val();
		var category = "图片新闻链接";
		var pictureLink = $("#pictureLink").val();
		var content = UE.getEditor('editor').getContent();
		//alert(title+" "+author+" "+content+" "+source);
		
		$.ajax({
			url : '/newsSubmit',
			type : 'post',
			dataType : 'json',
			data : {
				"title" : title,
				"category" : category,
				"content" : content,
				"pictureLink" : pictureLink,
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



<%@ include file="/jsp/basepages/menu_base.jsp" %>