<%@page import="com.news.entity.NRC_NEWS"%>
<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.entity.NRC_TYPE"%>
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
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
<title>新闻发布系统</title>
</head>
<body>
<%int pageNo=1;
String str=request.getParameter("pageNo");
if(str!=null){
	pageNo=Integer.parseInt(request.getParameter("pageNo"));
};
%>
<%ArrayList<NRC_NEWS> alist;
if(request.getAttribute("alist")==null){
	alist=(ArrayList<NRC_NEWS>)session.getAttribute("alist");
}else{
	alist=(ArrayList<NRC_NEWS>)request.getAttribute("alist");
}
int pageall=alist.size();
int pagezu=1;
int pageallzu;
if(pageall%pagezu!=0){
	pageallzu=pageall/pagezu;
}else{
	pageallzu=pageall/pagezu-1;
}%>
<% 
session.setAttribute("alist", alist);
%>
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
		<div class="newslist">
			<div class="hd"><h3>搜索结果</h3></div>
			<div class="bd">
				<ul class="list">
				    <c:forEach items="${alist }" var="news" begin="<%=(pageNo-1)*pagezu %>" end="<%=pageNo*pagezu-1 %>">
				       <li><span class="category">[${news.t_ID }]</span><a href="Info.jsp?info=${news.n_ID }" target="_blank">${news.n_TITLE}</a><span class="date">${news.n_PUBLISHTIME }</span></li>
				    </c:forEach>
				</ul>
			</div>
		</div>
		<!--[if !IE]>newslist 结束<![endif]-->
		<div class="paging wrapfix">
		    <c:choose>
		       <c:when test="<%=(pageall==0) %>"><div class="total">共有0条记录&nbsp;当前1/1页</div></c:when>
		       <c:when test="<%=(pageall!=0) %>"><div class="total">共有<%=pageall %>条记录&nbsp;当前<%=pageNo %>/<%=pageallzu+1 %>页</div></c:when>
		    </c:choose>
			<div class="pn">
			  <c:if test="<%=(pageall!=0) %>">
			    <c:choose>
				       <c:when test="<%=(pageNo==1) %>">上一页</c:when>
				       <c:when test="<%=(pageNo!=1) %>"><a href="Search.jsp?pageNo=<%=pageNo-1 %>" title="上一页" class="nobar">上一页</a></c:when>
				</c:choose>
				<%int xbi=0; %>
				<c:forEach  begin="0" end="<%=pageallzu %>" >
					  <%xbi++; %>
					  <c:choose>
					     <c:when test="<%=(xbi==pageNo) %>"><a href="Search.jsp?pageNo=<%=xbi %>" class="nonce"><%=xbi %></a></c:when>
					     <c:when test="<%=(xbi!=pageNo) %>"><a href="Search.jsp?pageNo=<%=xbi %>"><%=xbi %></a></c:when>
					  </c:choose>
				</c:forEach>
				<c:choose>
					  <c:when test="<%=(pageNo==pageallzu+1) %>">下一页</c:when>
					  <c:when test="<%=(pageNo!=pageallzu+1) %>"><a href="Search.jsp?pageNo=<%=pageNo+1 %>" title="下一页" class="nobar">下一页</a></c:when>
				</c:choose>
			  </c:if>
			</div>
		</div>
		<!--[if !IE]>paging 结束<![endif]-->

	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.cnstrong.com.cn/" target="_blank">山东师创软件工程有限公司 </a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>