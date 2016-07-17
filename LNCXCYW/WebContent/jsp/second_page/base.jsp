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
		<div>
			<%@ include file="/jsp/base/widgets/top_bar.jsp" %>
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