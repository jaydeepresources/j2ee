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

	<h2>View Post Here</h2>

	<form action="ControllerServlet">
		<input type="submit" name="buttonName" value="view">
	</form>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>