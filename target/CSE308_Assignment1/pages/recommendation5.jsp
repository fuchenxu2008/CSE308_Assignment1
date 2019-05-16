
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="main.css"/>  
       <script type="text/javascript" src="main.js"></script> 
        <script type="text/javascript">
  
        
</script>

    </head>
    <body onLoad="activateItem(document.getElementById('menu4'))">
        <img id="topImage" src="<s:url value="5_Top.png"/>"/>
        
        <hr></hr>
        <div id="productHeader">Customer Who With Similar Weight Goals Recently Purchased<br><br></div>
		

	<!--  <div style="height:100px; width:600px; overflow:auto"> -->
		<table border="0">
		<tr>
		
		  <td>
    <a href="javascript: void(0);" id="arrow"  onclick="scrollDiv('l', 20); return false;" >
    <img src="<s:url value="left_arrow.jpg"/>" />
   </a>		
	 </td>
	 
		<td>
	<div id="scroller" style="max-width:650px; overflow-x: scroll; white-space: nowrap;">
	<table border="0">

	<tr>
    <s:iterator value="imageUrlList">
    <td> 
		 <img id="productImage" src="<s:property/>" />
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
 	<div> 
		   <s:property/>
		   </div>
    </td>
		</s:iterator>
	 
	</tr>
	  
	 <tr>
    <s:iterator value="starImageUrlList">
    <td> 
		 <img id="productStarImage" src="<s:property/>" />
    </td>
		</s:iterator>
		
	</tr> 	
	</table>
		</div>	
		</td>
    <td>
    <a href="javascript: void(0);" id="arrow" onclick="scrollDiv('r', 20); return false;" >
    <img src="<s:url value="right_arrow.jpg"/>" />
   </a>		
	 </td>
	 <tr>	
		</table>
		 
<hr></hr>
<img  id="bottomImage" src="<s:url value="5_Bottom.png"/>"/>
		<!-- </div> -->
		 
		 
    </body>

</html>
