<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
		<div id="showexamCont">
			<div id="exCont" class="panel panel-default"  >
				<div class="panel-body ">
				
	  			<s:iterator var="i" begin="0" end="listOftitle.size()-1" step="1"  >
					<dl class="exam_margin well" titleId=<s:property value="listOftitle.get(#i).emId" /> >
						<li class="margin_liTitle">
							<span><s:property value="#i + 1"/>.&nbsp;
							<s:property value="listOftitle.get(#i).emTitle" escape="false"/></span>
						</li>
						
						<s:iterator var = "j" begin = "0" end = "optionsOfTitle.get(#i).size() - 1">
							<li>
								<div opId=<s:property value="optionsOfTitle.get(#i).get(#j).emId" /> 
								     class="opToback">
										<input id="<s:property value='optionsOfTitle.get(#i).get(#j).emOpId'/>" type="checkbox" class="checks checkOption "/>
									<span class="">&nbsp;<s:property value="intToChar(#j)" />&nbsp;</span>
									<s:property value="optionsOfTitle.get(#i).get(#j).emOption" />								
								</div>
							</li>
						</s:iterator>

					</dl>
				</s:iterator>
				<div class="center-block" style="max-width:300px;">
					<button type="button" class="btn btn-primary btn-lg btn-block center" id="examSubmit" onclick="myonclick()">我要交卷</button>
				</div>
			</div>			
	  </div>
	</div>
</div>
</layout:override>
<layout:override name="eve_push">
	<ul>
		<s:iterator value="newestNewsList" var="i" status="index">
			<li>
				<a href="<s:property value="#i.news_address" />">
					<s:property value="#i.newsTile" />
				</a>
			</li>
		</s:iterator>
	</ul>
</layout:override>

<layout:override name="focus_left_picture">
       <img class="one" src="<s:property value="%{pictureNewsList.get(0).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(0).newsTile}"/>" width="115px" height="120px">
       <img class="two" src="<s:property value="%{pictureNewsList.get(1).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(1).newsTile}"/>" width="115px" height="120px">
</layout:override>
<layout:override name="focus_right_picture">
	   <img class="one" src="<s:property value="%{pictureNewsList.get(2).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(2).newsTile}"/>" width="115px" height="120px">
       <img class="two" src="<s:property value="%{pictureNewsList.get(3).news_address}"/>" alt="<s:property value="%{pictureNewsList.get(3).newsTile}"/>" width="115px" height="120px">
</layout:override>
<%@ include file="/jsp/third/base.jsp" %>
<script>

function myonclick(){
	var L = $(".checkOption");
	var checkedOptionList = new Array();
	for(var i = 0; i < L.length; ++ i)
	{
		if($(L[i].checked))
		{
			var cid = $(L[i]).attr("id");
		//	console.log(cid);
			checkedOptionList.push(cid);
		}		
	}
	$.ajax({
		url : 'judgingPaper',
		type : 'post',
		dataType : 'json',
		data : {'checkedOptionList':checkedOptionList},
		traditional : true,
		success : checkChangeCallback,
		error:checkerror
	});
}

function checkChangeCallback(){
	alert("success");
}

function checkerror(){
	alert("error");
}
	
	
	
	
	
	



</script>