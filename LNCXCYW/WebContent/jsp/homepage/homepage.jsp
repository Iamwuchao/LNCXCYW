<%@ taglib prefix="layout" uri="/WEB-INF/jsp_layout.tld"%>


<%@ taglib prefix="s" uri="/struts-tags"%>

<layout:override name="base_content">


 <div id="first_con"  class="con" >
     <div id="myCarousel"  class="con1 carousel slide">
     
     	<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
			


                <div class="carousel-inner">
                  <div class="item active" style="background-color:black; height:250px;">
                    <a id="pic" href="<s:property value="%{newsMap.get('图片新闻链接').get(0).news_content}"/>">
                    <img src="<s:property value="%{newsMap.get('图片新闻链接').get(0).news_address}"/>" alt="">
                    </a>
                    <p style="text-align:center; line-height:20px; height:20px; width:100%; color:#fff; font-weight:bold; position:absolute; bottom:0;overflow:hidden;margin-bottom:0;" ><s:property value="%{newsMap.get('图片新闻链接').get(0).newsTile}"/></p>
                  </div>
                  <div class="item" style="background-color:black; height:250px;">
                    <a id="pic" href="<s:property value="%{newsMap.get('图片新闻链接').get(1).news_content}"/>">
                   	 	<img src="<s:property value="%{newsMap.get('图片新闻链接').get(1).news_address}"/>" alt="">
                    </a>
                    <p style="text-align:center; line-height:20px; height:20px; width:100%; color:#fff; font-weight:bold; position:absolute; bottom:0;overflow:hidden;margin-bottom:0;" ><s:property value="%{newsMap.get('图片新闻链接').get(1).newsTile}"/></p>
				</div>
				<div class="item" style="background-color:black; height:250px;">
					<a id="pic" href="<s:property value="%{newsMap.get('图片新闻链接').get(2).news_content}"/>">
                   		<img src="<s:property value="%{newsMap.get('图片新闻链接').get(2).news_address}"/>" alt="">
                   </a>
                   <p style="text-align:center; line-height:20px; height:20px; width:100%; color:#fff; font-weight:bold; position:absolute; bottom:0; overflow:hidden; margin-bottom:0;" ><s:property value="%{newsMap.get('图片新闻链接').get(2).newsTile}"/></p>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
		</div>
		
		<!-- 第一行  第二块 -->
		<div class="con2" >
			<div class="name">
				<ul style="width:100%;height:36px;/* overflow:hidden */">
					<a href="/second_page?category=通知公告" onclick="" target="_blank"><li id="one1" onmouseover="setTabsnow('one',1,3)"  class="curnews">通知公告</li></a>
         			<a href="/second_page?category=工作动态" onclick="" target="_blank"><li id="one2" onmouseover="setTabsnow('one',2,3)" >工作动态</li></a>
         			<a href="/second_page?category=高校动态" onclick="" target="_blank"><li id="one3" onmouseover="setTabsnow('one',3,3)" >高校动态</li></a>
				</ul>
			</div>
			<div class="clear"></div>
			<div id="con_one_1" style="display: block;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="%{newsMap.get('通知公告')}" var="i" status="index">
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
						        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
						        </a>  
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="con_one_2" style="display: none;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="newsMap['工作动态']" var="i" status="index"> 
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
					        		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
					        	</a> 
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="con_one_3" style="display: none;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="newsMap['高校动态']" var="i" status="index"> 
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
					        		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
					        	</a>
							</li>
						</s:iterator>
					</ul>				
				</div>
			</div>
		</div>
		
		<!-- 第一行   第三块 -->
		<div class="con3" style="float:right">
			<ul class = "list-group">
				<li class="list-group-item"><div style="margin-left:40px" onclick="window.location.href= '/user/projectAdd'">我要对接项目</div></li>
        		<li class="list-group-item"><div style="margin-left:40px" onclick="window.location.href= '/second_page?category=创新创业活动日程表'">创新创业活动日程表</div></li>
        		<li class="list-group-item"><div style="margin-left:40px" onclick="window.location.href= '/second_page2?category=创新创业改革实施方案'">创新创业改革实施方案</div></li>
        		<li class="list-group-item"><div style="margin-left:40px" onclick="window.location.href= '/second_page2?category=创新创业教育基地'">创新创业教育基地</div></li>
        		<li class="list-group-item"><div style="margin-left:40px" onclick="window.location.href= '/second_page2?category=创新创业选育基地'">创新创业选育基地</div></li>
        		<li class="list-group-item"><div style="margin-left:40px" onclick="window.location.href= '/second_page?category=创新创业试点专业'">创新创业试点专业</div></li>
			</ul>
		</div>	
	</div>
	
	
	<!-- 第二行 -->
	<div id="second_con" class="connews">
		<!-- 第二行  第一块 -->
		<div id="second_con1" style=" margin-right: 10px" class="conblue">
			<div class="name">
				<ul style="width:100%;height:36px;/* overflow:hidden */">
					<a href="/second_page?category=政策规章" target="_blank"><li id="two1" onmouseover="setTabsnow('two',1,2)" class="curnews">政策规章</li></a>
	         		<a href="/second_page?category=创新创业资讯" target="_blank"><li id="two2" onmouseover="setTabsnow('two',2,2)" >创新创业资讯</li></a>
				</ul>
			</div>
			<div class="clear"></div>
			<div id="con_two_1" class="test" style="display: block;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="newsMap.get('政策规章')" var="i" status="index">
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a> 
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			
			<div id="con_two_2" style="display:  none;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="newsMap.get('创新创业资讯')" var="i" status="index">  
							<li>
								<a href="<s:property value="#i.getNews_address()"/>"  title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- 第二行   第三块 -->
		<div id="second_con2" style=" margin-right: 10px" class="congrey">
			<div class="name">
				<ul style="width:100%;height:36px;/* overflow:hidden */">
					<a href="/second_page?category=教指委工作动态" target="_blank"><li id="three1" onmouseover="setTabsnow('three',1,2)" class="curnews">教指委工作动态</li></a>
	         		<a href="/second_page?category=高校创新创业教育季报" target="_blank"><li id="three2" onmouseover="setTabsnow('three',2,2)" >高校创新创业教育季报</li></a>
				</ul>
			</div>
			<div class="clear"></div>
			<div id="con_three_1" style="display: block;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="%{newsMap.get('教指委工作动态')}" var="i" status="index">   
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a> 
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="con_three_2" style="display:  none;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="%{newsMap.get('高校创新创业教育季报')}" var="i" status="index">   
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- 第二行   第三块 -->
		<div id="second_con3" class="conblue">
			<div class="name">
				<ul style="width:100%;height:36px;/* overflow:hidden */">
					<a href="/second_page?category=项目推介" target="_blank"><li id="four1" onmouseover="setTabsnow('four',1,2)" class="curnews">项目推介</li></a>
	         		<a href="/second_page?category=企业需求" target="_blank"><li id="four2" onmouseover="setTabsnow('four',2,2)" >企业需求</li></a>
				</ul>
			</div>
			<div class="clear"></div>
			<div id="con_four_1" style="display: block;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="%{newsMap.get('项目推介')}" var="i" status="index">   
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="con_four_2" style="display: none;">
		         <div class="list1" style="padding-top: 15px">
		         	<ul>
						<s:iterator value="%{newsMap.get('企业需求')}" var="i" status="index">   
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        &nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a>
							</li>
						</s:iterator>
					</ul>	
		         </div>
		    </div>
		</div>
	</div>
	
	<!-- 第三行  新加的需求 -->
	<div id="third_con" class="connews_img">
		<!-- 第三行  第一块 -->
		<div id="third_con1" style="margin-right:10px;" class="conblue">
			<div class="name">
				<p style="line-height:36px; font-weight:bold; padding:10px;">热点</p>
			</div>
			<div class="clear"></div>
			<div >
				<img src="<s:property value="%{newsMap.get('成果展示链接链接').get(0).news_address}"/>">
			</div>
		</div>
		
		<!-- 第三行 第二块 -->
		<div id="third_con2" style="margin-right:10px;" class="conblue">
			<div class="name">
				<p style="line-height:36px; font-weight:bold; padding:10px;">热点</p>
			</div>
			<div class="clear"></div>
			<div >
				<img src="<s:property value="%{newsMap.get('成果展示链接链接').get(1).news_address}"/>">
			</div>
		</div>
		
		<!-- 第三行 第三块 -->
		<div id="third_con3" class="conblue">
			<div class="name">
				<p style="line-height:36px; font-weight:bold; padding:10px;">热点</p>
			</div>
			<div class="clear"></div>
			<div >
				<img src="<s:property value="%{newsMap.get('成果展示链接链接').get(2).news_address}"/>">
			</div>
		</div>
	</div>
	
	<div class="nav" style="background-color:#fff">
		<ul class="nav_three_all">
			<li style="margin-right:14px; background-color:#195591;"><a href="http://59.46.92.105:9000/">创新创业训练计划项目管理系统</a></li>
			<li style="margin-right:14px; background-color:#195591;"><a href="/">省大创年会项目评审系统</a></li>
			<li style="background-color:#195591"><a href="http://dasai.upln.cn/index.php?m=yp">创新创业竞赛管理系统</a></li>
		</ul>
	</div>
	
	<!-- 第四行   原来的第三行 -->
	<div id="fourth_con" class="connews">
		<div id="third_con1" style=" margin-right: 10px" class="congrey">
			<div class="name">
				<ul style="width:100%;height:36px;">
	         		<a href="/second_page?category=创新创业训练计划" target="_blank"><li id="five1" onmouseover="setTabsnow('five',1,2)" class="curnews">创新创业训练计划</li></a>
	         		<a href="/second_page?category=创新创业竞赛" target="_blank"><li id="five2" onmouseover="setTabsnow('five',2,2)" >创新创业竞赛</li></a>
	         	</ul>
			</div>
			<div class="clear"></div>
	          <div id="con_five_1" style="display: block;">
	          	<div class="list1" style="padding-top: 15px">
	          		<ul>
						<s:iterator value="%{newsMap.get('创新创业训练计划')}" var="i" status="index">    
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							        	&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
							    </a>
							</li>
						</s:iterator>
					</ul>
	          	</div>
	          </div>
	          <div id="con_five_2" style="display:  none;">
	          	<div class="list1" style="padding-top: 15px">
	          		<ul>
						<s:iterator value="%{newsMap.get('创新创业竞赛')}" var="i" status="index">     
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     &nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
	          	</div>
	          </div>
		</div>
		
		<!-- 第四行  第二块 -->
		<div id="third_con2" style=" margin-right: 10px" class="conblue">
			<div class="name">
				<ul style="width:100%;height:36px;">
	         		<a href="/second_page?category=创新创业年会" target="_blank"><li id="six1" onmouseover="setTabsnow('six',1,2)" class="curnews">创新创业年会</li></a>
	         		<a href="/second_page?category=优秀创新创业作品" target="_blank"><li id="six2" onmouseover="setTabsnow('six',2,2)" >优秀创新创业作品</li></a>
	         	</ul>
			</div>
			<div class="clear"></div>
			<div id="con_six_1" style="display: block;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="%{newsMap.get('创新创业年会')}" var="i" status="index">     
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="con_six_2" style="display:  none;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="%{newsMap.get('优秀创新创业作品')}" var="i" status="index">
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     			&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- 第四行  第三块 -->
		<div id="third_con3" class="congrey">
	        <div class="name">
	        	<ul style="width:100%;height:36px;/* overflow:hidden */">
	         		<a href="/second_page?category=他山之石" target="_blank"><li id="seven1" onmouseover="setTabsnow('seven',1,2)" class="curnews">他山之石</li></a>
	         		<a href="/second_page?category=创新创业典型" target="_blank"><li id="seven2" onmouseover="setTabsnow('seven',2,2)" >创新创业典型</li></a>
	         	</ul>
	        </div>
	        <div class="clear"></div>
	        <div id="con_seven_1" style="display: block;">
				<div class="list1" style="padding-top: 15px">
					<ul>
						<s:iterator value="newsMap['他山之石']" var="i" status="index">      
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div id="con_seven_2" style="display: none;">
		         <div class="list1" style="padding-top: 15px">
		         	<ul>
						<s:iterator value="%{newsMap.get('创新创业典型')}" var="i" status="index">     
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     			&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
		         </div>
		    </div>
	    </div>
	</div>
	
<!-- 第五行  原来的第四行 -->
	<div id="fifth_con" class="connews">
		<!-- 创新创业培训  第一个新闻栏 -->
		<div id="fourth_con1" style=" margin-right: 10px" class="conblue">
       		<div id="fourth_con2" class="name">
       			<ul style="width:100%;height:36px;/* overflow:hidden */">
	         		<a href="/second_page?category=创新创业培训" target="_blank"><li id="eight1" onmouseover="setTabsnow('eight',1,2)" class="curnews">创新创业培训</li></a>
	         		<a href="/second_page?category=创新创业理论" target="_blank"><li id="eight2" onmouseover="setTabsnow('eight',2,2)" >创新创业理论</li></a>
	         	</ul>
       		</div>
       		<div class="clear"></div>
       		<div id="con_eight_1">
       			<div class="list1" style="padding-top: 15px">
       				<ul>
						<s:iterator value="%{newsMap.get('创新创业培训')}" var="i" status="index">     
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
       			</div>
       		</div>
       		<div id="con_eight_2" style="display:  none;">
		         <div class="list1" style="padding-top: 15px">
		         	<ul>
						<s:iterator value="%{newsMap.get('创新创业理论')}" var="i" status="index">    
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     			&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
		         </div>
		    </div>
       	</div>
       	
       	<!-- 创新创业教材  第二个新闻栏 -->
       	<div id="fourth_con2" style="margin-right:10px" class="congrey">
		 	<div id="fourth_con2" class="name">
		 		<ul style="width:100%;height:36px;/* overflow:hidden */">
	         		<a href="/second_page2?category=创新创业课程" target="_blank"><li id="nine1" onmouseover="setTabsnow('nine',1,2)" class="curnews">创新创业课程</li></a>
	         		<a href="/second_page?category=创新创业教材" target="_blank"><li id="nine2" onmouseover="setTabsnow('nine',2,2)" >创新创业教材</li></a>
	         	</ul>
		 	</div>
		 	<div class="clear"></div>
       		<div id="con_nine_1">
       			<div class="list1" style="padding-top: 15px">
       				<ul>
						<s:iterator value="%{newsMap.get('创新创业课程')}" var="i" status="index">  
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
       			</div>
       		</div>
       		<div id="con_nine_2" style="display:  none;">
		         <div class="list1" style="padding-top: 15px">
		         	<ul>
						<s:iterator value="%{newsMap.get('创新创业教材')}" var="i" status="index">  
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     			&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
		         </div>
		    </div>
		</div>
		
		<!-- 第三个新闻栏 为何这么多！！！！ -->
      	<div id="fourth_con3"  class="conblue">
      		<div id="fourth_con2" class="name">
      			<ul style="width:100%;height:36px;/* overflow:hidden */">
		         	<a href="/second_page?category=创新创业导师" target="_blank"><li id="ten1" onmouseover="setTabsnow('ten',1,2)" class="curnews">创新创业导师</li></a>
		         	<a href="/getAllExamPaper.action" target="_blank"><li id="ten2" onmouseover="setTabsnow('ten',2,2)" >素质测评</li></a>
		        </ul>
      		</div>
      		<div class="clear"></div>
       		<div id="con_ten_1">
       			<div class="list1" style="padding-top: 15px">
       				<ul>
						<s:iterator value="%{newsMap.get('创新创业导师')}" var="i" status="index">  
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
       			</div>
       		</div>
       		<div id="con_ten_2" style="display:  none;">
       			<div class="list1" style="padding-top: 15px">
       				<ul>
						<s:iterator value="%{newsMap.get('素质测评')}" var="i" status="index">
							<li>
								<a href="<s:property value="#i.getNews_address()"/>" class="c50257" title="<s:property value="#i.getNewsTile()"/>" target="_blank">
							     		&nbsp;&nbsp;&nbsp;<s:property value="#i.getNewsTile()"/>
								</a>
							</li>
						</s:iterator>
					</ul>
       			</div>
       		</div>
      	</div>
	</div>
	
</layout:override>

<%@ include file="/jsp/basepages/base.jsp" %>
			