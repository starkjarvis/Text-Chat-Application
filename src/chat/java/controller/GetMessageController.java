package chat.java.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import chat.java.viewBean.LoginBean;

@Controller
public class GetMessageController {
	
	@RequestMapping(value="/getMessage",method=RequestMethod.GET)
	public ModelAndView getMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("message");
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="select * from chat1 where from1=? or from1=? order by date_time asc";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, session.getAttribute("loggedInUser").toString());
		ps.setString(2, session.getAttribute("friendUsername").toString());
		ResultSet res=ps.executeQuery();
		
		
		while(res.next())
		{
			
			request.setAttribute("messageRes", res);
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		return model;
	}

}
