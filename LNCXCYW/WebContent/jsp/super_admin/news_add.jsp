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
		<s:select lable="test" list="categoryList" name="category"></s:select>  
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
		<button onclick="test()">test</button>
	</div>
		
</div>
<script>
	function test(){
		var test = $("#category").val();
		var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
	}
 
	function submit(){
		var title = $("#title").val();
		var category = $("#category").val();
		var author = $("#author").val();
		var content = UE.getEditor('editor').getContent();
		//alert(title+" "+classify+" "+author+" "+content);
		
		$.ajax({
			url : '/newsSubmit',
			type : 'post',
			dataType : 'json',
			data : {
				"title" : title,
				"category" : category,
				"author" : author,
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









</layout:override>

<%@ include file="/jsp/basepages/menu_base.jsp" %>