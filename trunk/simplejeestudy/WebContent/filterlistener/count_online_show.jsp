<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>count_online_show</title>
</head>
<body>
	<div align="center">${fn:length(allusers)}人在线，当前用户：${username }</div>
	<hr/>
	<table align="center" border="1">
	<tr>
		<th>序号</th>
		<th>在线人员</th>
	</tr>
	<c:forEach items="${allusers }" var="user" varStatus="status">
	<tr align="center">
		<td>${status.count}</td>
		<td>${user}</td>
	</tr>
	</c:forEach>
	</table>
	<div align="right"><a href="CountAccessServlet?flag=exit">退出</a></div>
</body>
</html>