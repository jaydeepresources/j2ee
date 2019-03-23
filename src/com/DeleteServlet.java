package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAOImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		PostDAOImpl impl = new PostDAOImpl();

		int res = impl.delete(id);

		if (request.getParameter("origin") != null) {
			request.getRequestDispatcher("view_all.jsp").forward(request, response);
		}

		request.getRequestDispatcher("delete.jsp").include(request, response);

		out.println("Rows deleted=" + res);
	}

}
