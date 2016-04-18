<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/basepages/taglib.jsp" %>



<%@ include file="/jsp/base/widgets/paginationTable.jsp" %>


<script type="text/javascript" src="/js/base/jquery-2.1.4.min.js" ></script>

<script> 
$(document).on("click","#firstPage",  function(){
	sendRequestPage(1);
});
$(document).on("click","#lastPage",  function(){
    sendRequestPage($(this).attr("totalPageNum"));
});

$(document).on("click",".page-link",  function(){
    sendRequestPage($(this).attr("requestPageNum"));
});

$("span").on("click",function(){
	alert("hell");
});

var paginationURL='news_page';
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
	$("#paginationTableDiv").html(data.news_list_html);
}

function requesterror(data){
	alert("error");
}
</script>





