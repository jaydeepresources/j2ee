<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

<h1>Login Page</h1>

	<form action="ControllerServlet">

		<input type="text" placeholder="enter user name" name="username">
		<br> 
		<input type="password" placeholder="enter password" name="password"> 
		<br> 
		<input type="submit" name = "buttonName" value="sign up">
		<input type="submit" name = "buttonName" value="sign in">

	</form>

</body>
</html>