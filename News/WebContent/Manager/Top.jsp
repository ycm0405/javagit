<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top</title>
<link href="Style/Top.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="top">
    <div id="time">您好，今天是<span id="date">2007年7月5日&nbsp;星期四</span></div>
    <script type="text/javascript">
			var d=new Date()
			document.getElementById("date").innerHTML=d.getFullYear()+"年"+(d.getMonth()+1)+"月"+d.getDate()+"日"+" 星期"+ "天一二三四五六 ".charAt(d.getDay());
		</script>
</div>
<div id="menuBg">
    <div id="name">管理员</div>
    <div id="menu">
		<a href="Main.jsp" target="mainFrame" id="home">首页</a>
		<a href="Login.jsp" target="_parent" id="quit">退出</a>	</div>
</div>
</body>
</html>