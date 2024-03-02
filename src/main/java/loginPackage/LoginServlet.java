package loginPackage;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String email = req.getParameter("email");
		String password=req.getParameter("password");
		Database databaseInstance=new Database();
		boolean result = databaseInstance.readData(email, password);
		if(result) {
			RequestDispatcher rd = req.getRequestDispatcher("home");
			try {
				HttpSession session = req.getSession();
				session.setAttribute("useremail", email);
				rd.forward(req, res);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("signUp.html");
			try {
				rd.forward(req, res);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
