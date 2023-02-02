package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAOImpl;
import com.model.Employee;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

		int count = employeeDAOImpl.delete(Integer.parseInt(request.getParameter("id")));

		out.print("<h3>Rows deleted: " + count + "</h3>");

	}
}