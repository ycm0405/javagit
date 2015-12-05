<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.news.bean.*"%>
<%@ page import="com.news.service.impl.*"%>
<%@ page import="com.news.util.*"%>
<%@ page import="com.news.service.*"%>

<%
	String ctx=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻列表</title>
<link href="http://localhost:8080/News/Manager/Style/Css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<h3 class="subTitle">新闻资讯</h3>
<ul class="button">
	<li><a href="<%=ctx %>/news.do?method=findallnewstype">添加新闻</a></li>
</ul>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	<tr>
	    <th width="8%" nowrap="nowrap">序号</th>
	    <th nowrap="nowrap">标题</th>
	    <th width="15%" nowrap="nowrap">日期</th>
	    <th width="12%">修改</th>
	    <th width="12%">删除</th>
	</tr>
<%
	int pagecount=0;
	int newscount=0;
	int currentpage;//当前页面id
	NewsService newsservice=new NewsServiceImpl();
	List<NewsBean> newslist=newsservice.findAll();
	NewsBean news=new NewsBean();
	//总记录数
	newscount=newslist.size();
	String b=(String)request.getAttribute("apagecount");
	//System.out.print(b.length());
	if(b!=null){
		currentpage=Integer.parseInt(request.getAttribute("pageid").toString());
		System.out.print(currentpage);
	}else{
		currentpage=1;
	}
	//每个页面的记录条数
	int apagecount;
	String a=(String)request.getAttribute("apagecount");
	if(a==null){
		apagecount=10;
	}else{
		apagecount=	Integer.parseInt(String.valueOf(request.getAttribute("apagecount")));
	}
	
	System.out.print(apagecount);
	//首页加载时
	if(currentpage==1){
		if(newslist.size()<apagecount){
			//记录数
			apagecount=newslist.size();
		}
		//一共的页数
		pagecount=(apagecount%10==0)?(apagecount/5):(apagecount/5+1);
		System.out.print(pagecount);
		for(int i=0;i<apagecount;i++){
			news=newslist.get(i);
			
	%>
		<tr>
		    <td align="center"><%=news.getN_id() %></td>
		    <td align="center"><%=news.getN_title() %></td>
		    <td align="center"><%=news.getN_publishtime() %></td>
		    <td align="center"><a href="<%=ctx %>/news.do?method=findnewsbyid&id=<%=news.getN_id() %>">修改</a></td>
		    <td align="center"><a href="<%=ctx %>/news.do?method=delete&id=<%=news.getN_id() %>">删除</a></td>
		</tr>
	<%
			
		}
	}else{
		//不是首页加载时
		
	}
%>


</table>
<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="page">
	<tr>
		<td width="50%" align="left">共有<%=newscount %>条记录，<span style="font-family:宋体; font-size:9.0pt; color:black; ">第</span><span style="font-family:Tahoma; font-size:9.0pt; color:black; "> <%=1 %>/<%=pagecount %> </span><span style="font-family:宋体; font-size:9.0pt; color:black; ">页</span></td>
		<td width="50%" align="right">
			<a href="<%=ctx %>/news.do?method=findnewsbypage&pageid=1">首页</a> 
			<a href="<%=ctx %>/news.do?method=findnewsbypage&pageid=pageid-1">上一页</a> 
			<a href="<%=ctx %>/news.do?method=findnewsbypage&pageid=pageid+1">下一页</a> 
			<a href="#">末页</a>跳转到
	    <select name="select2">
<% 
		for(int i=1;i<=pagecount;i++){
%>		
	<option><%=i %></option>
<% 	
		}
%> 
	    </select>
		</td>
	</tr>
</table>

</body>
</html>
