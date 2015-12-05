<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.news.entity.NRC_REVIEW"%>
<%@page import="com.news.dao.impl.NewsInfodaoImpl"%>
<%@page import="com.news.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.news.dao.impl.NewsIndexdaoImpl"%>
<%@page import="com.news.entity.NRC_NEWS"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
<%=JOptionPane.showConfirmDialog(null, "是否删除", "删除提示", JOptionPane.YES_NO_OPTION) %>
<%-- <%ArrayList<NRC_REVIEW> blist=new NewsInfodaoImpl().pinglun(2);
%>

<% List<NRC_NEWS> alist=new NewsIndexdaoImpl().loadnews();
%>
<% %>  
<%session.setAttribute("alist", alist);%>
<a href="NewFile1.jsp" >to</a> --%>
<%-- <c:forEach items="${alist }" var="NRC_NEWS1">
<% %>
${NRC_NEWS1.t_ID } ,${NRC_NEWS1.n_TITLE },${NRC_NEWS1.n_PUBLISHTIME }<br>
</c:forEach>
<c:forEach items="${blist }" var="bb">
<% %>
$bb.r_ID } ,${bb.r_CONTENT },<br>
</c:forEach> --%>
</body>
</html>