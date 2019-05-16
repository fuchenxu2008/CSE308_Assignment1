
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".action";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
	<script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script> 
	<script type="text/javascript" src="<%=basePath %>/resources/js/main/main.js"></script> 
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/main.css"/>  
</head>
<body onLoad="activateItem(document.getElementById('menu1'))">
<span><h3>Welcome <s:property value="#session.client.short_name"/>.&nbsp;&nbsp;You are in <s:property value="#session.client.address"/></h3></span>
	
	<img id="topImage" src="<%=basePath %>/resources/images/mockup/<s:property value="#request.number"/>_Top.png"/>

	<table>
		<tr>&nbsp;</tr>
		<tr>&nbsp;</tr>	
		<tr>&nbsp;</tr>
	</table>

<!--  Dynamic rendering data from database and showing into a table -->

	<div id="productHeader">Price List<br><br></div>
		<table>
			<thead>
				<tr style="background-color: #E0E0E1;">
				  	<th>Product Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="productList">
					<tr>
						<td><s:property value="name"/></td>
						<td><s:property value="price"/><br/></td> 
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
 
 
	<hr></hr>
	<div id="productHeader">Customer Who Viewed This Also Viewed<br><br></div>
	<!--  <div style="height:100px; width:600px; overflow:auto"> -->
	
	<table style="border:1px;">
		<tr>
			<td>
				<a href="javascript: void(0);" id="arrow" onclick="scrollDiv('l', 20); return false;" >
					<img src="<s:url value="/resources/images/icon/left_arrow.jpg"/>" />
				 </a>		
			</td>
		 
			<td>
				<div id="scroller" style="max-width:650px; overflow-x: scroll; white-space: nowrap;">
					<table border="0">
						<tr>
							<s:iterator value="recentProductList">
								<td> 
									<a href="javascript: void(0);" class="item" objectId="<s:property value="id"/>" >
										<img id="productImage" src="<%=basePath %><s:property value="imgUrl"/>" />
									</a>
								</td>
							</s:iterator>
						</tr>
						<tr>
							<s:iterator value="recentProductList">
								<td id="productDesc"> 
									<s:property value="name"/>
								</td>
							</s:iterator>
						</tr>
						
						<tr>	
							<s:iterator value="recentProductList">
								<td id="productDesc"> 
									<s:property value="price"/>
								</td>
							</s:iterator>
						</tr>
						  
						<tr>
							<s:iterator value="recentProductList">
								<td id="productDesc"> 
									<img id="productStarImage" src="<%=basePath %>/resources/images/starInfo/<s:property value="rate"/>star.png" />
								</td>
							</s:iterator>
						</tr> 	
					</table>
				</div>	
			</td>
			
			
			<td>
				<a href="javascript: void(0);" id="arrow" onclick="scrollDiv('r', 20); return false;" >
					<img src="<s:url value="/resources/images/icon/right_arrow.jpg"/>" />
				</a>		
			</td>
		</tr>	
	</table>
		 
	<hr></hr>
	<img  id="bottomImage" src="<%=basePath %>/resources/images/mockup/<s:property value="#request.number"/>_Bottom.png"/>
	<!-- </div> -->
<script type="text/javascript">
$(".item").click(function(){
	window.location.href = '<%=basePath %>/detail<%=servletSuffix %>?id='+$(this).attr("objectId");
});
</script>
</body>
</html>
