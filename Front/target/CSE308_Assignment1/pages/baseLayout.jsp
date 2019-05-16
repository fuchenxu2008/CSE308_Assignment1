<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".do";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><tiles:insertAttribute name="title" ignore="true" /></title>
            <script type="text/javascript" src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script> 
             <link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/main.css"/>  
              <link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/style.css"/>  
    </head>
    <body>
        <table border="0" cellpadding="0" cellspacing="0" align="center"  bordercolor="#F8F8F8">
            <tr> 
                <td colspan="2" width="700px" >   
                    <tiles:insertAttribute name="header" /> 
                </td> 
            </tr>  
            <tr> 
          
                <td id="menuList" >  
                    <tiles:insertAttribute name="menu" />  
                </td>
                <td  bgcolor="#FF0000">        
                    <tiles:insertAttribute name="body" />    
                </td>   
            </tr>   
             <tr> 
                <td height="30" colspan="2"> 
                    <tiles:insertAttribute name="footer" /> 
                </td>
            </tr> 
        </table>
    </body>
</html>
