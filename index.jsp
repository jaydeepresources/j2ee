<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL</title>
</head>
<body>

	<h1>
		<c:out value="Hello World" />
	</h1>

	<c:set var="username" scope="session" value="john" />
	username=
	<c:out value="${username}" />

	<c:if test="${username.length() > 0}">
		<p>Username= ${username} found</p>
	</c:if>

	<c:choose>
		<c:when test="${username.equals('john')}">  
       john is found  
    	</c:when>
		<c:when test="${username.equals('johnny')}">  
        johnny is found    
    	</c:when>
		<c:otherwise>  
       No clue who you are !
    	</c:otherwise>
	</c:choose>

	<c:forEach var="i" begin="0" end="3">
		<p>
			Values are=
			<c:out value="${i}" />
		</p>
	</c:forEach>
	
<%-- 	<c:redirect url="http://google.com"/>   --%>

</body>
</html>