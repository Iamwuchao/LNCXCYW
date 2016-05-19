<%@ include file="/jsp/basepages/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

<div class="splitterbars">
      <ul class="f_left">
      <a onclick="javascript:window.external.addFavorite('http://www.baidu.com','辽宁省大学生创新创业网')" 
      href="http://www.localhost:8080.cn">加入收藏 </a>|<a  onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.localhost:8080');" href="http://www.localhost:8080">设为首页</a>
      </ul>
</div>
<div class="logobox">
<div class="logo">
	<img src="/images/2Dcode.jpg"  height="60px" width="60px"/>
	<span>&nbsp;&nbsp;&nbsp;<a href="/jsp/homepage/login.jsp" target="_blank">登录&nbsp;|&nbsp;</a><a href="/jsp/homepage/regist.jsp" target="_blank">注册</a></span> 
</div>
<div class="splitterbars"></div>
<div class="nav">
<ul class="nav_all" >
<li><a href="/">首页</a></li>
<li><a href="/second_page?category=创新创业资讯">创新创业资讯</a></li>
<li><a href="/second_page?category=创新创业训练">创新创业训练</a></li>
<li><a href="/second_page?category=创新创业竞赛">创新创业竞赛</a></li>
<li><a href="/second_page?category=创新创业资源">创新创业资源</a></li>
<li><a href="/second_page?category=创新创业成果">创新创业成果</a></li>
<li><a href="/second_page?category=资料下载">资料下载</a></li>
</ul>
</div>
</div>
<div id="content">
	<layout:block name="base_content">
				
	</layout:block>
</div>
<div id="bigDiver" class="bigDivider">
		</div>
		<div id="foot" class="foot">
		</div>
</body>
</html>