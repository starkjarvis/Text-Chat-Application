<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/creative.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-striped header-fixed">
		<thead>
			<th>From</th>
			<th>Date-Time</th>
			<th>Message</th>
		</thead>
		
		<tbody>
			<%
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","root");
			String query="select * from chatRoom";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			int count=0;
			while(res.next())
			{	count++;
			
			if(count>0){
				while(res.next())
				{
				
			%>
			<tr>
				<td><%=res.getString("username") %></td>
				<td><%=res.getString("date_time") %></td>
				<td><%=res.getString("message") %></td>
			</tr>
			
			<%
				}break;
			}
			else{
					%><tr  colspan="4">
						<td>No Messages yet.</td>
					</tr><%
			}
			}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
            session.setAttribute("friendUsername", session.getAttribute("friendUsername"));
            request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
            request.setAttribute("friendUsername", request.getAttribute("friendUsername"));
            session.setAttribute("chat_id", session.getAttribute("chat_id"));
            request.setAttribute("chat_id", request.getAttribute("chat_id"));
			%>
		</tbody>
	</table>
</body>
</html>