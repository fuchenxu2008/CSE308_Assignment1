<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".action";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/main.css"/>  
	<script type="text/javascript" src="<%=basePath %>/resources/js/main/main.js"></script> 
</head>
<body onLoad="activateItem(document.getElementById('menu1'))">

	<img id="topImage" src="<%=basePath %>/resources/images/mockup/${number }_Top.png"/>

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
				<%-- <s:iterator value="productList">
					<tr>
						<td><s:property value="name"/></td>
						<td><s:property value="price"/><br/></td> 
					</tr>
				</s:iterator> --%>
				<%-- <s:iterator value="pList" id="product" status="st">
					<tr>
						<td><s:property value="#product.name"/></td>
						<td><s:property value="#product.price"/><br/></td> 
					</tr>
				</s:iterator> --%>
				<c:forEach items="${productList }" var="product">
					<tr>
						<td>${product.name }</td>
						<td>${product.price }</td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
 
 
	<hr></hr>
	<div id="productHeader">Recently Viewed Items<br><br></div>
	<!--  <div style="height:100px; width:600px; overflow:auto"> -->
	
	<%-- <table style="border:1px;">
		<tr>
			<td>
				<a href="javascript: void(0);" id="arrow"  onclick="scrollDiv('l', 20); return false;" >
					<img src="<%=basePath %>/resources/images/icon/<s:url value="left_arrow.jpg"/>" />
				 </a>		
			</td>
		 
			<td>
				<div id="scroller" style="max-width:650px; overflow-x: scroll; white-space: nowrap;">
					<table border="0">
						<tr>
							<s:iterator value="imageUrlList">
								<td> 
									<img id="productImage" src="<%=basePath %>/resources/images/2/<s:property/>" />
								</td>
							</s:iterator>
						</tr>
						<tr>
							<s:iterator value="imageDescList" var="key">
								<td id="productDesc" >
									<s:text name="%{#key}" />  
								</td>
							</s:iterator>
						</tr>
						
						<tr>	
							<s:iterator value="priceList">
								<td id="productDesc"> 
									<div><s:property/></div>
								</td>
							</s:iterator>
						</tr>
						  
						<tr>
							<s:iterator value="starImageUrlList">
								<td> 
									<img id="productStarImage" src="<%=basePath %>/resources/images/starInfo/<s:property/>" />
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
	</table> --%>
	<table class="recentTable" style="border:1px;">
		<tr>
			<td>
				<a href="javascript: void(0);" id="arrow"  onclick="scrollDiv('l', 20); return false;" >
					<img src="<%=basePath %>/resources/images/icon/left_arrow.jpg" />
				 </a>		
			</td>
		 
			<td>
				<div id="scroller" style="max-width:650px; overflow-x: scroll; white-space: nowrap;">
					<table border="0">
						<tr>
							<c:forEach items="${recentProductList }" var="product">
								<td> 
									<img id="productImage" src="<%=basePath %>${product.imgUrl }" />
								</td>
							</c:forEach>
						</tr>
						<tr>
							<c:forEach items="${recentProductList }" var="product">
								<td id="productDesc" >
									${product.name }
								</td>
							</c:forEach>
						</tr>
						
						<tr>	
							<c:forEach items="${recentProductList }" var="product">
								<td id="productDesc"> 
									<div>${product.price }</div>
								</td>
							</c:forEach>
						</tr>
						  
						<tr>
							<c:forEach items="${recentProductList }" var="product">
								<td> 
									<img id="productStarImage" src="<%=basePath %>/resources/images/starInfo/${product.rate }star.png" />
								</td>
							</c:forEach>
						</tr> 	
					</table>
				</div>	
			</td>
			
			
			<td>
				<a href="javascript: void(0);" id="arrow" onclick="scrollDiv('r', 20); return false;" >
					<img src="<%=basePath %>/resources/images/icon/right_arrow.jpg" />
				</a>		
			</td>
		</tr>	
	</table>
		 
	<hr></hr>
	<img  id="bottomImage" src="<%=basePath %>/resources/images/mockup/${number }_Bottom.png"/>
	<!-- </div> -->

</body>
</html>
