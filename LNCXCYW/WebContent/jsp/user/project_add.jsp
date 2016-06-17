<%@ include file="/jsp/basepages/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type='text/javascript' src="/js/base/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/UEditor/ueditor.config.js"></script>
   	<script type="text/javascript" charset="utf-8" src="/UEditor/ueditor.all.min.js"> </script>	
</head>
<div class="mycontent">  
		
	<br>
	<br>
	<br>
	<br>
	<div>
		标题	<input type="text" id="title">
	</div>
	<div>
		分类		
		<select class="judge" name="category">
			<option value="0">项目推介</option>
			<option value="1">企业需求</option>
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

<script>
	function test(){
		var title = $("#title").val();
		var category = $("#category").val();
		var author = $("#author").val();
		var source = $("#source").val();
		var content = UE.getEditor('editor').getContent();
		alert(title+" "+author+" "+content+" "+source);
	}
 
	function submit(){
		var title = $("#title").val();
		var category = $("#category").val();
		var author = $("#author").val();
		var source = $("#source").val();
		var content = UE.getEditor('editor').getContent();
		//alert(title+" "+author+" "+content+" "+source);
		
		$.ajax({
			url : '/newsSubmit',
			type : 'post',
			dataType : 'json',
			data : {
				"title" : title,
				"category" : category,
				"author" : author,
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


</html>