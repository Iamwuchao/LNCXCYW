<%@ include file="/jsp/basepages/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/css/style02.css">
	<link href="/bootstrap/css/bootstrap.css" rel="stylesheet" />
	<!-- <script src="/jquery/jquery.min.js"></script> -->
	<script src="/js/base/jquery-2.1.4.min.js"></script>
</head>
<body>
<div class="main">
	<div class="splitterbars">
      <ul class="f_left">
      <a onclick="javascript:window.external.addFavorite('http://www.baidu.com','辽宁省大学生创新创业网')" 
      href="http://www.galyglj.cn">加入收藏 </a>|<a  onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.galyglj.cn');" href="http://www.galyglj.cn">设为首页</a>
      </ul>
	</div>

	<div class="logobox">
		<div class="logo">
			<span>&nbsp;&nbsp;&nbsp;<a href="http://en.dlut.edu.cn" target="_blank">ENGLISH</a></span> 
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
	<div class="con">
		<div class="content-left">
			<div class="head">
				<a href="/">首页></a>
				<a href="#">焦点图片
					<s:property value="category"/>  
				</a>
				<br/>
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
					<layout:block name="eve_push">
						
					</layout:block>
				</div>
			</div>

			<div class="inner-bottom">
			<p>焦点图片</p>
				<div class="deep-inner-bottom">
					<div class="left">
						<layout:block name="focus_left_picture">
							
						</layout:block>
							<!--  <img class="one" src="/images/Desert.jpg" alt="无法显示图片" width="165.5px" height="155px">
							<img class="two" src="/images/Desert.jpg" alt="无法显示图片" width="165.5px" height="155px">-->
					</div>
					
					<div class="right">
					<layout:block name="focus_right_picture">
							
						</layout:block>
					 <!--  	<img class="one" alt="图片无法显示" src="/images/Desert.jpg" width="165.5px" height="155px">
						<img class="two" alt="图片无法显示" src="/images/Desert.jpg" width="165.5px" height="155px"> -->
					</div>
					
				</div>
			</div>
		</div>	
	</div>

	<div class="bottom-wrap">
		<div id="bigDiver" class="bigDivider">
		</div>
		<div id="foot" class="foot">
		</div>
	</div>
</div>
</body>
</html>