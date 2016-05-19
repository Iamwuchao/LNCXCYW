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
		success:emEvaInsertCallback
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
$(document).on("click","addEvalOption",addEvaOption);
//添加试卷评判标准
$(document).on("click","#addExamEva",function(){
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