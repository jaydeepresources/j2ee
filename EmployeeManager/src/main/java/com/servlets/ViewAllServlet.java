package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAOImpl;
import com.model.Employee;

@WebServlet("/viewall")
public class ViewAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

		List<Employee> list = employeeDAOImpl.view();

		for (Employee employee : list) {
			out.println("<h3>"+ employee +"</h3>");
		}

	}
}