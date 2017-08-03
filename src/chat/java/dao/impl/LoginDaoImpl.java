package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {

	@Override
	public String executeLogin(String email, String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result="no";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="select * from login where email=? and password=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			result="yes";
			//updating status to online on login
			String query1="update login set status=? where email=?";
			PreparedStatement ps1=con.prepareStatement(query1);
			ps1.setString(1, "online");
			ps1.setString(2, email);
			ps1.executeUpdate();
		}
		
		return result;
	}

}
