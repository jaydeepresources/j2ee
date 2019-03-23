<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Post</title>
</head>
<body>

<%
	if(request.getSession(false).getAttribute("loginStatus") == null)
		response.sendRedirect("http://localhost:8080/PostsCRUD/login.jsp");
%>

	<h2>Add Post Here</h2>

	<form action="ControllerServlet">
		<input type="text" name="title" placeholder="enter title"><br>
		<input type="text" name="body" placeholder="enter body"><br>
		<input type="submit" name="buttonName" value="add">
	</form>
	
	<br /><br />
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>