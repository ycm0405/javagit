<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.entity.NRC_REVIEW"%>
<%@page import="com.news.dao.impl.NewsInfodaoImpl"%>
<%@page import="com.news.entity.NRC_NEWS"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>
<title>新闻发布系统</title>
<script type="text/javascript">
function Check(str1,str2){
	if(str1==""||str2==""){
		alert("内容和昵称不能为空");
		return false;
	}
	else{
		return true;
	}
}
</script>
</head>
<body>
<%String str=request.getParameter("info");
Object str1=request.getAttribute("lb");
int num=2;
if(str!=null){
	num=Integer.parseInt(str);
}else if(str1!=null){
	num=Integer.parseInt(str1.toString());
}
 ArrayList<NRC_NEWS> alist=new NewsInfodaoImpl().loadn(num);
 ArrayList<NRC_REVIEW> blist=new NewsInfodaoImpl().pinglun(num);
 pageContext.setAttribute("alist", alist);
 pageContext.setAttribute("blist", blist);
%>
<%-- <%=alist.size() %>
<%=blist.size() %> --%>
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
		<div class="doc-info-view">
			<c:forEach items="${alist }" var="nn">
			<div class="hd"><h1>${nn.n_TITLE }</h1></div>
			<hr class="double" />
			<!--[if !IE]>文章属性<![endif]-->
			<div class="doc-parameter">
				<div>${nn.n_PUBLISHTIME }</div>
			</div>
			<!--[if !IE]>正文<![endif]-->
			<div class="doc-text">
			${nn.n_CONTENT }
			</div>
			</c:forEach>
			<!--[if !IE]>评论<![endif]-->
			<hr class="double" />
			<div class="comment">
				<div class="hd"><h3>最新评论</h3></div>
				<!--[if !IE]>评论列表 开始<![endif]-->
				<ol class="com-list">
				    <c:forEach items="${blist }" var="pl">
				      <li>
						<p class="title wrapfix"><span class="num">${pl.r_ID }</span><span class="name">${pl.r_USERNAME }</span><span class="time">${pl.r_REVTIME }</span></p>
						<div class="com-body">
							${pl.r_CONTENT }
						</div>
					  </li>
				    </c:forEach>
					
				</ol>
				<!--[if !IE]>评论列表 结束<![endif]-->
				<!--[if !IE]>填写评论 开始<![endif]-->
				<div class="com-form">
				<hr class="double" />
					<div class="hd"><h3>发表评论</h3></div>
					<p class="tips">请自觉遵守互联网相关政策法规，评论不得超过250字。</p>
					<form id="form1" method="post" action="Infoselt?lb=<%=num %>" onsubmit="return Check(textarea.value,username.value)">
						<p><textarea name="textarea" id="textarea" rows="5" class="textarea"></textarea></p>
						<p>
							<label for="username">昵称</label><input type="text" name="username" size="10" id="username" class="iText" />
							<input type="submit" name="Submit" class="btn" value="发表评论" />
						</p>
					</form>
				</div>
				<!--[if !IE]>填写评论 开始<![endif]-->
			</div>
		</div>
		<!--[if !IE]>新闻详情 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.cnstrong.com.cn/" target="_blank">山东师创软件工程有限公司 </a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>