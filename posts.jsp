<%@page import="com.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Posts</h1>

	<%
		DBConnection db = new DBConnection();
		ArrayList<Post> posts = db.getPosts();
	%>

	<table border='1'>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Body</th>
		</tr>
		<%
			for (Post post : posts) {
		%>
		<tr>
			<td><%= post.getId()%></td>
			<td><%= post.getTitle()%></td>
			<td><%= post.getBody()%></td>
		</tr>
		<%
			}
		%>
	</table>


</body>
</html>