<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.entity.NRC_TYPE"%>
<%@page import="com.news.entity.NRC_NEWS"%>
<%@page import="com.news.dao.impl.NewsListdaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%
String str1=request.getParameter("type");
int tt=1;
if(!str1.equals(null)){
	tt=Integer.parseInt(str1);
}
ArrayList<NRC_NEWS> alist =new NewsListdaoImpl().load(tt);
ArrayList<NRC_TYPE> blist=new NewsIndexdaoImpl().loadtype();
pageContext.setAttribute("alist", alist);
pageContext.setAttribute("blist", blist);
%>
<%int pageNo=1;
String str=request.getParameter("pageNo");
if(str!=null){
	pageNo=Integer.parseInt(request.getParameter("pageNo"));
};
%>
<%

int pageall=0;
int pagezu=10;
int pageallzu=1;
boolean stop;
if(alist.size()!=0){
	pageall=alist.size();
	if(pageall%pagezu!=0){
		pageallzu=pageall/pagezu;
	}else{
		pageallzu=pageall/pagezu-1;
	}
	stop=true;
}else{
	stop=false;
}
%>
<div id="wrapper">
	<div id="header">
		<div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="Searchlist?type=<%=tt %>">
				<input type="text" name="textfield" id="textfield" class="iText" />
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
					    <c:if test="<%=stop %>">
					       <c:forEach items="${alist }" var="n" begin="<%=(pageNo-1)*pagezu %>" end="<%=pageNo*pagezu-1 %>">
					    	  <li><span class="category">[${n.t_ID}]</span><a href="Info.jsp?info=${n.n_ID }" target="_blank"  >${n.n_TITLE }</a><span class="date">${n.n_PUBLISHTIME }</span></li>
					       </c:forEach>
					    </c:if>
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
			<div class="paging wrapfix">
			    <c:choose>
			       <c:when test="<%=stop %>"><div class="total">共有<%=pageall %>条记录&nbsp;当前<%=pageNo %>/<%=pageallzu+1 %>页</div></c:when>
			       <c:when test="<%=!stop %>"><div class="total">共有<%=pageall %>条记录&nbsp;当前<%=pageNo %>/<%=pageallzu %>页</div></c:when>
			    </c:choose>
				<div class="pn">
				    <c:if test="<%=stop %>">
				    <c:choose>
				       <c:when test="<%=(pageNo==1) %>">上一页</c:when>
				       <c:when test="<%=(pageNo!=1) %>"><a href="List.jsp?pageNo=<%=pageNo-1 %>&type=<%=str1 %>" title="上一页" class="nobar">上一页</a></c:when>
				    </c:choose>
				    <%int xbi=0; %>
					<c:forEach  begin="0" end="<%=pageallzu %>" >
					   <%xbi++; %>
					   <c:choose>
					      <c:when test="<%=(xbi==pageNo) %>"><a href="List.jsp?pageNo=<%=xbi %>&type=<%=str1 %>" class="nonce"><%=xbi %></a></c:when>
					      <c:when test="<%=(xbi!=pageNo) %>"><a href="List.jsp?pageNo=<%=xbi %>&type=<%=str1 %>"><%=xbi %></a></c:when>
					   </c:choose>
					</c:forEach>
					<c:choose>
					   <c:when test="<%=(pageNo==pageallzu+1) %>">下一页</c:when>
					   <c:when test="<%=(pageNo!=pageallzu+1) %>"><a href="List.jsp?pageNo=<%=pageNo+1 %>&type=<%=str1 %>" title="下一页" class="nobar">下一页</a></c:when>
					</c:choose>
				    </c:if>
				</div>
			</div>
			<!--[if !IE]>paging 结束<![endif]-->
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<h3>新闻类别</h3>
				<ul>
				    <c:forEach items="${blist }" var="nn">
				    <li><a href="List.jsp?type=${nn.t_ID }&pageNo=${1}">${nn.t_NAME }</a></li>
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