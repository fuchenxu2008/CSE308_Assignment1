<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".action";
%>

<html>
<head>
<title> My Page
</title>
<script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script> 
<link href="<%=basePath %>/resources/css/main/style.css" rel="stylesheet" type="text/css">
   <link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/main.css"/>  
      <script type="text/javascript" src="<%=basePath %>/resources/js/main/main.js"></script> 
</head>
<body>
<%-- <s:form action="menusction.action" id="menu" name="menu" theme="simple"> --%>

 <div class="left_side_bar"> 
      <div class="col_1">
        <h1>Medicine Categories</h1>
        <div class="box">
          <ul>
            <li><a href="<s:url action="recommendation0"/>?number=1" onClick="activateItem(this)" id="menu1" name="menu1">Allergy</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=2" onClick="activateItem(this)" id="menu2" name="menu2">Phamacy & Health</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=3" onClick="activateItem(this)" id="menu3" name="menu3">Blood Pressure</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=4" onClick="activateItem(this)" id="menu4" name="menu4">Your Steps Dashboard</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=5" onClick="activateItem(this)" id="menu5" name="menu5">Today's Activities and Goals</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=6" onClick="activateItem(this)" id="menu6" name="menu6">Sports NutitionW</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=7" onClick="activateItem(this)" id="menu7" name="menu7">Women's Care</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=9" onClick="activateItem(this)" id="menu9" name="menu7">Child Care</a></li>
            <li><a href="<s:url action="recommendation0"/>?number=8" onClick="activateItem(this)" id="menu8" name="menu8">My Menu</a></li>
            <%-- <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=1" onClick="activateItem(this)" id="menu1" name="menu1">Allergy</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=2" onClick="activateItem(this)" id="menu2" name="menu2">Phamacy & Health</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=3" onClick="activateItem(this)" id="menu3" name="menu3">Blood Pressure</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=4" onClick="activateItem(this)" id="menu4" name="menu4">Your Steps Dashboard</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=5" onClick="activateItem(this)" id="menu5" name="menu5">Today's Activities and Goals</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=6" onClick="activateItem(this)" id="menu6" name="menu6">Sports NutitionW</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=7" onClick="activateItem(this)" id="menu7" name="menu7">Women's Care</a></li>
            <li><a href="<%=basePath %>/recommendation<%=servletSuffix %>?number=8" onClick="activateItem(this)" id="menu8" name="menu8">My Menu</a></li> --%>
           </ul>
        </div>
        </div>
      </div>
      <%-- </s:form> --%>
      </body>
</html>