<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String servletSuffix = ".action";
%>
<html style="height: 100%;"> 
	<head>
		<title>welcome</title>
   <script src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>
   <link rel="stylesheet" href="<%=basePath %>/resources/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=basePath %>/resources/css/custom.css" />
    <link rel="stylesheet" href="<%=basePath %>/resources/css/fontawesome/css/font-awesome.css" />
	</head>
	<body style="height:100%;"> 

 <%-- <s:form action="loginAction.action" id="welcomeform" name="welcomeform" theme="simple"  onSubmit="return validateForm();"> --%>
 
 <input type="hidden" name="errorMessage" id="errorMessage">
 
 
 	  <div>
        <div class='row'>
            <div style="background:url('<%=basePath %>/resources/images/xjtlu.png'); background-repeat: no-repeat; background-size: 100% 100%;height:127px;"></div>            
        </div>
        <div class="row">
            <nav class="navbar navbar-inverse navbar-inverse-custom">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand navbar-brand-custom" href="">Digital Operation Analytics Applications</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">                    
        <div class="panel panel-info login-panel-custom">
            <div class="panel-heading panel-heading-custom">
                <div class="panel-title">Sign In</div>
            </div>     

            <div style="padding-top:30px" class="panel-body panel-body-custom " >

                <div style="display:none" id="login-alert" class="alert alert-danger col-md-12"></div>
                <form action="<%=basePath %>/loginAction<%=servletSuffix %>" id="loginform" class="form-horizontal" role="form" 
                      name="loginForm" validate >
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-user"></i>
                        </span>
                        <%-- <s:textfield id="username" type="text" 
                               class="form-control" name="username" value="" 
                               placeholder="Your Login ID"/>    --%>                                     
                        <input id="username" type="text" class="form-control" name="username" value="" 
                               placeholder="Your Login ID"/>                                        
                    </div>

                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-lock"></i>
                        </span>
                        <%-- <s:textfield id="password" type="password" 
                               class="form-control" 
                               name="password" placeholder="password" /> --%>
                        <input id="password" type="password" class="form-control" name="password" placeholder="password" />
                    </div>
                <div style="margin-top:10px" class="col-md-12">

                    <div class="col-md-4 col-md-offset-4">
                        <%-- <s:submit id="btn-login" type="submit" 
                                name="submit"
                                class="btn btn-success" /> --%>
                        <input id="btn-login" type="submit" 
                                name="submit"
                                class="btn btn-success" />
                                <br><br>
                               ${errorMessage }
                    <%-- <s:property value="errorMessage"/> --%>
                    </br></br>
                    </div>
                    
                  
                </div>                   
                </form>  
           </div>                     
        </div>  
    </div>
    </div>
    <nav class="navbar-inverse navbar-fixed-bottom">
        <div class="container-fluid">
            <div class="navbar-footer footer navbar-inverse-footer">
            Contact Us <a href="#"> (mailto:xxx@roche.com) </a>
            <br>
            Roche.,2015-2016 All rights reserved
        </div>
        </div>
    </nav>
    <script src="<%=basePath %>/resources/js/jquery-1.8.3.js"></script>
   <%--  <script>

        $(document).ready(function(){

              }
          })
        })
        
    </script> --%>
    <script type="text/javascript">
    $("form").submit(
        function validateForm() {
            /* var un = document.welcomeform.username.value;
            var pw = document.welcomeform.password.value; */
            var un = $("input[type=text]").val();
            var pw = $("input[type=password]").val();
            if ((un == "") || (pw == "")) {
                alert ("Login was unsuccessful, please provide your username and password");
                return false;
            }
            else {
                 return true;
            }
      });
    </script>
    
  
    
<%--   </s:form> --%>

	</body>
</html>