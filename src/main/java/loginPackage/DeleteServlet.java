package loginPackage;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) {
		Database d=new Database();
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("useremail");
		if(email !=null) {
			session.removeAttribute("useremail");
			d.deleteData(email);
			try {
				res.sendRedirect("login.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else {
			try {
				res.sendRedirect("login.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
