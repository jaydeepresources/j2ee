package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Scope")
public class Scope extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("username");

		HttpSession session = request.getSession();
		ServletContext context = getServletContext();
		
		if (userName.length() > 0) {
			session.setAttribute("name", userName);
			context.setAttribute("name", userName);
		}

		out.println("by request=" + userName + "<br>");
		out.println("session id=" + session.getId() + "<br>");
		out.println("by session=" + session.getAttribute("name") + "<br>");
		out.println("by context=" + context.getAttribute("name") + "<br>");
	}

}
