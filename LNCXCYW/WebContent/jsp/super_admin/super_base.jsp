<%@ include file="/jsp/basepages/taglib.jsp" %>
<!-- <link href="dashboard.css" rel="stylesheet">  -->


<layout:override name="menu_list">

	 <div class="menu-list" style="height:820px"> 
	 	<a href="news_classify.jsp" class="menu-button-middle"><span class="glyphicon glyphicon-blackboard">&nbsp;新闻分类</span></a>
	    <a href="news_manage.jsp" class="menu-button-middle"><span class="glyphicon glyphicon-th-large">&nbsp;新闻管理</span></a>
	    <a href="news_add.jsp" class="menu-button-middle"><span class="glyphicon glyphicon-th-large">&nbsp;新闻添加</span></a>
	    <a href="/admin/user_request/" class="menu-button-middle"><span class="glyphicon glyphicon-th">&nbsp;管理员审核</span></a>
	    <a href="/admin/user_authority/" class="menu-button-middle"><span class="glyphicon glyphicon-th">&nbsp;权限管理</span></a>
	    <a href="#" class="menu-button-middle"><span class="glyphicon glyphicon-th">&nbsp;新闻审核</span></a>
	    <a href="#" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;下载中心</span></a>
	    <a href="#" class="menu-button-middle"><span class="glyphicon glyphicon glyphicon-user">&nbsp;个人信息</span></a>
	    </div>
	    <!--  <ul class="nav nav-sidebar">
            <li class="active"><a href="#">新闻分类 <span class="sr-only">(current)</span></a></li>
            <li class="menu-button-middle"><a href="#">新闻分类</a></li>
            <li class="menu-button-middle"><a  href="#">新闻管理</a></li>
            <li class="menu-button-middle"><a  href="#">管理员审核</a>
            <ul>
            <li><a a class="menuItem" href="#">用户审核</a></li>
            <li><a>新闻审核</a></li>
            </ul>
            </li>
            <li class="active"><a href="#">下载中心</a></li>
            <li class="active"><a href="#">个人信息</a></li>
          </ul> -->
          <!-- <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul> 
           -->
      <!--  </div>  -->
	    <%-- <a href="/admin/adminaccount" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;账号生成</span></a>


	    <a href="/admin/HomepageModify/" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;主页管理</span></a>
	    <a href="/admin/batchImport" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;批量课表导入</span></a>
	    <a href="/admin/asdf" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;远程控制</span></a>
	    <a href="/admincheckin/checkinrecords" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;签到管理</span></a>
	    
	    <s:if test="!#session.role.equals(@util.Const@StudentToAdminRole)">
		    <a href="/admin/modifypassword" class="menu-button-middle"><span class="glyphicon glyphicon-lock">&nbsp;修改密码</span></a>
		    <a href="/admin/user_information" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;个人信息</span></a>
		    <a href="/logout" class="menu-button-middle"><span class="glyphicon glyphicon-list-alt">&nbsp;安全退出</span></a>
	    </s:if>
	    
	    <s:if test="#session.role.equals(@util.Const@StudentToAdminRole)">
            <a href="/student/" class="menu-button-middle"><span class="glyphicon glyphicon-share-alt">&nbsp;跳回在职学生</span></a>
        </s:if>
 --%>
	    
	    <!-- <div class="menu-blank"></div> -->
	<!-- </div> -->
	
	 
 </layout:override>








<%@ include file="/jsp/basepages/user_base.jsp" %>
