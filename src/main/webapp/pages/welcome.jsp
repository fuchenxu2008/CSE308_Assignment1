<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".do";
%>
<html style="height: 100%;"> 
<head>
	<title>welcome</title>
	<script type="text/javascript">
		var basePath='<%=basePath %>';
	</script>
	<script src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>  
	<script src="<%=basePath %>/resources/js/config.js"></script>  
	<script src="<%=basePath %>/resources/js/skel.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/main.css"/>  
	<script type="text/javascript" src="<%=basePath %>/resources/js/main/main.js"></script> 
</head>
<body style="height:100%;"> 

<%-- <s:form action="recommendation1.action" id="welcomeform" name="welcomeform" theme="simple"> --%>
	<div style="height: 100%;">
		<!-- Nav -->
		<nav id="nav">
			<ul class="container">
				<li></li>
				
			</ul>
		</nav>

		<!-- Home -->	
		<div  style="border: 0px solid black;"> 
			<article class="container" id="top">     
				<div align="center">
				
					<header>
						<h1 style="color:#3399CC;"><br><br>Welcome to</h1>    
						<h2><strong style="color:#990000;">My Pharmacy Shop</strong></h2>
					</header> 
						  
				</div>
			</article> 
		</div>
			 

	 	<div align="center" style="height: 230px">   
			<a href="javascript: void(0);" title="Click Here to Enter" id="enter" onclick="enterClicked(); return false;" >
			  <img id="enterImage" src="<%=basePath %>/resources/images/icon/enter.jpg"/>  
			</a>	
	   	</div> 

 
		<div style="border: 0px solid black;  vertical-align: bottom;">  
			<table width="100%" style="vertical-align: bottom; border: 0px solid black; height: 100%">
				<tr>
					<td width="35%">&nbsp;</td>   
					<td style="vertical-align: bottom; border: 0px solid black;"><img id="logoDatastax" src="<%=basePath %>/resources/images/logo/datastax1.jpg"/></td>
					<td style="vertical-align: bottom; border: 0px solid black;"><img id="logoStorm" src="<%=basePath %>/resources/images/logo/Storm.jpg"/></td>
					<td style="vertical-align: bottom; border: 0px solid black;"><img id="logoSpring" src="<%=basePath %>/resources/images/logo/spring.jpg"/> </td> 
					<td width="30%">&nbsp;</td> 
				</tr>
			</table> 
		</div>  
	
		<!-- Work -->  
		<div style="height:50px;  border: 0px solid black; background-color:#E8E8E8"></div>
		 
	</div> 
<%-- </s:form> --%>

</body>
</html>