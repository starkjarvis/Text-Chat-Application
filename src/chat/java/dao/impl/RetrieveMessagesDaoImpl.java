package chat.java.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chat.java.dao.RetrieveMessagesDao;

public class RetrieveMessagesDaoImpl implements RetrieveMessagesDao {

	@Override
	public ResultSet retrieveMessages(String from, String to) throws SQLException {
		ResultSet res=null;
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
    		String query="select * from chat1 where from1=? or from1=? order by date_time";
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setString(1, from);
    		ps.setString(2, to);
    		res=ps.executeQuery();
    		con.close();
    	} catch (ClassNotFoundException e) {
    	
    		e.printStackTrace();
    	}
		
		return res;
	}

}
