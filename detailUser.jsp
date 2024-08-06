<%@page import="com.test.sku.servlet.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% User user = (User) request.getAttribute("deail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용자 상세보기</title>
</head>
<body>
<div id="main">
<h3>이용자 상세보기</h3>
<%=user.getUid() %> / <%=user.getPwd() %>


<div>
</body>
</html>