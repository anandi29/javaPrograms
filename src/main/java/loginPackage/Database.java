package loginPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public Connection con;
	public Statement stmt;
	public Database() {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails","root","root");
			stmt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean insertData(String name,String email ,long phone, String password)  {
		if(!readData(email)) {
			String query="insert into student values(?,?,?,?)";
			try {
				PreparedStatement prestmt = con.prepareStatement(query);
				prestmt.setString(1, name);
				prestmt.setString(2, email);
				prestmt.setLong(3, phone);
				prestmt.setString(4, password);
				int result = prestmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	public boolean readData(String email) {
		String query="select * from student where email=?";
		try {
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setString(1, email);
			
			ResultSet resultSet = prestmt.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ResultSet displayData(String email) {
		String query="select * from student where email=? ";
		try {
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setString(1, email);
			ResultSet resultSet = prestmt.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			return null;
			
		}
	}
	public boolean readData(String email, String password) {
		String query="select * from student where email=? and password=?";
		try {
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setString(1, email);
			prestmt.setString(2, password);
			ResultSet resultSet = prestmt.executeQuery();
			if(resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean UpdateData(String email, long fieldValue) {
		
		String query="update student set phone=? where email=?";
		
		try {
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setLong(1, fieldValue);
			prestmt.setString(2, email);
			int result = prestmt.executeUpdate();
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
public boolean UpdateData(String email, String fieldValue) {
		
		String query="update student set name=? where email=?";
		
		try {
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setString(1, fieldValue);
			prestmt.setString(2, email);
			int result = prestmt.executeUpdate();
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
public boolean deleteData(String email) {
	
	String query="delete from student where email=?";
	
	try {
		PreparedStatement prestmt = con.prepareStatement(query);
		prestmt.setString(1, email);
		int result = prestmt.executeUpdate();
			return true;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}

}
