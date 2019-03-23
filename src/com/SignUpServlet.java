package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAOImpl;
import model.User;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		UserDAOImpl impl = new UserDAOImpl();

		boolean status = impl.signUp(new User(0, request.getParameter("username"), request.getParameter("password")));

		HttpSession session = request.getSession();
		session.setAttribute("loginStatus", true);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
