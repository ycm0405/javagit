<%@page import="com.news.entity.NRC_TYPE"%>
<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.dao.NewsIndexdao"%>
<%@page import="com.news.entity.NRC_NEWS"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<title>新闻发布系统</title>
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
</head>
<body>
<% ArrayList<NRC_NEWS> alist=new NewsIndexdaoImpl().loadnews();
ArrayList<NRC_NEWS> hlist=new NewsIndexdaoImpl().hotdnews();
ArrayList<NRC_TYPE> blist=new NewsIndexdaoImpl().loadtype();
pageContext.setAttribute("alist", alist);
pageContext.setAttribute("blist", blist);
pageContext.setAttribute("hlist", hlist);
%>

<div id="wrapper">
	<div id="header">
		<div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="Searchindex" >
				<input type="text" name="textfield" id="textfield" class="iText" />
				<select name="select">
					<option selected="selected">标题</option>
					<option>内容</option>
				</select>
				<input type="submit" name="Submit" class="btn" value="搜索" />
			</form>
		</div>
		<!--[if !IE]>search 结束<![endif]-->
	</div>
	<!--[if !IE]>header 结束<![endif]-->
	<div id="main" class="wrapfix">
		<div id="mostlyCon">
			<div class="newslist">
				<div class="hd"><h3>新闻头条</h3></div>
				<div class="bd">
					<ul class="list">
					    <c:forEach items="${alist }" var="news" begin="0" end="9">
					    <li><span class="category">[${news.t_ID }]</span><a href="Info.jsp?info=${news.n_ID }" target="_blank">${news.n_TITLE}</a><span class="date">${news.n_PUBLISHTIME }</span></li>
					    </c:forEach>
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
			<div class="newslist">
				<div class="hd"><h3>热点新闻</h3></div>
				<div class="bd">
					<ul class="list">
					    <c:forEach items="${hlist }" var="news" >
					    <li><span class="category">[${news.t_ID }]</span><a href="Info.jsp?info=${news.n_ID }" target="_blank">${news.n_TITLE}</a><span class="date">${news.n_PUBLISHTIME }</span></li>
					    </c:forEach>
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<h3>新闻类别</h3>
				<ul>
				    <c:forEach items="${blist }" var="tp">
				      <li><a href="List.jsp?type=${tp.t_ID }" >${tp.t_NAME }</a></li>
				    </c:forEach>
				</ul>
			</div>
		</div>
		<!--[if !IE]>sideCon 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.cnstrong.com.cn/" target="_blank">山东师创软件工程有限公司 </a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>