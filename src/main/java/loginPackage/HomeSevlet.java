package loginPackage;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeSevlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session = req.getSession();
		String useremail = (String)session.getAttribute("useremail");
		if(useremail!=null) {
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			try {
				rd.forward(req, res);
			} catch (ServletException | IOException e) {
				
				e.printStackTrace();
			}
		}
		else{
	RequestDispatcher rd = req.getRequestDispatcher("login.html");
	try {
		rd.forward(req, res);
	} catch (ServletException | IOException e) {
		e.printStackTrace();
	}
		}
	}
}
