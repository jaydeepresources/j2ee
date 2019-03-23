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

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		PostDAOImpl impl = new PostDAOImpl();

		Post post = impl.view(id);

		request.getRequestDispatcher("search.jsp").include(request, response);

		out.println("Post found=" + post);

	}
}
