package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chat.java.dao.SignUpDao;

public class SignUpDaoImpl implements SignUpDao {

	@Override
	public String signUp(String fullName, String email, String password, String dateOfBirth, String gender)
			throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result="no";
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="insert into registration values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, fullName);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, dateOfBirth);
		ps.setString(5, gender);
		
		if(ps.executeUpdate()>0) {
			result="yes";
			String query1="insert into login(email, password, status, gender) value(?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(query1);
			ps1.setString(1, email);
			ps1.setString(2, password);
			ps1.setString(3, "offline");
			ps1.setString(4, gender);
			ps1.executeUpdate();
		
		}
		
		return result;
	}

}
