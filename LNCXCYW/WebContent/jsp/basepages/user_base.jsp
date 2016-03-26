<%@ include file="/jsp/basepages/taglib.jsp" %>
<!-- <link href="./dashboard.css" rel="stylesheet"> -->
<link href="dashboard.css" rel="stylesheet"> 
<layout:override name="base_content">
	
 <!-- <a href="/"> -->
  <!--   <div id="headerpic" > -->
       <%-- <ul class="nav navbar-right">
            <li id="welcome_word">
            	欢迎您: <span id="login_user_name">
            	<s:property value="#session.username"/>,
            	<s:property value="#session.fullName"/>
            	</span>
            	
            	
            	            	
            	<s:if test="#session.role.equals(@util.Const@AdminRole)">
            		(您是管理员)
            	</s:if>
            	<s:elseif test="#session.role.equals(@util.Const@StudentRole)">
            		(您是在职学生)
            	</s:elseif>
            	<s:else>
            		(您是有管理员权限的在职学生)
            	</s:else>
            	(您是有管理员权限的在职学生)
            	
            	
            </li>
        </ul>--%>
        <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/main.jsp"><b>辽宁省创新创业网</b></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <!-- <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li> -->
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">欢迎您，管理员</a></li>
            <li><a href="#">退出</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    <!-- </div>  -->
    
    
<!-- </a> -->




<!-- <div class="container-fluid main-container"> -->
<%-- <div class="container-fluid ">
    <div class="row col-lg-12">
        <div class="col-lg-3 ">	                    
            <layout:block name="menu_list">
            </layout:block>	
        </div>
        <div class="col-lg-9">
        	<div class="main-content">
            	<layout:block name="main_content">
            	</layout:block>
         </div>
        </div>
    </div>
</div> --%>
<div class="container-fluid ">
    <div class="row ">
        <div class="col-sm-3 col-md-2 sidebar">	                    
            <layout:block name="menu_list">
            </layout:block>	
        </div>
       <!--  <div class="col-sm-9  col-md-10  "> -->
       <div class="col-sm-9  col-md-10 ">
        	<!-- <div class="main-content"> -->
            	<layout:block name="main_content">
            	</layout:block>
         <!-- </div> -->
        </div>
    </div>
</div>


<!-- 
<div id="envelope"></div>
<div id="message-list-box" class="hide">
	<div class="message-list-top">
		<span class="title">消息</span>
		<span class="glyphicon glyphicon-remove closed"></span>
		<span class="glyphicon glyphicon-user users"></span>
	</div>
	<div class="message-list"></div>
	<div class="message-list-bottom" id="write-message">
		<span>发信息</span>
	</div>
</div>

<div id="message-contacts-box" class="hide">
	<div class="message-contacts-top">
		<span class="title">联系人</span>
		<span class="glyphicon glyphicon-remove closed"></span>
	</div>
	<div class="message-contacts">
    	<h4>
        	<a class="contacts-expand collapsed" data-toggle="collapse" href="#admin-contacts" aria-expanded="false" aria-controls="admin-contacts">
          		<span class="glyphicon glyphicon-plus"></span>  管理员
        	</a>
      	</h4>
    	<div id="admin-contacts" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
      		<ul class="contacts-list-group list-group"></ul>
    	</div>
	    <h4>
	        <a class="contacts-expand collapsed" data-toggle="collapse" href="#teacher-contacts" aria-expanded="false" aria-controls="teacher-contacts">
	          	<span class="glyphicon glyphicon-plus"></span>  教师
	        </a>
	    </h4>
	    <div id="teacher-contacts" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
	      	<ul class="contacts-list-group list-group"></ul>
	    </div>
	    <h4>
	        <a class="contacts-expand collapsed" data-toggle="collapse" href="#student-contacts" aria-expanded="false" aria-controls="student-contacts">
	          	<span class="glyphicon glyphicon-plus"></span>  学生
	        </a>
	    </h4>
	    <div id="student-contacts" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
	      	<ul class="contacts-list-group list-group"></ul>
	    </div>
	</div>
</div>

<div id="message-content-box" class="hide" from=<s:property value="#session.user_id"/>>
	<div class="message-content-top">
		<span class="title">某某某</span>
		<span class="glyphicon glyphicon-remove closed"></span>
		<span class="glyphicon glyphicon-user users"></span>
		<span class="glyphicon glyphicon-menu-left back"></span>
	</div>
	<div class="message-content"></div>
	<div class="message-tool"></div>
	<div class="message-writeboard">
		<textarea class="form-control" rows="4"></textarea>
		<div class="send-bottom">
			<button type="button" class="btn btn-sm" onclick="sendMessage()">发送</button>
		</div>
	</div>
</div>

<script type="text/javascript" src="/js/base/websocket.js"></script>
 -->
        
 <layout:block name="nav_content">
 
 </layout:block>
	

	
	
</layout:override>

<%@ include file="/jsp/basepages/base2.jsp" %>


   	