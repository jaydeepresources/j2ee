<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Reading information using beans</h1>
	
	<jsp:useBean id="user" class="bean.User"></jsp:useBean>
	
	<jsp:setProperty property="*" name="user"/>
	
	Username= <jsp:getProperty property="username" name="user"/> <br>
	Password= <jsp:getProperty property="password" name="user"/>
	
</body>
</html>