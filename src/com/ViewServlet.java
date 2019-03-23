package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAOImpl;
import model.Post;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		PostDAOImpl impl = new PostDAOImpl();

		List<Post> list = impl.view();
		
		out.print("<style>\n" + 
				"        body {\n" + 
				"            font-family: Arial, Helvetica, sans-serif;\n" + 
				"        }\n" + 
				"\n" + 
				"        table {\n" + 
				"            border-collapse: collapse;\n" + 
				"            width: 30%;\n" + 
				"        }\n" + 
				"\n" + 
				"        th, td {\n" + 
				"            text-align: left;\n" + 
				"            padding: 8px;\n" + 
				"        }\n" + 
				"\n" + 
				"        tr:nth-child(even) {\n" + 
				"            background-color:gainsboro;\n" + 
				"        }\n" + 
				"    </style>");

		out.println("<table>");
		out.println("<tr>");
		out.println("<th>");
		out.println("ID");
		out.println("</th>");
		out.println("<th>");
		out.println("TITLE");
		out.println("</th>");
		out.println("<th>");
		out.println("BODY");
		out.println("</th>");
		out.println("</tr>");

		for (Post post : list) {
			out.println("<tr>");
			out.println("<td>");
			out.println(post.getId());
			out.println("</td>");
			out.println("<td>");
			out.println(post.getTitle());
			out.println("</td>");
			out.println("<td>");
			out.println(post.getBody());
			out.println("</td>");
			out.println("</tr>");
		}

		out.println("</table>");

	}

}
