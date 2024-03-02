package basicServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int number1 = Integer.valueOf(req.getParameter("number1"));
		int number2 = Integer.valueOf(req.getParameter("number2"));
		PrintWriter writer = res.getWriter();
		int result=number1+number2;
		writer.print("<h1>result= "+result+"</h1>");
		
	}

}
