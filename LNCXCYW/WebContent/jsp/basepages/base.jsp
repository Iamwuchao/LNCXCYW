<%@ include file="/jsp/basepages/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!--  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">-->
<link href="/css/style.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/jquery/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/main.js"></script>
<script type="text/javascript">
	$('.carousel').carousel({
	  interval: 2000
	})
</script>
<title>辽宁省创新创业教育网</title>
</head>
<body>

<div>
	<%@ include file="/jsp/base/widgets/top_bar.jsp" %>
</div>



<div id="content">
	<layout:block name="base_content">
				
	</layout:block>
</div>
<div id="bigDiver" class="bigDivider">
</div>

<div ><!-- 相关连接  直接引用-->
	<%@ include file="/jsp/base/widgets/link.jsp" %>
</div>
</body>
<script>
$("#news_search_by_title").click(function(){
	var keyWords = $("#keyWords").val();
	alert(keyWords)
	window.location.href = "/news_search_by_title?keyWords="+keyWords;
	return ;
})

</script>
</html>
