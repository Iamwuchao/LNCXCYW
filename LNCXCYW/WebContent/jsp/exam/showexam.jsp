<%@ include file="/jsp/basepages/taglib.jsp" %>
<layout:override name="news_content">
<div class="mycontent">  
		<div id="showexamCont">
			<div id="exCont" class="panel panel-default"  >
				<div class="panel-body ">
				<p><s:property value="paperDescription" /></p>
				
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
										<input id="<s:property value='optionsOfTitle.get(#i).get(#j).emOpId'/>" 
										name="<s:property value='#i'/>" 
										type="radio"
										 class="checks checkOption "/> 	
										<span class="">&nbsp;<s:property value="optionsOfTitle.get(#i).get(#j).emStrID" />&nbsp;</span>
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
		/* if($(L[i].checked)) */
		//alert($(L[i]).is(':checked'));
			if($(L[i]).is(':checked'))
		{
			var cid = $(L[i]).attr("id");
		//	console.log(cid);
			checkedOptionList.push(cid);
		}		
	}
	if(checkedOptionList.length==0){
		alert("您没有回答任何题目");
	}else{
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
}

function checkChangeCallback(date){
	//alert(date.evaluate);
	var newcontent = "<p>"+"测试结果为："+date.evaluate+"</p>";
	document.getElementById("exCont").innerHTML = newcontent;
}

function checkerror(){
	alert("error");
}
	
	
	
	
	
	



</script>