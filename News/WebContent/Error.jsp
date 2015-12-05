<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
<title>新闻发布系统</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="Searchsh">
				<input type="text" name="textfield" id="textfield" class="iText" />
				<input type="submit" name="Submit" class="btn" value="搜索" />
			</form>
		</div>
		<!--[if !IE]>search 结束<![endif]-->
	</div>
	<!--[if !IE]>header 结束<![endif]-->
	<div id="main">
		<div class="error">
			<p>出错啦。。。</p>
			<p><a href="Index.jsp">返回首页，查看其它的文章</a></p>
		</div>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.cnstrong.com.cn/" target="_blank">山东师创软件工程有限公司 </a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>