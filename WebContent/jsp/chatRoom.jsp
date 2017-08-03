
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Room</title>
</head>
<body>
	<%@include file="navigationBar.jsp" %>
	<center>
	
		<center><br><br><br>
    		<div class="container header-content">
            	<div class="row">
		            <h2 class="section-heading">Chat</h2>
                    <hr class="primary">
                    <br><br>
                    	<h2 class="section-heading">Previous Conversation</h2>
                    	<div id="showMessage">
                    	</div>
                    	
                    	<%
                    
	           			session.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
	                    session.setAttribute("friendUsername", session.getAttribute("friendUsername"));
	                    request.setAttribute("loggedInUser", request.getAttribute("loggedInUser"));
	                    request.setAttribute("friendUsername", request.getAttribute("friendUsername"));
	                    session.setAttribute("chat_id", session.getAttribute("chat_id"));
	                    request.setAttribute("chat_id", request.getAttribute("chat_id"));
            		
            		
                    %>
						<form action="sendMessage1" method="post"  modelAttribute="sendMessageBean">
						
							<span class="style1" class="sr-only" style="color:GRAY; font-size:18px;"><b>Type your message here:</b></span>
							<br><textarea class="form-control" style="width:50%;" rows="6" id="message" placeholder="Enter your message to <%=session.getAttribute("friendUsername")%> here.." name="message" ></textarea><br>
							
							<input type="submit" value="Send" style="width:20%;" class="btn btn-md btn-primary btn-block" /><br><br><br>
						</form>
               </div>
         	</div>
         </center>
		<script type="text/javascript">
 
            var auto_refresh = setInterval(
            function ()
            {
                $('#showMessage').load('getChatRoomMessage');
            }, 1000); 
        </script>
	</center>
</body>
</html>