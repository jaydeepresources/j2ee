<%@page import="model.Post"%>
<%@page import="java.util.List"%>
<%@page import="dao.PostDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Post using Id</title>
</head>
<body>

	<%
		PostDAOImpl impl = new PostDAOImpl();
		List<Integer> listId = impl.viewId();
		if(request.getParameter("selectId") != null){
			listId.remove((Integer)(Integer.parseInt(request.getParameter("selectId"))));
		}
	%>

	<form action="delete_by_id.jsp">
		Select Id:<select name="selectId">

			<%
				for (Integer id : listId) {
					System.out.println(id);
			%>
			<option value="<%=id%>"><%=id%></option>
			<%
				}
			%>
		</select> <input type="submit" value="delete">

	</form>

	<%
		String stringId = request.getParameter("selectId");
		int id = 0;
		if (stringId != null) {
			id = Integer.parseInt(stringId);
			int res = impl.delete(id);
	%>

	<p><%=res%>
		rows deleted
	</p>

	<%
		}
	%>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>