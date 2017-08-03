<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat with a Friend</title>
</head>
<body>
	
	<%@include file="navigationBar.jsp" %>
		
		
			<center><br><br><br><br><br>
    		<div class="container header-content">
            	<div class="row">
		            <h3 style="color:RED;">${OnlineN}</h3>
		            <h2 class="section-heading">Search Friend</h2>
                    <hr class="primary">
						<form action="chatFriend" method="post"  modelAttribute="checkOnlineBean">
							<span class="style1" class="sr-only" style="color:white; font-size:18px;"><b>Username</b></span>
							<input class="form-control" style="width:50%;" id="username" placeholder="Enter your friend's email here" name="email" /><br>
							
							<input type="submit" value="Search" style="width:20%;" class="btn btn-lg btn-primary btn-block" />
						</form>
               </div>
         </div>
         </center>
		
	

</body>
</html>