package basic.web.app;

import java.io.*;
import java.util.*;
import javax.servlet.*;

public class GreetingServlet implements Servlet{
	
	private ServletConfig config;

	public void init(ServletConfig cfg) throws ServletException{
		config = cfg;
	}

	public ServletConfig getServletConfig(){
		return config;
	}

	public String getServletInfo(){
		return "Simple Greeting Servlet";
	}

	public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>BasicWebApp</title></head>");
		out.println("<body>");
		out.println("<h1>Welcome Visitor</h1>");
		out.printf("<b>Time on server: </b>%s%n", new Date());
		out.println("</body>");
		out.println("</html>");
	}

	public void destroy(){}
}

