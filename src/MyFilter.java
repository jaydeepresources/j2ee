import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) req).getSession();

		String user = req.getParameter("name");
		String password = req.getParameter("password");

		if (user != null && password != null && password.equals("admin")) {
			session.setAttribute("user", user);
			System.out.println("Name in session=" + session.getAttribute("user"));
			chain.doFilter(req, resp);// sends request to next resource
		}

		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}	
	}

	public void destroy() {
		
	}

}
