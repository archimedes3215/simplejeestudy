<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>count_access_show</title>
</head>
<body>
	<table align="center">
	<tr>
	<th>序号</th><th>URI</th><th>访问次数</th>
	</tr>
	<c:forEach items="${entriesList }" var="entry" varStatus="status">
	<tr align="center">
		<td>${status.count}</td>
		<td>${entry.key}</td>
		<td>${entry.value}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>