<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/basepages/taglib.jsp" %>



<div id="paginationTableDiv">

<%@ include file="/jsp/base/widgets/paginationTable.jsp" %>

</div>
<script> 


// var pageAddtionalData = {}
alert("hello");
$("#firstPage").click(function(){
	alert("sdfwef");
});
$(document).on("click","#firstPage",  function(){
    alert("hello");
	sendRequestPage(1);
});
$(document).on("click","#lastPage",  function(){
    sendRequestPage($(this).attr("totalPageNum"));
});

// $(document).on("click",".page-link",  function(){
// 	alert("hell");
//     sendRequestPage($(this).attr("requestPageNum"));
// });

$("span").on("click",function(){
	alert("hell");
});

var paginationURL='';
function sendRequestPage(currentPageNum) {
	var data = {"currentPageNum": currentPageNum , "isAjaxTransmission":true, };
	
	if(typeof(pageAddtionalData)!="undefined")
		data = $.extend({}, data, pageAddtionalData);
    $.ajax({
        url: paginationURL,
        type: 'post',
        dataType: 'json',
        data: data,
        success: _requestPageCallback,
        error: requesterror
      });	
}

function _requestPageCallback(data) {
	$("#paginationTableDiv").html(data.paginationHtml);
	requestPageCallback(data);
}

function requesterror(data){
	alert("error");
}
</script>





