<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/basepages/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/css/style02.css">
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
				<p>首页>创新创业资讯>综合新闻</p>
				<br/>
				<hr size="3" color="#195591">
			</div>
			<s:iterator value="news_list" var="i" status="index">
			<div class="inner">
				
				<ul>
					<li>
						<a>
							<s:property value="#i.author"/>
						</a>
					</li>
					<!-- <li><a href="#">【组图】“双代会”上的表情包</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【教代会】部院回眸</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 17:08</time></li>
					<li><a href="#">学校召开本科教学工作会议倡导优势专业建设</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 16:56</time></li>
					<li><a href="#">西南政法大学副教授校长刘想树一行访问我校</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 16:56</time></li>
					<li><a href="#">英国莱斯特大学代表团访问盘锦校区</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月8日 13:05</time></li>
					<li><a href="#">卓越大学联盟暨辽宁省高校专业认证研讨交流会举办</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">机械红马甲：在平凡中坚持 在坚持中传承</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【研招进行时】学校公布2016年考研初试成绩基本要求</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">2016年高水平运动队（篮球）考试举行</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【组图】“双代会”上的表情包</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【教代会】部院回眸</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 17:08</time></li>
					<li><a href="#">学校召开本科教学工作会议倡导优势专业建设</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 16:56</time></li>
					<li><a href="#">西南政法大学副教授校长刘想树一行访问我校</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 16:56</time></li>
					<li><a href="#">英国莱斯特大学代表团访问盘锦校区</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月8日 13:05</time></li>
					<li><a href="#">卓越大学联盟暨辽宁省高校专业认证研讨交流会举办</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">机械红马甲：在平凡中坚持 在坚持中传承</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【研招进行时】学校公布2016年考研初试成绩基本要求</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">2016年高水平运动队（篮球）考试举行</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【组图】“双代会”上的表情包</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【教代会】部院回眸</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 17:08</time></li>
					<li><a href="#">学校召开本科教学工作会议倡导优势专业建设</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 16:56</time></li>
					<li><a href="#">西南政法大学副教授校长刘想树一行访问我校</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 16:56</time></li>
					<li><a href="#">英国莱斯特大学代表团访问盘锦校区</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月8日 13:05</time></li>
					<li><a href="#">卓越大学联盟暨辽宁省高校专业认证研讨交流会举办</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">机械红马甲：在平凡中坚持 在坚持中传承</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">【研招进行时】学校公布2016年考研初试成绩基本要求</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>
					<li><a href="#">2016年高水平运动队（篮球）考试举行</a>&nbsp;&nbsp;&nbsp;&nbsp;<time>2016年3月9日 18:31</time></li>	 -->
				<!-- </ul> -->
			</div>
			</s:iterator>
			
		</div>
		<div class="content-right">
			<div class="inner-top">
			<p>每日推荐</p>
				<div class="deep-inner-top">
					<ul>
						<li>【组图】“双代会”上的表情包</li>
						<li>【教代会】部院回眸</li>
						<li>学校召开本科教学工作会议倡导优势专业建设</li>
						<li>西南政法大学副教授校长刘想树一行访问我校</li>
						<li>英国莱斯特大学代表团访问盘锦校区</li>
						<li>卓越大学联盟暨辽宁省高校专业认证研讨交流会举办</li>
						<li>机械红马甲：在平凡中坚持 在坚持中传承</li>
						<li>【研招进行时】学校公布2016年考研初试成绩基本要求</li>
						<li>2016年高水平运动队（篮球）考试举行</li>
						<li>美丽青春校园行 找寻更美的自己</li>
						<li>学校召开加强报告会、研讨会、论坛、讲座管理</li>
						<li>学校召开本科教学工作会议倡导优势专业</li>
						<li>【辽宁日报】大连理工社区驿站吸引学生从“网上”</li>
						
					</ul>
				</div>
			</div>

			<div class="inner-bottom">
			<p>焦点图片</p>
				<div class="deep-inner-bottom">
					<div class="left">
							<img class="one" src="/images/Desert.jpg" alt="无法显示图片" width="165.5px" height="155px">
							<img class="two" src="/images/Desert.jpg" alt="无法显示图片" width="165.5px" height="155px">
					</div>
					
					<div class="right">
						<img class="one" alt="图片无法显示" src="/images/Desert.jpg" width="165.5px" height="155px">
						<img class="two" alt="图片无法显示" src="/images/Desert.jpg" width="165.5px" height="155px">
					</div>
					
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