
<%@page import="com.test.sku.servlet.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% List<User> list = (List<User>) request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 리스트</title>
</head>
<body>
<div id="main">
<h3> user List</h3>
<% 
for (int i = 0; i < list.size(); i++) { 
User u = list.get(i);%>
    <div><a href="user?cmd=detail&uid=<%=u.getUid()%>"><%=u.getUid()%></a> /<%=u.getPwd() %></div>
    
<%} %> 



 
</div>
</body>
</html>