package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signUp")

public class SignUpServlet extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
	       
	
	        PrintWriter out = res.getWriter();

	        String name = req.getParameter("name");
	        String email = req.getParameter("email");
	        String phoneStr = req.getParameter("phone");
	        String password = req.getParameter("password");

	        long phone = 0;
	        try {
	            phone = Long.parseLong(phoneStr);
	        } catch (NumberFormatException e) {
	            out.println("Invalid phone number format.");
	            return;
	        }

	        Database dbc = new Database();
	        boolean success = dbc.insertData(name, email, phone, password);
	        
	        if (success) {
	            out.println("Sign up successful.");
	            RequestDispatcher rd = req.getRequestDispatcher("home");
				try {
					HttpSession session = req.getSession();
					session.setAttribute("useremail", email);
					rd.forward(req, res);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
	        } else {
	            out.println("Sign up failed!!!");
	             	
	            RequestDispatcher rd = req.getRequestDispatcher("signUp.html");
	        	try {
	        		rd.forward(req, res);
	        	} catch (ServletException | IOException e) {
	        		e.printStackTrace();
	        	}
	        		}
	        
	    }
}
