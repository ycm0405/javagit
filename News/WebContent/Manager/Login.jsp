<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="Keywords" content="关键词1,关键词2，关键词3,关键词4,……" />
<meta name="Description" content="你网页的简述" />
<meta name="Robots" content="All" />
<meta name="Generator" content="Dreamweaver" />
<meta name="Author" content="FifthMouse，email" />
<meta name="Copyright" content="Strong Software All Rights Reserved" />
<title>新闻发布后台管理系统</title>
<link href="Style/Login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
	<form id="form1" name="form1" action="../LoginServlet" method="post">
		<div class="login">
			<div>
				<label for="username">用 户 名</label>
				<input type="text" name="username" id="username" />
			</div>
			<div>
				<label for="password">密　　码</label>
				<input type="password" name="password" id="password" />
			</div>
			<div class="button">
				<input type="submit" name="Submit" value="登录" />　
				<input type="reset" name="Submit" value="重置" />
			</div>
		</div>
	</form>
</div>
</body>
</html>