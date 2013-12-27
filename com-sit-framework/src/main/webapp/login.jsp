<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
java.util.ResourceBundle  bundlePath = java.util.ResourceBundle.getBundle("resources//base_config");
String jsBasePath=bundlePath.getString("js");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆 </title>
    <link rel="icon" href="images/heat.ico" type="image/x-icon" />
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="Heat">
	<meta http-equiv="description" content="Heat">
	
	<link rel="stylesheet" type="text/css" href="<%=jsBasePath%>/extjs/resources/css/ext-all.css" />
	<style type="text/css">
		.app-heatIcon{background-image: url(images/heat.png) !important;}
		.app-homeIcon {background-image: url(images/icon/home.png) !important;}
	</style>
	
	<script type="text/javascript" src="<%=jsBasePath%>/extjs/ext-all-debug.js"></script>
<!-- 	<script type="text/javascript" src="js/extjs/bootstrap.js"></script> -->
	<script type="text/javascript" src="<%=jsBasePath%>/extjslocale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="login/login.js"></script>
	<script type="text/javascript" src="js/cryptojs.js"></script>
	<script type="text/javascript">
	
		Ext.Loader.setPath({
			'Ext.LoginApp' : 'login'
		});
		
		Ext.appPath = '<%=path%>';
		Ext.BLANK_IMAGE_URL = 'images/s.gif';
		Ext.tip.QuickTipManager.init();
		
		Ext.onReady(function() {
			Ext.Loader.setConfig({enabled:true}); 
			loginPage = Ext.create('Ext.LoginApp.Login').show(Ext.getBody());
		});
	</script>

  </head>
  
  <body style='background-color:#bad0ee;'>
<%-- 	<%
		HttpSession ses=request.getSession();
		String sesname= (String)ses.getAttribute("LOGIN_CAPTCHA") ;
		String sesname_2= (String)ses.getAttribute("LOGIN_CAPTCHA_2") ;
	%>
 	<script>
		var namese = '<%=sesname %>';
		var namese2 = '<%=sesname_2 %>';
	</script> --%>

  </body>
</html>
