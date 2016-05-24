<%@ include file="/jsp/basepages/taglib.jsp" %>
 <!-- <link href="dashboard.css" rel="stylesheet">  -->
<layout:override name="main_content">
	<!-- <script type='text/javascript' src="/js/admin/teachbuilding.js"></script> -->
	
	<div class="mycontent">  
		<style type="text/css">
	.modal-header{
		width:70%;
		margin:0 auto;
	}
	h2{
		background:rgb(0,114,227);
		border-radius:5px;
		color:#fff;
		height:45px;
		display:block;
	}
	.modal-body{
		width:100%;
		background:rgb(238,238,238);
		border-radius:5px;
		padding:10px 5%;
	}
	.modal-footer{
		width:100%;
		background:rgb(238,238,238);
		border-top:none;
	}
	.form-group{
		margin-bottom:0px;
	}
</style>
<!-- 添加的题目的类型 -->
		 <select id="categoryListSel" name="categoryList"> 
			<s:iterator value="categoryList" id="categoryList" var="i">
			<option value=<s:property value="#i"  />><s:property value="#i"  /></option>		
			</s:iterator>
				
		</select>
		<%-- <s:select list="categoryList" id="categoryList" name="categoryList"
			listValue="category" listKey="paperCategoryList.categoryId"
			theme="simple"></s:select>  --%>
		<!-- Button trigger modal -->
<button type="button" id="addExam" class="btn btn-primary btn-lg">添加题目</button>
<button type="button" id="addExamEva" class="btn btn-primary btn-lg">添加试卷评判标准</button>
<button type="button" id="addExamDesc" class="btn btn-primary btn-lg">添加试卷评判描述</button>
<button type="button" id="showExam" class="btn btn-primary btn-lg">题目预览</button>
<!-- 文本编辑框 -->
<div id="emModal" style="display:none;">
	<div class="modal-header">
    	<h2 class="modal-title" id="myModalLabel">添加题目</h2>
	</div>
	
	<div class="modal-body"align="center">
		<b>题目描述 </b>
		<form id="exam_form" titleId>
			<div id="titleInput">
				<%@ include file="/UEditor/ueditor.jsp"%>
				<!-- %@ include file="/bootstrap-wysiwyg/editor.jsp" %-->				
			</div>
			
			<br/>
			
			<!-- <span style="color:red">请勾选正确选项</span> -->
			
			<div style="display:none" class="option">
			 	<div class="form-inline form-group toc optionContent" id="optionLine">
			  		<!-- <input type="checkbox" class="optionCheck"> -->
			    	<label for="optionInput">选项:</label>
			    	<textarea class="form-control optionInput" id="optionInput" rows="2" cols="100" placeholder="选项内容"></textarea>
			    	<input type="text"  class="form-control optionCheck" placeholder="请填入该选项的权值" value="5" id="optionCheck" >
			    	<button type="button" class="btn btn-primary" id="optionRemove"> 移除</button>
			 	</div>
			 </div>
			<br>
		</form>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="addOption">添加选项</button>
    	<button type="button" class="btn btn-default" id="close" data-dismiss="modal">关闭</button>
    	<button type="button" class="btn btn-primary" id="examInsert" >保存</button>
	</div>
</div>




<!-- 添加试卷评判标准文本编辑框 -->
<div id="emEvaModal" style="display:none;">
	<div class="modal-header">
    	<h2 class="modal-title" id="myEvaModalLabel">添加试卷评判标准</h2>
	</div>
	
	<div class="modal-body"align="center">
		
		<form id="examEva_form" >
			
			<br/>
			
			
			
			<div style="display:none" class="evaOption">
			 	<div class="form-inline form-group toc evaOptionContent" id="evaOptionLine">
			  		<!-- <input type="checkbox" class="optionCheck"> -->
			    	<label for="evaOptionInput">评判标准:</label>
			    	<textarea class="form-control evaOptionInput" id="evaOptionInput" rows="3" cols="80" placeholder="评价描述"></textarea>
			    	<input type="number"  class="form-control evaLowCheck" placeholder="分数段下限"  id="evaLowCheck" >
			    	<input type="number"  class="form-control evaHighCheck" placeholder="分数段上限"  id="evaHighCheck" >
			    	<button type="button" class="btn btn-primary" id="evaOptionRemove"> 移除</button>
			 	</div>
			 </div>
			<br>
		</form>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="addEvaOption">添加选项</button>
    	<button type="button" class="btn btn-default" id="closeEva" data-dismiss="modal">关闭</button>
    	<button type="button" class="btn btn-primary" id="examEvaInsert" >保存</button>
	</div>
</div>


<!-- 添加试卷描述文本编辑框 -->
<div id="emEvaModal" style="display:none;">
	<div class="modal-header">
    	<h2 class="modal-title" id="myEvaModalLabel">添加试卷评判标准</h2>
	</div>
	
	<div class="modal-body"align="center">
		
		<form id="examEva_form" >
			
			<br/>
			
			
			
			<div style="display:none" class="evaOption">
			 	<div class="form-inline form-group toc evaOptionContent" id="evaOptionLine">
			  		<!-- <input type="checkbox" class="optionCheck"> -->
			    	<label for="evaOptionInput">评判标准:</label>
			    	<textarea class="form-control evaOptionInput" id="evaOptionInput" rows="3" cols="80" placeholder="评价描述"></textarea>
			    	<input type="number"  class="form-control evaLowCheck" placeholder="分数段下限"  id="evaLowCheck" >
			    	<input type="number"  class="form-control evaHighCheck" placeholder="分数段上限"  id="evaHighCheck" >
			    	<button type="button" class="btn btn-primary" id="evaOptionRemove"> 移除</button>
			 	</div>
			 </div>
			<br>
		</form>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-primary" id="addEvaOption">添加选项</button>
    	<button type="button" class="btn btn-default" id="closeEva" data-dismiss="modal">关闭</button>
    	<button type="button" class="btn btn-primary" id="examEvaInsert" >保存</button>
	</div>
</div>
<br/>

<br/>

<div id="examTableDiv"  style="display:none;">
	<%@ include file="/jsp/admin/widgets/examManageTable.jsp" %>
</div>


<script type='text/javascript' src="/js/base/bootstrap-wysiwyg.js"></script>
<!-- <script type="text/javascript" src="/jsp/admin/examManage.js"></script> -->
<script>
	


	var optionHtml = $(".option").html();
	$(".option").remove();
	
	// clear modal
	function clearModal(){
// 		$("#titleInput").val("");
		//$(".editor").html("");
		UE.getEditor('editor').setContent("", '');
		$(".optionContent").each(function(){
			$(this).remove();
		})
	}
	var id='A';
	function addOption(){
		code = id.charCodeAt();
		id = String.fromCharCode(++code);
		$("#exam_form").append(optionHtml);
	}

	//remove
	$(document).on("click", "#optionRemove", function(){
		$(this).parents("#optionLine").remove();
	})
	
	//exam insert
	function insertTitle(){
		
		var params = getParams();
		$.ajax({
			url : 'examTitleAdd',
			type : 'post',
			dataType : 'json',
			data : params,
			traditional : true,
			success : emInsertCallback
		});
	}
	
	function emInsertCallback(data){
		if(data.status == "1") {
			$(document).find("#examTableDiv").html(data.exam_table);
			$('#examTableDiv').css("display","inline");
			$('#emModal').css("display","none");
			alert("插入成功！ ");
		}
		else if(data.status == "2") {
			$(document).find("#examTableDiv").html(data.exam_table);
			$('#examTableDiv').css("display","inline");
			$('#emModal').css("display","none");
			
			//alert("插入成功！ ");
		}
		else if(data.status == "3") {
			/* $(document).find("#examTableDiv").html(data.exam_table);
			$('#examTableDiv').css("display","inline"); */
			$('#emModal').css("display","none");
			$('#emEvaModal').css("display","none");
			
			alert("评价标准插入成功！ ");
		}
	}
	
	//delete
	var delete_emId
	$(document).on("click",".delete",function(){
		var temp = confirm("删除不可恢复！");
		if(temp == true){
			var temp = $(this).parents("tr");
			console.log(temp);
			delete_emId = temp.children().eq(0).text();
			console.log(delete_emId);
			$(temp).attr("emid", delete_emId);
			$.ajax({
				url : 'training_examDelete',
				type : 'post',
				dataType : 'json',
				data : {"emId" : delete_emId,},// {"后台",""}
				success : emDeleteCallback
			});
		}
	})
	function emDeleteCallback(data){
		//alert("ok!!!!");
		if (data.trStatus == "0") {
			alert("删除数据不存在！ ");
		} else if (data.trStatus == "1") {
			$(document).find("tr[emid=" + delete_emId + "]").remove();
		}
	}
	
	//close
	$(document).on("click","#close",function(){
		clearModal();
		$('#emModal').css("display","none");
	})
	
	// open edit title
	$(document).on("click", ".edit", function(){
		clearModal();
		$('#emModal').find(".modal-title").html("编辑题目");
		var tr = $(this).parent().parent();
		var optionList = $(tr).find(".optionList")[0];

		optionList = $(optionList).find("div");
// 		$("#titleInput").val($(tr).find(".titleContent").html());
		//$("#titleInput .editor").html($(tr).find(".titleContent").html());
		UE.getEditor('editor').setContent($(tr).find(".titleContent").html(), '');
		$("#exam_form").attr("titleId", $(tr).attr("titleId"));
		$(optionList).each(function(){
			
			var isRight = $(this).attr("isRight");//每个选项的权值
			addOption();
			var cntOption = $(".optionContent:last");
			$(cntOption).find(".optionInput").val($(this).attr("optionText"));			
			/* if(isRight == "true")
			{				
				
				$(cntOption).find(".optionCheck").attr("checked",true);
			}
			else
			{
				$(cntOption).find(".optionCheck").attr("checked",false);
			} */
		})
		$('#emModal').css("display","block");
		
	})
	
	
	
	
	// save edit Title
	function editTitle() {
		$('#emModal').css("display","none");
		var titleId = $("#exam_form").attr("titleId");		
		
		var params = getParams();
		params = $.extend(params, {"emId": titleId});
		$.ajax({
			url : 'training_examEdit',
			type : 'post',
			dataType : 'json',
			data : params,
			traditional : true,
			success : editTitleCallBack
		});
	}
	
	function editTitleCallBack(data){
		if(data.status == "1") {
			$(document).find("#examTableDiv").html(data.exam_table);
			$('#examTableDiv').css("display","inline");
			alert("更改成功！ ");
		}
	}
	
	
	
	
	
	// add option	
	$(document).on("click", "#addOption",addOption );
	
	$(document).on("click", "#testButton", function(){
		var checkList = document.getElementsByClassName("optionContent");
		for(var i = 0; i < checkList.length; ++ i)
		{
			alert(checkList[i].getElementsByClassName("optionCheck")[0].checked);
		}
	})
	
	
	
	
	$(document).on("click","#addExam",function(){
		$('#emEvaModal').css("display","none");
		$('#emModal').css('display','block');
		$('#emModal').find(".modal-title").html("新增题目");
		clearModal();
	})
	
	
	$(document).on("click", "#examInsert", function(){
		var judge = $('#emModal').find(".modal-title").html();
		if(judge == "编辑题目")
		{
			editTitle();
		}
		else insertTitle();
	})
	
	// from modal  get params
	function getParams()
	{
		//var emTextarea = $("#titleInput .editor").html();
		//var emTextarea = UE.getEditor('editor').getContent();
		var emTextarea = UE.getEditor('editor').getContentTxt();
		var optionList = new Array();
		$(".optionContent #optionInput").each(function(){
			optionList.push($(this).val());
		})
		
		var findList = document.getElementsByClassName("optionContent");
		var checkList = new Array();
		
	 	$(".optionContent #optionCheck").each(function(){
	 		checkList.push($(this).val());
		})
		 
		/* for(var i = 0; i < findList.length; ++ i)
		{
			
			alert("9999000");
			var temp = findList[i].getElementsByClassName("optionCheck")[0].val();
			alert("temp is");
			checkList.push(temp);
		} */
		
		
		/* 试卷类型 */
		paperCatogery = $("#categoryListSel option:selected").val();
		var params = {
				"title" : emTextarea,
				"optionList" : optionList,
				"checkList" : checkList,
				"category":paperCatogery
		};
		return params;

	}
	

	
	
	
	/**
	 * 与试卷评判部分有关的js
	 */
	var evaOptionHtml = $(".evaOption").html();
	
	$(".evaOption").remove();
	//清除编辑评价所有内容
	function clear(){
		$(".evaOptionContent").each(function(){
			$(this).remove();
		})}
	//新增分数段评价
	function addEvaOption(){
		//alert(evaOptionHtml);
		
			$("#examEva_form").append(evaOptionHtml);
		}
	//将当前的分数段编辑移除
	$(document).on("click","#evaOptionRemove",function(){
		$(this).parents("#evaOptionLine").remove();
	})
	//试卷评价插入
	function insertEva(){
		var params = getEvaParams();
		$.ajax({
			url:'examEvaAdd',
			type:'post',
			dataType:'json',
			data:params,
			traditional:true,
			success:emInsertCallback
		});
	}
	//插入试卷评价成功的回调函数
	function emEvaInsertCallback(data){
		if(data.status == "1") {
			//$(document).find("#examTableDiv").html(data.exam_table);
			$('#emEvaModal').css("display","none");
			alert("插入成功！ ");
		}
	}
	//点击“关闭”
	$(document).on("click","#closeEva",function(){
		clear();
		$('#emEvaModal').css("display","none");
	})
	//添加分数段
	$(document).on("click","#addEvaOption",addEvaOption);
	//添加试卷评判标准
	$(document).on("click","#addExamEva",function(){
		$('#examTableDiv').css("display","none");
		$('#emModal').css('display','none');
		$('#emEvaModal').css('display','block');
		$('#emEvaModal').find(".modal-title").html("添加试卷评判标准");
		clear();
	})
	//“保存”
	$(document).on("click", "#examEvaInsert", function(){
			var judge = $('#emEvaModal').find(".modal-title").html();
			if(judge == "编辑试卷评判标准")
			{
				//editTitle();
			}
			else insertEva();
		})

	function getEvaParams(){
		var emEvaDesList = new Array();
		var emEvaLowList = new Array();
		var emEvaHighList = new Array();
		var paperCatogery = $("#categoryListSel option:selected").val();
		$(".evaOptionContent #evaOptionInput").each(function(){
			emEvaDesList.push($(this).val());
		})
		$(".evaOptionContent #evaLowCheck").each(function(){
			emEvaLowList.push($(this).val());
		})
		$(".evaOptionContent #evaHighCheck").each(function(){
			emEvaHighList.push($(this).val());
		})
		var params = {
			"emEvaDesList": emEvaDesList,
			"emEvaLowList":emEvaLowList,
			"emEvaHighList":emEvaHighList,
			"category":paperCatogery
		};
		return params;
		
	}
	
	
	/* 题目预览 */
	$(document).on("click","#showExam",function(){
		var paperCatogery = $("#categoryListSel option:selected").val();
		alert(paperCatogery);
		$.ajax({
			url : 'examPreshow',
			type : 'post',
			dataType : 'json',
			data : {
				category:paperCatogery
			},
			traditional : true,
			success : emInsertCallback
		});
	})
</script>

		

	 </div>  

</layout:override>

<%@ include file="/jsp/basepages/menu_base.jsp" %>