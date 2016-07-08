<%@ include file="/jsp/basepages/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<link rel="stylesheet" type="text/css" href="/css/style02.css">
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet" />
<script src="/js/base/jquery-2.1.4.min.js"></script>
</head>


<body>
	<div class="main">
		<div>
			<%@ include file="/jsp/base/widgets/top_bar.jsp"%>
		</div>

		<div class="con">
			<div class="content-left">
				<div class="head">
					<a href="/">首页></a> <a
						href="/second_page?category=<s:property value="category"/>"> <s:property
							value="category" />
					</a> <br />
					<hr size="3" color="#195591">
				</div>
				<div class="inner">
					<layout:block name="news_content">
					</layout:block>
				</div>
			</div>
			
			<div class="content-right">
				<div class="inner-top">
					<p>每日推荐</p>
					<div class="deep-inner-top recommend">
						<%@ include file="/jsp/third/even_push.jsp"%>
					</div>
				</div>

				<div class="inner-bottom">
					<p>焦点图片</p>
					<div class="deep-inner-bottom">
						<div class="left">
							<layout:block name="focus_left_picture">
							</layout:block>							
						</div>
						<div class="right">
							<layout:block name="focus_right_picture">
							</layout:block>			
						</div>
					</div>
				</div>
				<div class="inner-hot">
					<p>排行榜</p>
					<div class="deep-inner-hot recommend">
						<%@ include file="/jsp/third/hotest_news.jsp"%>
					</div>
				</div>
			</div>
		</div>

		<div class="bottom-wrap">
			<div id="bigDiver" class="bigDivider"></div>
			<div>
				<!-- 相关连接  直接引用-->
				<%@ include file="/jsp/base/widgets/link.jsp"%>
			</div>
		</div>
	</div>

</body>
<script>
	$("#news_search_by_title").click(function() {
		/* alert(99); */
		var keyWords = $("#keyWords").val();
		/* alert(keyWords) */
		// 	window.location.href = "http://baidu.com"
		window.location.href = "/news_search_by_title?keyWords=" + keyWords;
		return;

	})
</script>
</html>
