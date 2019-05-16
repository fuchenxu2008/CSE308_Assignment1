<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".action";
%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Recommendation</title>
             <link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/main.css"/>  
              <link rel="stylesheet" type="text/css" href="<%=basePath %>/resources/css/main/style.css"/>  
    </head>
    <body>
    	<h3>Welcome, ${client.short_name }&nbsp;&nbsp;&nbsp; You are in ${client.address }</h3>
        <table border="0" cellpadding="0" cellspacing="0" align="center"  bordercolor="#F8F8F8">
            <tr> 
                <td colspan="2" width="700px" >   
                	<jsp:include page="/pages/header.jsp" flush="true" />
                    <!-- <tiles:insertAttribute name="header" /> --> 
                </td> 
            </tr>  
            <tr> 
          
                <td id="menuList" >  
                    <!-- <tiles:insertAttribute name="menu" />  --> 
                    <jsp:include page="/pages/menu.jsp" flush="true" />
                </td>
                <td  bgcolor="#FF0000">        
                    <!-- <tiles:insertAttribute name="body" />     -->
                    <jsp:include page="/pages/recommendation.jsp" flush="true" />
                </td>   
            </tr>   
             <tr> 
                <td height="30" colspan="2"> 
                    <!-- <tiles:insertAttribute name="footer" /> --> 
                    <jsp:include page="/pages/footer.jsp" flush="true" />
                </td>
            </tr> 
        </table>
    </body>
</html>