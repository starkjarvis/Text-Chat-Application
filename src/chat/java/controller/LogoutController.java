package chat.java.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class LogoutController {
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException
	{
		ModelAndView model = new ModelAndView("login");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
		String query="update login set status=? where email=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, "offline");
		ps.setString(2, session.getAttribute("loggedInUser").toString());
		ps.executeUpdate();
		session.invalidate();
		return model;
	}
}
