<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.dao.impl.CategoryListdaoImpl"%>
<%@page import="com.news.entity.NRC_TYPE"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="zh-CN" />

<title>新闻类别管理</title>
<link href="../Style/Css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function Gotojs(){
	var str=document.getElementById(select2).value;
	alert(str);
}
</script>
</head>
<body>
<%
ArrayList<NRC_TYPE> alist=new NewsIndexdaoImpl().loadtype();
pageContext.setAttribute("alist", alist);
%>
<%int pageNo=1;
String str=request.getParameter("pageNo");
String str1=request.getParameter("select2");
System.out.println(pageNo);
if(str!=null){
	pageNo=Integer.parseInt(str);
}else if(str1!=null){
	pageNo=Integer.parseInt(str1);
}
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
<%int sele; %>
<h3 class="subTitle">
	新闻类别
</h3>

<ul class="button">
	<li><a href="CategoryAdd.jsp">添加类别</a></li>
</ul>

<form id="form2" name="form2" method="post" action="CategoryList.jsp" >  
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
        <tr>
						<th width="8%" nowrap="nowrap">序号</th>
						<th nowrap="nowrap">类别名称</th>
						<th width="12%" nowrap="nowrap">修改</th>
						<th width="12%" nowrap="nowrap">删除</th>
        </tr>
        <c:forEach items="${alist }" var="us" begin="<%=(pageNo-1)*pagezu %>" end="<%=pageNo*pagezu-1 %>">
              <tr>
						<td align="center">${us.t_ID }</td>
                        <td align="center">${us.t_NAME }</td>
						<td align="center"><a href="../../CategoryModify?type=${us.t_ID }">修改</a></td>
						<td align="center"><a href="../../CategoryList?tid=${us.t_ID }">删除</a></td>
			  </tr>
        </c:forEach>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="page">
        <tr>
            <td width="50%" align="left">共有<%=pageall %>条记录，<span style="font-family:宋体; font-size:9.0pt; color:black; ">第</span><span style="font-family:Tahoma; font-size:9.0pt; color:black; "> <%=pageNo %>/<%=pageallzu+1 %> </span><span style="font-family:宋体; font-size:9.0pt; color:black; ">页</span></td>
            <td width="50%" align="right">
               <c:choose>
                  <c:when test="<%=pageNo==1 %>"><a>首页</a> <a>上一页</a> </c:when>
                  <c:when test="<%=pageNo!=1 %>"><a href="CategoryList.jsp?pageNo=1">首页</a> <a href="CategoryList.jsp?pageNo=<%=pageNo-1 %>">上一页</a></c:when>
               </c:choose>
               <c:choose>
                   <c:when test="<%=pageNo==pageallzu+1 %>"><a >下一页</a><a>末页</a></c:when>
                   <c:when test="<%=pageNo!=pageallzu+1 %>"><a href="CategoryList.jsp?pageNo=<%=pageNo+1 %>">下一页</a><a href="CategoryList.jsp?pageNo=<%=pageallzu+1%>">末页</a></c:when>
               </c:choose>跳转到
               <select name="select2" id="select2" onchange="form2.submit()">
                   <%int num=0; %>
                   <c:forEach begin="0" end="<%=pageallzu %>">
                       <%num++; %>
                       <c:choose>
                           <c:when test="<%=num==pageNo %>"><option selected="selected" value="<%=num %>" ><%=num %></option></c:when>
                           <c:when test="<%=num!=pageNo %>"><option value="<%=num %>"><%=num %></option></c:when>
                       </c:choose>
                   </c:forEach>
                </select>
            </td>
        </tr>
    </table>
</form>
</body>
</html>