package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAOImpl;
import model.Post;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String title = request.getParameter("title");
		String body = request.getParameter("body");

		PostDAOImpl impl = new PostDAOImpl();

		System.out.println("add");
		
		int res = impl.insert(new Post(0, title, body));
		
		request.getRequestDispatcher("add.jsp").include(request, response);

		out.println("Rows inserted=" + res);

	}

}
