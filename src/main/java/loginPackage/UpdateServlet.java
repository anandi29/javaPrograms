package loginPackage;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		String fieldName = req.getParameter("field");
		String fieldValue = req.getParameter("fieldValue");
		System.out.println(fieldName);
		System.out.println(fieldValue);
		HttpSession session = req.getSession();
		String useremail = (String) session.getAttribute("useremail");
		Database d=new Database();
		System.out.println("useremail"+useremail);
		if(useremail!=null) {
		if(fieldName.equals("phonenumber")) {
			Long fieldData=Long.valueOf(fieldValue);
			d.UpdateData(useremail, fieldData);
		}
		else {
			d.UpdateData(useremail, fieldValue);
		}
		try {
			res.sendRedirect("home.jsp");
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
