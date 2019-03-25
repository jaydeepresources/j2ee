package inter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InterServlet")
public class InterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Locale locale = request.getLocale(); 
		String language = locale.getLanguage();
		String country = locale.getCountry();
		
		response.setHeader("Content-Language", "fr");

		String french = "Suzanne et Joseph étaient nés dans les deux premières années de leur arrivée à la colonie.";
		
		out.println("<h1>Locale= " + locale + "</h1>");
		out.println("<h1>Language= " + language + "</h1>");
		out.println("<h1>Country= " + country + "</h1>");
		out.println("<h1>" + french + "</h1>");
	}

}
