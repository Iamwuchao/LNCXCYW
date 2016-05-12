<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
		<div id="showexamCont">
			<div id="exCont" class="panel panel-default"  >
				<div class="panel-body ">
				
	  			<s:iterator var="i" begin="0" end="examTitleList.size()-1" step="1"  >
					<ul class="exam_margin well" titleId=<s:property value="examTitleList.get(#i).emId" /> >
						<li class="margin_liTitle">
							<span><s:property value="#i + 1"/>.&nbsp;</span>
							<s:property value="examTitleList.get(#i).emTitle" escape="false"/>
						</li>
						
						<s:iterator var = "j" begin = "0" end = "examOptionList.get(#i).size() - 1">
							<li>
								<div opId=<s:property value="examOptionList.get(#i).get(#j).emId" /> 
								     class="opToback">
										<input type="checkbox" class="checks checkOption "/>
									<span class="">&nbsp;<s:property value="intToChar(#j)" />&nbsp;</span>
									<s:property value="examOptionList.get(#i).get(#j).emOption" />								
								</div>
							</li>
							
						</s:iterator>
						

					</ul>
				</s:iterator>
				<div class="center-block" style="max-width:300px;">
					<button type="button" class="btn btn-primary btn-lg btn-block center" id="examSubmit">我要交卷</button>
				</div>
			</div>			
	  </div>
	</div>
</div>
</layout:override>
<%@ include file="/jsp/third/base.jsp" %>