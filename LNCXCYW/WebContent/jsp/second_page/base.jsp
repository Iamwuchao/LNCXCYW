<%@ include file="/jsp/basepages/taglib.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/style02.css">
<title>Insert title here</title>
</head>
<body>
	<div class="main">
		<div class="splitterbars">
      		<ul class="f_left">
      			<a onclick="javascript:window.external.addFavorite('http://www.baidu.com','辽宁省大学生创新创业网')" 
      				href="http://www.galyglj.cn">加入收藏 </a>|<a  onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.galyglj.cn');" href="http://www.galyglj.cn">设为首页</a>
      		</ul>
		</div>

	<!--  	<div class="logobox">
			<div class="logo">
				<span>&nbsp;&nbsp;&nbsp;<a href="http://en.dlut.edu.cn" target="_blank">ENGLISH</a></span> 
			</div>
			<div class="splitterbars"></div>
			<div class="nav">
				<ul class="nav_all" >
					<li><a href="#">首页</a></li>
					<li><a>创新创业资讯</a></li>
					<li><a>创新创业训练</a></li>
					<li><a>创新创业竞赛</a></li>
					<li><a>创新创业资源</a></li>
					<li><a>创新创业成果</a></li>
					<li><a>资料下载</a></li>
				</ul>
			</div>
		</div>-->
	<div class="logobox">
		<div class="logo">
			<img src="/images/2Dcode.jpg"  height="60px" width="60px"/>
			<span>&nbsp;&nbsp;&nbsp;<a href="/jsp/homepage/login.jsp" target="_blank">登录&nbsp;|&nbsp;</a><a href="/jsp/homepage/regist.jsp" target="_blank">注册</a></span> 
		</div>
		<div class="splitterbars"></div>
		<div class="nav">
			<ul class="nav_all" >
			<li><a href="#">首页</a></li>
			<li><a>创新创业资讯</a></li>
			<li><a>创新创业训练</a></li>
			<li><a>创新创业竞赛</a></li>
			<li><a>创新创业资源</a></li>
			<li><a>创新创业成果</a></li>
			<li><a>资料下载</a></li>
			</ul>
		</div>
	</div>
		<div class="con">
			<div class="content-left">
				<div class="head">
					<layout:block name="content-left-head">
					
					
					
					</layout:block>
				</div>
				<div class="inner">
					<layout:block name="content-left-inner">
					
					
					
					</layout:block>
				</div>
			
			</div>
			<div class="content-right">
				<div class="inner-top">
					<div class="deep-inner-top">
						<layout:block name="content-right-top">
						
						
						
						</layout:block>
					</div>
				</div>

				<div class="inner-bottom">
					<div class="deep-inner-bottom">
						<layout:block name="content-right-bottom">
						
						
						
						</layout:block>
					</div>
				</div>
			</div>	
		</div>
	</div>
	<div id="bigDiver" class="bigDivider">
	</div>
	<div id="foot" class="foot">
	</div>
</body>
</html>