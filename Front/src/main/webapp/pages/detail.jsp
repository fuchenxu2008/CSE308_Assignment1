
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".do";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JSP Page</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/App.css"/>  
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/index.css"/>  
	<script type="text/javascript" src="<%=basePath %>/resources/js/App.js"></script> 
</head>
<body>
<div class="container">
        <button type="button" class="back" onClick="javascript:window.history.go(-1);" >Go Back</button>
        <button type="button" id="add_to_cartBtn" class="pull-right">
          <span
            class="glyphicon glyphicon-shopping-cart"
            aria-hidden="true"
          />
          &nbsp;&nbsp;Add to ShoppingCart
        </button>
        <h3 id="bookinfo_title"> </h3>
        <hr />
        <div class="row">
          <img src="<%=basePath %><s:property value="#request.product.imgUrl"/>" id="bookinfo_img" class="col-xs-5 half-shrink" alt="" />
          <div class="col-xs-7 bookinfo_detail">
            <small id="bookinfo_author">
              Name: &nbsp;<s:property value="#request.product.name"/>
            </small>
            <br />
            <small>
              Price: &nbsp;<s:property value="#request.product.price"/>
            </small>
            <br />
            <small>
              Rate: &nbsp;<s:property value="#request.product.rate"/>
            </small>
            <br />
          </div>
        </div>
        <hr />
        <h3>Categories</h3>
        <p id="bookinfo_categories"><s:property value="#request.product.category"/></p>
        <hr />
        <h3>Description</h3>
        <p id="bookinfo_description"><s:property value="#request.product.description"/></p>
      </div>
</body>
</html>
