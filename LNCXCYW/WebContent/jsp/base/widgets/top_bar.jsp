<%@ include file="/jsp/basepages/taglib.jsp"%>


<div class="splitterbars">
	<ul class="f_left">
		<a
			onclick="javascript:window.external.addFavorite('http://www.baidu.com','辽宁省大学生创新创业网')"
			href="http://localhost:8080/">加入收藏 </a>|
		<a
			onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.localhost:8080');"
			href="http://www.localhost:8080">设为首页</a>
	</ul>
</div>

<div class="logobox">
	<div class="logo">
		<img src="/images/2Dcode.jpg" height="60px" width="60px" />

		<div class="regist">
			<s:if test="#session.user!=null">
				<a href="/newsAdd"><s:property value="#session.user.userName" />
					&nbsp欢迎您</a>
			</s:if>
			<s:else>
				<a href="/jsp/homepage/login.jsp" target="_blank">登录&nbsp;|&nbsp;</a>
				<a href="/jsp/homepage/regist.jsp" target="_blank">注册</a>
			</s:else>
		</div>
		<div class="search">
			<input type="text" class="" placeholder="站内搜索" name="keyWords"
				id="keyWords">

			<button id="news_search_by_title" type="button">搜索</button>
		</div>
	</div>
	
	<div class="splitterbars"></div>
	<div class="nav">
		<ul class="nav_all" >
			<li><a href="/">首页</a></li>
			<li><a href="/second_page2?category=创新创业资讯">创新创业资讯</a></li>
			<li><a href="/second_page2?category=创新创业训练">创新创业训练</a></li>
			<li><a href="/second_page2?category=创新创业竞赛">创新创业竞赛</a></li>
			<li><a href="/second_page2?category=创新创业资源">创新创业资源</a></li>
			<li><a href="/second_page2?category=创新创业成果">创新创业成果</a></li>
			<li><a href="/second_page2?category=资料下载">资料下载</a></li>
		</ul>
	</div>
</div>