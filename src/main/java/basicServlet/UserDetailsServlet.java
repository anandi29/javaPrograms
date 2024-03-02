package basicServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserDetailsServlet extends HttpServlet {
	public Connection con;   
	public Statement statement;
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        out.println("<h1>User Details</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone: " + phone + "</p>");
        
        String url = "jdbc:mysql://localhost:3306/ocean";
        String username = "root";
        String password = "root";
        
        String sql = "INSERT INTO person VALUES('anu', 'anandi@gmail.com',34565432)";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
				statement = con.createStatement();
				boolean result = statement.execute(sql);
				statement.close();
				con.close();
				System.out.println("data inserted"+result);
//			PreparedStatement preparedstmt = con.prepareStatement(sql);
//			preparedstmt.setString(1, sql)
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
        
    }
}

