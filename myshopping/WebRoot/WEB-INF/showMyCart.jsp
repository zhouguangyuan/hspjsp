<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMyCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="com.css">
	-->

  </head>
  
  <body>
    <h1>我的购物车</h1>
    <form action="?" method="post">
    <table border="1" style="border-collapse:collapse;">
    <tr><td>bookid</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td><td>删除</td></tr>
    <tr><td>1</td><td>笑傲江湖</td><td>200</td><td>清华出版社</td><td><input type='text' name='booknum' />本</td><td><a href="#">删除</a></td></tr>
    <tr><td>2</td><td>笑傲江湖</td><td>200</td><td>清华出版社</td><td><input type='text' name='booknum' />本</td><td><a href="#">删除</a></td></tr>
    <tr><td>3</td><td>笑傲江湖</td><td>200</td><td>清华出版社</td><td><input type='text' name='booknum' />本</td><td><a href="#">删除</a></td></tr>
    <tr><td colspan="6"><input type="submit" value="update"/></td></tr>
    <tr><td>购物车所有商品总金额：550元</td></tr>
    </table>
    </form>
  </body>
</html>
