<%@ page language="java" import="java.util.*, com.hsp.domain.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'hall.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>

		<h1>欢迎光临购物大厅</h1>
		<table border="1">
			<tr><th>书名</th><th>价格</th><th>出版社</th><th>点击购买</th></tr>
			
			<%
			//取出request中的ArrayList
			 ArrayList al =(ArrayList)request.getAttribute("books");
			 for(int i=0; i< al.size();i++){ 
			 Book book = (Book)al.get(i);
			 %>
			<tr><td><%=book.getName() %></td><td><%=book.getPrice() %></td>	<td><%=book.getPublishHouse()%></td><td>点击购买</td></tr>
			 <%}%>
			<tr><td colspan="4"><input type="button" value="Look" /></td></tr>

		</table>
		<a href="/myshopping">返回重新登陆</a>
	</body>
</html>
